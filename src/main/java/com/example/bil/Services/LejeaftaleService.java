package com.example.bil.Services;

import com.example.bil.Models.LejeAftale;
import com.example.bil.Repositories.LejeAftaleRepository;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class LejeaftaleService {

    private LejeAftaleRepository lejeAftaleRepository;

    public LejeaftaleService(LejeAftaleRepository lejeAftaleRepository) {
        this.lejeAftaleRepository = lejeAftaleRepository;
    }

    public void createLejeAftale() {
        try {
            lejeAftaleRepository.getAntalUdlejedeBiler();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<LejeAftale> getAlleLejeaftaler() {
        try {
            lejeAftaleRepository.getAlleLejeaftaler();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    public LejeAftale getLejeAftaleById() {
        try{
            lejeAftaleRepository.getLejeAftaleById(int lejeaftale_id);

        } catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public List<LejeAftale> getActiveLejeaftaler() {
        try {
            lejeAftaleRepository.getActiveLejeaftaler();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return new ArrayList<>();
    }

    public updateLejeAftaleStatus() {

    }

    public deleteLejeAftale() {

    }

    public calculatePris() {

    }
}