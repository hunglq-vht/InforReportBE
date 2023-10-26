package com.information.api.dto;

import lombok.Data;

import jakarta.validation.constraints.NotNull;

@Data
public class RegisterDto {
    @NotNull
    private String username;
    @NotNull
    private String password;
    private String fullName;
    private String identityCard;
    private String email;
    private String department;
    private String phoneNumber;
    private String address;
}
