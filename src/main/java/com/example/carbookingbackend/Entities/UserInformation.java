package com.example.carbookingbackend.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import lombok.Generated;
import org.springframework.data.annotation.Id;

@Data
@Entity
public class UserInformation {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String fullname;
    private Integer phoneNumber;
    private String Email;
    private String Password;
    private Address address;
    private Car car;


}
