package com.sv.autokart.services;

import com.sv.autokart.dtos.RegisterRequest;
import com.sv.autokart.dtos.UserResponse;
import com.sv.autokart.dtos.UsersListResponse;
import com.sv.autokart.exceptions.SpringAutoKartException;
import com.sv.autokart.mapper.UserMapper;
import com.sv.autokart.models.User;
import com.sv.autokart.models.UserAddress;
import com.sv.autokart.repositories.UserAddressRepository;
import com.sv.autokart.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserAddressRepository userAddressRepository;
    private final UserMapper usersMapper;

    @Transactional(readOnly = true)
    public List<UsersListResponse> getAllUsers(){
        return userRepository.findAll().stream().map(usersMapper::mapUsersToDto).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public UserResponse getUser(Long id){
        User user = userRepository.findById(id).orElseThrow(()->new SpringAutoKartException(id.toString()));
        return usersMapper.mapUserToDto(user);
    }

    @Transactional
    public UserResponse updateUser(Long id, RegisterRequest updateUserRequest){
        User user = userRepository.findById(id).orElseThrow(()->new SpringAutoKartException((id.toString())));
        user.setUserRole(updateUserRequest.getUserRole());
        user.setGender(updateUserRequest.getGender());
        user.setEmail(updateUserRequest.getEmail());
        user.setPhoneNumber(updateUserRequest.getPhoneNumber());
        user.setFirstName(updateUserRequest.getFirstName());
        user.setLastName(updateUserRequest.getLastName());
        userRepository.save(user);
        return usersMapper.mapUserToDto(user);
    }

    @Transactional
    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<UserAddress> getAllUserAddressByUserId(Long userId){
        return userAddressRepository.findAllByUserId(userId);
    }

    @Transactional
    public void saveUserAddress(UserAddress newUserAddressRequest){
        UserAddress userAddress = new UserAddress();
        setUserAddress(newUserAddressRequest, userAddress);
    }

    @Transactional
    public void updateUserAddress(Long addressId, UserAddress updateUseraddressRequest){
        UserAddress userAddress = userAddressRepository.findById(addressId).orElseThrow(()->new SpringAutoKartException((addressId.toString())));
        setUserAddress(updateUseraddressRequest, userAddress);
    }

    @Transactional
    public void deleteUserAddress(Long addressId){
        userAddressRepository.deleteById(addressId);
    }

    private void setUserAddress(UserAddress updateUseraddressRequest, UserAddress userAddress) {
        userAddress.setUserId(updateUseraddressRequest.getUserId());
        userAddress.setName(updateUseraddressRequest.getName());
        userAddress.setAddressType(updateUseraddressRequest.getAddressType());
        userAddress.setAddress(updateUseraddressRequest.getAddress());
        userAddress.setCity(updateUseraddressRequest.getCity());
        userAddress.setState(updateUseraddressRequest.getState());
        userAddress.setPincode(updateUseraddressRequest.getPincode());
        userAddress.setPhoneNumber(updateUseraddressRequest.getPhoneNumber());

        userAddressRepository.save(userAddress);
    }

}
