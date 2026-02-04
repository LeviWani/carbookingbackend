package com.example.carbookingbackend.Dto;

import lombok.Data;

@Data

public class CreateUserDto {
    private Long id;

    private String fullName;
    private Integer phoneNumber;
    private String email;
    private String password;
}
