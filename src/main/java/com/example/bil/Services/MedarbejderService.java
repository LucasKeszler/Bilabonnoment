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

    public Medarbejder login(String username, String password) {
        try {
            System.out.println("LOGIN input username = [" + username + "]");
            System.out.println("LOGIN input password = [" + password + "]");

            Medarbejder medarbejder = medarbejderRepository.getMedarbejderByUsername(username);

            if (medarbejder == null) {
                System.out.println("LOGIN: Ingen medarbejder fundet");
                return null;
            }

            System.out.println("LOGIN DB username = [" + medarbejder.getUsername() + "]");
            System.out.println("LOGIN DB password = [" + medarbejder.getPassword() + "]");
            System.out.println("LOGIN DB rolle = [" + medarbejder.getRolle() + "]");

            if (medarbejder.getPassword().equals(password)) {
                System.out.println("LOGIN: Success");
                return medarbejder;
            }

            System.out.println("LOGIN: Password matcher ikke");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
