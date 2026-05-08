package com.example.bil.Models;


public enum CarStatus {
    LEDIG,
    RESERVERET,
    UDLEJET,
    TILBAGELEVERET,
    SKADET;


    public static CarStatus fromString(String value) {
        try{
            return CarStatus.valueOf(value.toUpperCase());
        } catch (Exception e) {
            throw new IllegalArgumentException("Ugyldigt status: " + value);
        }
    }
}


