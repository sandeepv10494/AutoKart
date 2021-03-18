package com.sv.autokart.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.time.Instant;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "\"User\"")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Email
    @NotEmpty(message = "Email is Required")
    private String email;

    @NotEmpty(message = "Password is Required")
    private String password;

    private String firstName;
    private String lastName;
    private Gender gender;
    private Long phoneNumber;
    private UserRole userRole;
    private Instant created;
    private boolean enabled;
}
