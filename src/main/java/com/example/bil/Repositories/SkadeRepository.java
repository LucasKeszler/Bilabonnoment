package com.example.bil.Repositories;

import com.example.bil.Models.Car;
import com.example.bil.Models.Skade;
import com.example.bil.Utillity.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SkadeRepository {

    public void createSkade(Skade skade) throws SQLException {
        Connection database = new ConnectionManager().getConnection();

        try {
            PreparedStatement preparedStatement = database.prepareStatement(
                    "INSERT INTO skade ( lejeaftale_id, beskrivelse, pris, dato) VALUES (?,?,?,?,?)"
            );

            preparedStatement.setInt(1, skade.getLejeaftale_id());
            preparedStatement.setString(2, skade.getBeskrivelse());
            preparedStatement.setDouble(3, skade.getPris());
            preparedStatement.setDate(4, Date.valueOf(skade.getDato()));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Kunne ikke oprette skade");
        }
    }

    public List<Skade> getSkadeByBilId(int bil_id) throws SQLException {
        Connection database = new ConnectionManager().getConnection();

        List<Skade> skader = new ArrayList<>();

        PreparedStatement preparedStatement = database.prepareStatement(
                "SELECT skade.* FROM skade" +
                "JOIN lejeaftale ON skade.lejeaftale_id = lejeaftale_id " +
                "WHERE lejeaftale.bil_id = ?"
        );

        preparedStatement.setInt(1, bil_id);

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {
            Skade skade = new Skade(
                    rs.getInt("skade_id"),
                    rs.getInt("lejeaftale_id"),
                    rs.getString("beskrivelse"),
                    rs.getDouble("pris"),
                    rs.getDate("dato").toLocalDate()
            );

            skader.add(skade);
        }
        return skader;
    }
}
