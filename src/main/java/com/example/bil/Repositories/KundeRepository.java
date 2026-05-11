package com.example.bil.Repositories;

import com.example.bil.Models.Kunde;
import com.example.bil.Utillity.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class KundeRepository {

    public void createKunde(Kunde kunde) throws SQLException {
        Connection database = new ConnectionManager().getConnection();

        try {
            PreparedStatement preparedStatement = database.prepareStatement(
                    "INSERT INTO kunde (kunde_id, navn, email, telefon) VALUES (?,?,?,?)"
            );

            preparedStatement.setInt(1, kunde.getKunde_id());
            preparedStatement.setString(2, kunde.getNavn());
            preparedStatement.setString(3, kunde.getEmail());
            preparedStatement.setString(4, kunde.getEmail());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Kunne ikke oprette kunde");
        }
    }

    public Kunde getKundeByID(int kunde_id) throws SQLException {
        Connection database = new ConnectionManager().getConnection();
        Kunde kunde = null;

        PreparedStatement preparedStatement = database.prepareStatement(
                "SELECT * FROM kunde WHERE kunde_id = ?"
        );

        preparedStatement.setInt(1, kunde_id);

        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            kunde = new Kunde(
                    rs.getInt("kunde_id"),
                    rs.getString("navn"),
                    rs.getString("email"),
                    rs.getString("telefon")
            );
        }
        return kunde;
    }
}
