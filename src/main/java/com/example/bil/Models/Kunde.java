package com.example.bil.Models;

public class Kunde {
    private int kunde_id;
    private String navn;
    private String email;
    private String telefon;

    public Kunde(int kunde_id, String navn, String email, String telefon) {
        this.kunde_id= kunde_id;
        this.navn = navn;
        this.email = email;
        this.telefon = telefon;
    }

    public int getKunde_id() {
        return kunde_id;
    }

    public String getNavn() {
        return navn;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setKunde_id(int kunde_id) {
        this.kunde_id = kunde_id;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }
}
