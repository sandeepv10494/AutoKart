package com.sv.autokart.services;

import com.sv.autokart.dtos.AuthResponse;
import com.sv.autokart.dtos.LoginRequest;
import com.sv.autokart.dtos.RefreshTokenRequest;
import com.sv.autokart.dtos.RegisterRequest;
import com.sv.autokart.exceptions.SpringAutoKartException;
import com.sv.autokart.models.*;
import com.sv.autokart.repositories.CartItemRepository;
import com.sv.autokart.repositories.UserRepository;
import com.sv.autokart.repositories.VerificationTokenRepository;
import com.sv.autokart.repositories.WishlistRepository;
import com.sv.autokart.security.JwtProvider;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class AuthService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;
    private final VerificationTokenRepository verificationTokenRepository;
    private final MailService mailService;
    private final JwtProvider jwtProvider;
    private final RefreshTokenService refreshTokenService;
    private final AuthenticationManager authenticationManager;
    private final CartItemRepository cartItemRepository;
    private final WishlistRepository wishlistRepository;

    @Transactional
    public void signUp(RegisterRequest registerRequest){
        User user = new User();
        user.setEmail(registerRequest.getEmail());
        user.setFirstName(registerRequest.getFirstName());
        user.setLastName(registerRequest.getLastName());
        user.setGender(registerRequest.getGender());
        user.setPhoneNumber(registerRequest.getPhoneNumber());
        user.setUserRole(registerRequest.getUserRole());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        user.setCreated(Instant.now());
        user.setEnabled(false);

        userRepository.save(user);

        String token = generateVerificationToken(user);
        mailService.sendMail(new NotificationEmail("Please Activate your Account",
                user.getEmail(), "Thank you for signing up to Spring Reddit, " +
                "please click on the below url to activate your account : " +
                "http://localhost:8080/api/auth/accountVerification/" + token));
    }

    private String generateVerificationToken(User user) {
        String token = UUID.randomUUID().toString();
        VerificationToken verificationToken = new VerificationToken();
        verificationToken.setToken(token);
        verificationToken.setUser(user);

        verificationTokenRepository.save(verificationToken);
        return token;
    }

    public void verifyAccount(String token){
        Optional<VerificationToken> verificationToken = verificationTokenRepository.findByToken(token);
        fetchUserandEnable(verificationToken.orElseThrow(() -> new SpringAutoKartException("Invalid token")));
    }

    private void fetchUserandEnable(VerificationToken verificationToken){
        String email = verificationToken.getUser().getEmail();
        User user = userRepository.findByEmail(email).orElseThrow(()->new SpringAutoKartException("User not found with email - "+email));
        user.setEnabled(true);
        userRepository.save(user);
    }

    @Transactional()
    public User getCurrentUser() {
        org.springframework.security.core.userdetails.User principal = (org.springframework.security.core.userdetails.User) SecurityContextHolder.
                getContext().getAuthentication().getPrincipal();
        return userRepository.findByEmail(principal.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User name not found - " + principal.getUsername()));
    }

    public AuthResponse login(LoginRequest loginRequest){

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getEmail(),loginRequest.getPassword()
                ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.generateToken(authentication);

        User user = userRepository.findByEmail(loginRequest.getEmail()).orElseThrow(()->new SpringAutoKartException("User not found with email - "+loginRequest.getEmail()));

        List<CartItem> cartItems = cartItemRepository.findAllByUserId(user.getUserId());
        List<Wishlist> wishlists = wishlistRepository.findAllByUserId(user.getUserId());

        return AuthResponse.builder()
                .authenticationToken(token)
                .refreshToken(refreshTokenService.generateRefreshToken().getToken())
                .expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .role(user.getUserRole())
                .cartItems(cartItems.size())
                .wishListedItems(wishlists.size())
                .build();
    }

    public boolean isLoggedIn() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return !(authentication instanceof AnonymousAuthenticationToken) && authentication.isAuthenticated();
    }

    public AuthResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        refreshTokenService.validateRefreshToken(refreshTokenRequest.getRefreshToken());

        String token = jwtProvider.generateTokenWithUsername(refreshTokenRequest.getEmail());

        User user = userRepository.findByEmail(refreshTokenRequest.getEmail()).orElseThrow(()->new SpringAutoKartException("User not found with email - "+refreshTokenRequest.getEmail()));
        List<CartItem> cartItems = cartItemRepository.findAllByUserId(user.getUserId());
        List<Wishlist> wishlists = wishlistRepository.findAllByUserId(user.getUserId());

        return AuthResponse.builder()
                .authenticationToken(token)
                .refreshToken(refreshTokenRequest.getRefreshToken())
                .expiresAt(Instant.now().plusMillis(jwtProvider.getJwtExpirationInMillis()))
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .role(user.getUserRole())
                .cartItems(cartItems.size())
                .wishListedItems(wishlists.size())
                .build();
    }
}
