package com.sv.autokart.controllers;

import com.sv.autokart.dtos.RegisterRequest;
import com.sv.autokart.dtos.UserResponse;
import com.sv.autokart.dtos.UsersListResponse;
import com.sv.autokart.models.UserAddress;
import com.sv.autokart.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UsersListResponse>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUser(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody RegisterRequest updateUserRequest){
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id,updateUserRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userService.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully");
    }

    @GetMapping("/address/{userid}")
    public ResponseEntity<List<UserAddress>> getUserAddresses(@PathVariable Long userid){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUserAddressByUserId(userid));
    }

    @PostMapping("/address")
    public ResponseEntity<String> saveUserAddress(@RequestBody UserAddress userAddress){
        userService.saveUserAddress(userAddress);
        return ResponseEntity.status(HttpStatus.CREATED).body("Address created successfully");
    }

    @PutMapping("/address/{addressId}")
    public ResponseEntity<String> updateUserAddress(@PathVariable Long addressId, @RequestBody UserAddress updateUserAddressRequest){
        userService.updateUserAddress(addressId, updateUserAddressRequest);
        return ResponseEntity.status(HttpStatus.OK).body("Address updated successfully");
    }

    @DeleteMapping("/address/{addressId}")
    public ResponseEntity<String> deleteUserAddress(@PathVariable Long addressId){
        userService.deleteUserAddress(addressId);
        return ResponseEntity.status(HttpStatus.OK).body("Address deleted successfully");
    }
}
