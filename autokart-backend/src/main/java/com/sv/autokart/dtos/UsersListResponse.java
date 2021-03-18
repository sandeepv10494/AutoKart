package com.sv.autokart.dtos;

import com.sv.autokart.models.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsersListResponse {
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private UserRole role;
}
