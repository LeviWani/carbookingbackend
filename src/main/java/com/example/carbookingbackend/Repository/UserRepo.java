package com.example.carbookingbackend.Repository;

import com.example.carbookingbackend.Entities.UserInformation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<UserInformation,Integer> {
}
