package com.example.bil.Repositories;

import com.example.bil.Models.LejeAftale;
import com.example.bil.Models.LejeStatus;
import com.example.bil.Utillity.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class LejeAftaleRepository {

    public void createLejeaftale(LejeAftale lejeAftale) throws SQLException {
        Connection database = new ConnectionManager().getConnection();

        try {
            PreparedStatement preparedStatement = database.prepareStatement(
                    "INSERT INTO lejeaftale(lejeaftale_id, kunde_id, bil_id, startdato, slutdato, pris, afhentningssted, afleveringssted, status) VALUES (?,?,?,?,?,?,?,?,?)"
            );

            preparedStatement.setInt(1, lejeAftale.getLejeaftale_id());
            preparedStatement.setInt(2, lejeAftale.getKunde_id());
            preparedStatement.setInt(3, lejeAftale.getBil_id());
            preparedStatement.setDate(4, Date.valueOf(lejeAftale.getStartdato()));
            preparedStatement.setDate(5, Date.valueOf(lejeAftale.getSlutdato()));
            preparedStatement.setDouble(6, lejeAftale.getPris());
            preparedStatement.setString(7, lejeAftale.getAfhentningssted());
            preparedStatement.setString(8, lejeAftale.getAfleveringssted());
            preparedStatement.setString(9, lejeAftale.getStatus().name());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Kunne ikke oprette lejeaftale");
        }
    }

    public List<LejeAftale> getAlleLejeaftaler() throws SQLException {
        Connection database = new ConnectionManager().getConnection();

        List<LejeAftale> lejeAftaler = new ArrayList<>();

        PreparedStatement preparedStatement = database.prepareStatement(
                "SELECT * FROM lejeaftale"
        );

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {

            LejeStatus lejeStatus = LejeStatus.valueOf(rs.getString("status"));

            LejeAftale lejeAftale = new LejeAftale(
                    rs.getInt("lejeaftale_id"),
                    rs.getInt("kunde_id"),
                    rs.getInt("bil_id"),
                    rs.getDate("startdato").toLocalDate(),
                    rs.getDate("slutdato").toLocalDate(),
                    rs.getDouble("pris"),
                    rs.getString("afhentningssted"),
                    rs.getString("afleveringssted"),
                    lejeStatus
            );

            lejeAftaler.add(lejeAftale);
        }

        return lejeAftaler;
    }

    public List<LejeAftale> getActiveLejeaftaler() throws SQLException {
        Connection database = new ConnectionManager().getConnection();

        List<LejeAftale> activeLejeaftaler = new ArrayList<>();

        PreparedStatement preparedStatement = database.prepareStatement(
                "SELECT * FROM lejeaftale WHERE status = 'AKTIV'"
        );

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {

            LejeStatus lejeStatus = LejeStatus.valueOf(rs.getString("status"));

            LejeAftale lejeAftale = new LejeAftale(
                    rs.getInt("lejeaftale_id"),
                    rs.getInt("kunde_id"),
                    rs.getInt("bil_id"),
                    rs.getDate("startdato").toLocalDate(),
                    rs.getDate("slutdato").toLocalDate(),
                    rs.getDouble("pris"),
                    rs.getString("afhentningssted"),
                    rs.getString("afleveringssted"),
                    lejeStatus
            );

            activeLejeaftaler.add(lejeAftale);
        }

        return activeLejeaftaler;
    }
}
