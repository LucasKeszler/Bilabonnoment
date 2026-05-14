package com.example.bil.Services;

import com.example.bil.Models.Medarbejder;
import com.example.bil.Repositories.MedarbejderRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class MedarbejderService {

    private MedarbejderRepository medarbejderRepository;

    public MedarbejderService(MedarbejderRepository medarbejderRepository) {
        this.medarbejderRepository = medarbejderRepository;
    }

    public Medarbejder login (String username, String password) {
        try {
            Medarbejder medarbejder = medarbejderRepository.getMedarbejderByUsername(username);

            if (medarbejder !=null && medarbejder.getPassword().equals(password)) {
                return medarbejder;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
