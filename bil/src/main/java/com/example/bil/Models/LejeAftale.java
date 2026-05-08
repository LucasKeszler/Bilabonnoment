package com.example.bil.Models;

import java.time.LocalDate;

public class LejeAftale {
    private int lejeaftale_id;
    private int kunde_id;
    private int bil_id;
    private LocalDate startdato;
    private LocalDate slutdato;
    private double pris;
    private String afhentningssted;
    private String afleveringssted;
    private LejeStatus status;

    public LejeAftale(int lejeaftaleId, int kundeId, int bilId, LocalDate startdato, LocalDate slutdato, double pris, String afhentningssted, String afleveringssted, LejeStatus lejeStatus) {
    }

    public int getLejeaftale_id() {
        return lejeaftale_id;
    }

    public void setLejeaftale_id(int lejeaftale_id) {
        this.lejeaftale_id = lejeaftale_id;
    }

    public int getKunde_id() {
        return kunde_id;
    }

    public void setKunde_id(int kunde_id) {
        this.kunde_id = kunde_id;
    }

    public int getBil_id() {
        return bil_id;
    }

    public void setBil_id(int bil_id) {
        this.bil_id = bil_id;
    }

    public LocalDate getStartdato() {
        return startdato;
    }

    public void setStartdato(LocalDate startdato) {
        this.startdato = startdato;
    }

    public LocalDate getSlutdato() {
        return slutdato;
    }

    public void setSlutdato(LocalDate slutdato) {
        this.slutdato = slutdato;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public String getAfhentningssted() {
        return afhentningssted;
    }

    public void setAfhentningssted(String afhentningssted) {
        this.afhentningssted = afhentningssted;
    }

    public String getAfleveringssted() {
        return afleveringssted;
    }

    public void setAfleveringssted(String afleveringssted) {
        this.afleveringssted = afleveringssted;
    }

    public LejeStatus getStatus() {
        return status;
    }

    public void setStatus(LejeStatus status) {
        this.status = status;
    }
}
