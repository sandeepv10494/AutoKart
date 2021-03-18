package com.sv.autokart.dtos;

import com.sv.autokart.models.Gender;
import com.sv.autokart.models.UserRole;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private Gender gender;
    private Long phoneNumber;
    private UserRole userRole;
}
