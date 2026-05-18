package com.example.bil.Models;

public class Medarbejder {

    private int medarbejderId;
    private String username;
    private String password;
    private Rolle rolle;

    public Medarbejder(int medarbejderId, String username, String password, Rolle rolle) {
     this.medarbejderId = medarbejderId;
     this.username = username;
     this.password = password;
     this.rolle = rolle;
    }

    public int getMedarbejderId() {
        return medarbejderId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Rolle getRolle() {
        return rolle;
    }
}
