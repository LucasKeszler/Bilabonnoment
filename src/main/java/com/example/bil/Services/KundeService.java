package com.example.bil.Services;

import com.example.bil.Models.Kunde;
import com.example.bil.Repositories.KundeRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Service
public class KundeService {

    private KundeRepository kundeRepository;

    public KundeService(KundeRepository kundeRepository) {
        this.kundeRepository = kundeRepository;

    }

    public void createKunde(Kunde kunde) {
        try {
        kundeRepository.createKunde(kunde);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Kunde getKundeById(int kunde_id) {
        try {
            return kundeRepository.getKundeByID(kunde_id);
        }catch (SQLException e){
            e.printStackTrace();
            return null;
        }


    }

    public List<Kunde> getAllKunder() {
        try {
            return kundeRepository.getAllKunder();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public void updateKunde(Kunde kunde) {
        try{
            kundeRepository.updateKunde(kunde);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public void deleteKunde(int kunde_id) {
        try {
            kundeRepository.deleteKunde(kunde_id);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}