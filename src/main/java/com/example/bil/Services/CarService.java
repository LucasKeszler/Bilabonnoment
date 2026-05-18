package com.example.bil.Services;

import com.example.bil.Models.Car;
import com.example.bil.Models.CarStatus;
import com.example.bil.Repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void createCar(Car car) {
        try {
            carRepository.createCar(car);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Car> getAllCars() {
        try{
            return carRepository.getAllCars();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Car getCarById(int bil_id) {
        try {
            return carRepository.getCarById(bil_id);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateCarStatus( int bil_id, CarStatus status){
        try {
            carRepository.updateCarStatus(bil_id, status);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void deleteCar(int bil_id) {
        try {
            carRepository.deleteCar(bil_id);
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Car> getAvailableCars() {
        try {
           return carRepository.getAvailableCars();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Car> getCarsByStatus(CarStatus status) {
        try{
            return carRepository.getCarsByStatus(status);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
