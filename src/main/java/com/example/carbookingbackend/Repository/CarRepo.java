package com.example.carbookingbackend.Repository;

import com.example.carbookingbackend.Entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepo extends JpaRepository<Car,Long> {
    List<Car> findByUser_Id(Long userId);
}
