package com.example.bil.Repositories;

import com.example.bil.Models.Medarbejder;
import com.example.bil.Models.Rolle;
import com.example.bil.Utillity.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Locale;

@Repository
public class MedarbejderRepository {

    public Medarbejder getMedarbejderByUsername(String username) throws SQLException {
        Connection database = new ConnectionManager().getConnection();

        PreparedStatement preparedStatement = database.prepareStatement(
                "SELECT * FROM medarbejder WHERE username = ?"
        );

        preparedStatement.setString(1, username);

        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            Rolle rolle = Rolle.valueOf(rs.getString("rolle"));

            return new Medarbejder(
                    rs.getInt("medarbejder_id"),
                    rs.getString("username"),
                    rs.getString("password"),
                    rolle
            );
        }

        return null;
    }
}
