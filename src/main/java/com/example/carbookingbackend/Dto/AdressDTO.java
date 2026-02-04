package com.example.carbookingbackend.Dto;

import com.example.carbookingbackend.Entities.UserInformation;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class AdressDTO {
    private Long addressId;

    private String country;
    private String city;
    private String area; // street name
    private String houseNumber;


    private UserInformation user;

}
