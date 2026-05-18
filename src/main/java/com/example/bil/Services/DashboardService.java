package com.example.bil.Services;

import com.example.bil.Models.Car;
import com.example.bil.Repositories.CarRepository;
import com.example.bil.Repositories.KundeRepository;
import com.example.bil.Repositories.LejeAftaleRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService {

    private CarRepository carRepository;
    private LejeAftaleRepository lejeAftaleRepository;
    private KundeRepository kundeRepository;

    public DashboardService(CarRepository carRepository, LejeAftaleRepository lejeAftaleRepository, KundeRepository kundeRepository) {
        this.carRepository = carRepository;
        this.kundeRepository = kundeRepository;
        this.lejeAftaleRepository = lejeAftaleRepository;
    }

    public int getAntalUdlejedeBiler() {
        try {
            return lejeAftaleRepository.getAntalUdlejedeBiler();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return 0;
    }

    public double getSamletPrisAktiveLejeaftaler() {
        try {
            return lejeAftaleRepository.getSamletPrisAktiveLejeaftaler();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public double getIndtjeningDenneMaaned() {
        try {
            return lejeAftaleRepository.getIndtjeningDenneMaaned();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public int getAntalTilbageleveredeBiler() {
        try {
            return carRepository.getAntalTilbageleveredeBiler();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public List<Car> getBilerMedSkader() {
        try {
            return carRepository.getBilerMedSkader();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public List<Car> getTilbageleveredeBiler() {
        try {
            return carRepository.getTilbageleveredeBiler();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}