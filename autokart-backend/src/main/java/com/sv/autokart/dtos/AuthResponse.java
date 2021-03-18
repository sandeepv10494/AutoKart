package com.sv.autokart.dtos;

import com.sv.autokart.models.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AuthResponse {
    private String authenticationToken;
    private String refreshToken;
    private Instant expiresAt;
    private String firstName;
    private String lastName;
    private Integer cartItems;
    private Integer wishListedItems;
    private UserRole role;
}
