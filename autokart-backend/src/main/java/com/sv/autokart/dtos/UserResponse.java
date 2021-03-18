package com.sv.autokart.dtos;

import com.sv.autokart.models.Gender;
import com.sv.autokart.models.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponse {
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private UserRole role;
    private Gender gender;
    private Long phoneNumber;
}
