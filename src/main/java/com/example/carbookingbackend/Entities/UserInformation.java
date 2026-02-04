package com.example.carbookingbackend.Entities;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Generated;



import java.util.List;
@Entity
@Data
public class UserInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String fullName;
    private Integer phoneNumber;
    private String email;
    private String password;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;

    @OneToMany(mappedBy = "user")
    private List<Car> cars;
}



