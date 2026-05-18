package com.example.bil.Services;

import com.example.bil.Models.Car;
import com.example.bil.Models.LejeAftale;
import com.example.bil.Models.LejeStatus;
import com.example.bil.Repositories.CarRepository;
import com.example.bil.Repositories.LejeAftaleRepository;
import org.springframework.stereotype.Service;
import java.sql.SQLException;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

@Service
public class LejeaftaleService {

    private final CarRepository carRepository;
    private LejeAftaleRepository lejeAftaleRepository;

    public LejeaftaleService(LejeAftaleRepository lejeAftaleRepository, CarRepository carRepository) {
        this.lejeAftaleRepository = lejeAftaleRepository;
        this.carRepository = carRepository;
    }

    public void createLejeAftale(LejeAftale lejeAftale) {
        try {
            Car car = carRepository.getCarById(lejeAftale.getBil_id());

            double pris = calculatePrice(car.getMaanedspris(), lejeAftale);

            lejeAftale.setPris(pris);

            lejeAftaleRepository.createLejeaftale(lejeAftale);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<LejeAftale> getAlleLejeaftaler() {
        try {
            return lejeAftaleRepository.getAlleLejeaftaler();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }


    }

    public LejeAftale getLejeAftaleById(int lejeaftale_id) {
        try{
            return lejeAftaleRepository.getLejeAftaleById(lejeaftale_id);
        } catch (SQLException e){
            e.printStackTrace();
            return null;
        }

    }

    public List<LejeAftale> getActiveLejeaftaler() {
        try {
            return lejeAftaleRepository.getActiveLejeaftaler();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void updateLejeAftaleStatus(int lejeAftale_id, LejeStatus status) {
        try {
            lejeAftaleRepository.updateLejeStatus(lejeAftale_id, status);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteLejeAftale(int lejeaftale_id) {
        try {
            lejeAftaleRepository.deleteLejeAftale(lejeaftale_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public double calculatePrice(double maanedspris, LejeAftale lejeAftale) {

        Period period = Period.between(
                lejeAftale.getStartdato(),
                lejeAftale.getSlutdato()
        );

        int antalMaaneder = (period.getYears() * 12) + period.getMonths();

        if (antalMaaneder < 3) {
            throw new IllegalArgumentException("Minimum lejeperiode er 3 måneder");
        }

        if (antalMaaneder > 36) {
            throw new IllegalArgumentException("Maksimum lejeperiode er 36 måneder");
        }

        double samletPris = maanedspris * antalMaaneder;

        if (antalMaaneder >= 24) {
            samletPris *= 0.9;
        } else if (antalMaaneder >= 12) {
            samletPris *= 0.95;
        }

        return samletPris;
    }
}