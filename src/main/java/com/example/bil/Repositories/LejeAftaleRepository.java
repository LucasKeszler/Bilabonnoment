package com.example.bil.Repositories;

import com.example.bil.Models.Car;
import com.example.bil.Models.LejeAftale;
import com.example.bil.Models.LejeStatus;
import com.example.bil.Utillity.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.time.LocalDate;
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

    public int getAntalUdlejedeBiler() throws SQLException{
        Connection database = new ConnectionManager().getConnection();

        PreparedStatement preparedStatement = database.prepareStatement(
                "SELECT COUNT(*) AS antal FROM lejeaftale WHERE status = 'AKTIV'"
        );

        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            return rs.getInt("antal");
        }

        return 0;
    }

    public double getSamletPrisAktiveLejeaftaler() throws SQLException{
        Connection database = new ConnectionManager().getConnection();

        PreparedStatement preparedStatement = database.prepareStatement(
                "SELECT SUM(pris) AS total FROM lejeaftale WHERE status = 'AKTIV'"
        );

        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            return rs.getInt("total");
        }

        return 0;
    }

    public double getIndtjeningDenneMaaned() throws SQLException {
        Connection database = new ConnectionManager().getConnection();

        LocalDate today = LocalDate.now();

        PreparedStatement preparedStatement = database.prepareStatement(
                "SELECT SUM(pris) AS total FROM lejeaftale " +
                "WHERE MONTH(startdato) = ? AND YEAR(startdato) = ?"
        );

        preparedStatement.setInt(1, today.getMonthValue());
        preparedStatement.setInt(2, today.getYear());

        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            return rs.getDouble("total");
        }

        return 0;
    }

    public LejeAftale getLejeAftaleById(int lejeaftale_id) throws SQLException{
        Connection database = new ConnectionManager().getConnection();
        LejeAftale lejeAftale = null;

        PreparedStatement preparedStatement = database.prepareStatement(
                "SELECT * FROM lejeaftale WHERE lejeaftale_id = ?"
        );

        preparedStatement.setInt(1, lejeaftale_id);
        ResultSet rs = preparedStatement.executeQuery();

        if(rs.next()) {

            LejeStatus lejeStatus = LejeStatus.valueOf(rs.getString("status"));

            lejeAftale = new LejeAftale(
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
        }
        return lejeAftale;
    }

    public void updateLejeStatus(int lejeaftale_id, LejeStatus status) throws SQLException {
        Connection database = new ConnectionManager().getConnection();

        PreparedStatement preparedStatement = database.prepareStatement(
                "UPDATE lejeaftale SET status = ? WHERE lejeaftale_id = ?"
        );

        preparedStatement.setString(1, status.name());
        preparedStatement.setInt(2, lejeaftale_id);

        preparedStatement.executeUpdate();
    }

    public void deleteLejeAftale(int lejeaftale_id) throws SQLException {
        Connection database = new ConnectionManager().getConnection();

        PreparedStatement preparedStatement = database.prepareStatement(
                "DELETE FROM lejeaftale WHERE lejaftale_id = ?"
        );

        preparedStatement.setInt(1, lejeaftale_id);

        preparedStatement.executeUpdate();
    }


}
