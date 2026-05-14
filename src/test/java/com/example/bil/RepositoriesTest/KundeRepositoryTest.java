package com.example.bil.RepositoriesTest;

import com.example.bil.Repositories.KundeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KundeRepositoryTest {

    private KundeRepository kundeRepository;

    @BeforeEach
    void setup() {
        System.setProperty("DB_URL", "jdbc:h2:mem:testdb;MODE=MySQL;DB_CLOSE_DELAY=-1");
        System.setProperty("DB_USER", "sa");
        System.setProperty("DB_PASSWORD", "");

        kundeRepository = new KundeRepository();
    }

    @Test
    void testGetKundeById() {
        // test her
    }
}