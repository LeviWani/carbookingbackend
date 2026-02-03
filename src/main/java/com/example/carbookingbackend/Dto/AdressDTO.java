package com.example.carbookingbackend.Dto;

import lombok.Data;

@Data
public class AdressDTO {
    private  String country;
    private String city;
    private String Area; //can be streetname as well
    private String houseNumber;

}
