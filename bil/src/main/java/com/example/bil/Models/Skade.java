package com.example.bil.Models;

import java.time.LocalDate;

public class Skade {
    private int skade_id;
    private int lejeaftale_id;
    private String beskrivelse;
    private double pris;
    private LocalDate dato;

    public Skade(int skadeId, int lejeaftaleId, String beskrivelse, double pris, LocalDate dato) {
    }

    public int getSkade_id() {
        return skade_id;
    }

    public void setSkade_id(int skade_id) {
        this.skade_id = skade_id;
    }

    public int getLejeaftale_id() {
        return lejeaftale_id;
    }

    public void setLejeaftale_id(int lejeaftale_id) {
        this.lejeaftale_id = lejeaftale_id;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public LocalDate getDato() {
        return dato;
    }

    public void setDato(LocalDate dato) {
        this.dato = dato;
    }
}
