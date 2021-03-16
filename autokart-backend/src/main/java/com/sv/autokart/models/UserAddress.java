package com.sv.autokart.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userAddressId;
    private Long userId;
    private String name;
    private String phoneNumber;
    private Long pincode;
    private String address;
    private String city;
    private String state;
    private String addressType;

}
