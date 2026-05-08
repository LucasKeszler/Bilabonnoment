package com.example.bil.Models;

import org.springframework.web.bind.annotation.ModelAttribute;


public class Car {
    private int bil_id;
    private String vognummer;
    private String stelnummer;
    private String maerke;
    private String model;
    private String nummerplade;
    private CarStatus status;
    private String lokation;


    public Car(int bil_id, String vognummer, String stelnummer, String maerke, String model, String nummerplade, CarStatus status, String lokation) {
        this.bil_id = bil_id;
        this.vognummer = vognummer;
        this.stelnummer = stelnummer;
        this.maerke = maerke;
        this.model = model;
        this.nummerplade = nummerplade;
        this.status = status;
        this.lokation = lokation;
    }

    public int getBil_id() {
        return bil_id;
    }

    public String getVognummer() {
        return vognummer;
    }

    public String getStelnummer() {
        return stelnummer;
    }

    public String getMaerke() {
        return maerke;
    }

    public String getModel() {
        return model;
    }

    public String getNummerplade() {
        return nummerplade;
    }

    public CarStatus getStatus() {
        return status;
    }

    public String getLokation() {
        return lokation;
    }

    public void setBil_id(int bil_id) {
        this.bil_id = bil_id;
    }

    public void setVognummer(String vognummer) {
        this.vognummer = vognummer;
    }

    public void setStelnummer(String stelnummer) {
        this.stelnummer = stelnummer;
    }

    public void setMaerke(String maerke) {
        this.maerke = maerke;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setNummerplade(String nummerplade) {
        this.nummerplade = nummerplade;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }

    public void setLokation(String lokation) {
        this.lokation = lokation;
    }
}