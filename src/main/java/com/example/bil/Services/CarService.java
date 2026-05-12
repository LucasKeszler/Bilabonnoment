package com.example.bil.Services;

import com.example.bil.Models.Car;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private UserRepository userRepository;

    public CarService(UserRepository userRepository) {this.userRepository = userRepository;

    }

    public void createCar() {


    }

    public List<Car> getAllCars() {

    }

    public ? getCarById() {

    }

    public ? updateCarStatus() {

    }

    public ? deleteCar() {

    }

    public ? getAvailableCars() {

    }

    public ? getCarsByStatus() {

    }
}
