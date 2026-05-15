package com.example.bil.Repositories;

import com.example.bil.Models.Car;
import com.example.bil.Models.CarStatus;
import com.example.bil.Utillity.ConnectionManager;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.sql.PreparedStatement.*;

@Repository
public class CarRepository {

    public void createCar(Car car) throws SQLException {
        Connection database = new ConnectionManager().getConnection();

        try {
            PreparedStatement preparedStatement = database.prepareStatement(
                    "INSERT INTO bil(bil_id, vognummer, stelnummer, maerke, model, nummerplade, status, lokation) VALUES (?,?,?,?,?,?,?,?)"
            );

            preparedStatement.setInt(1, car.getBil_id());
            preparedStatement.setString(2, car.getVognummer());
            preparedStatement.setString(3, car.getStelnummer());
            preparedStatement.setString(4, car.getMaerke());
            preparedStatement.setString(5, car.getModel());
            preparedStatement.setString(6, car.getNummerplade());
            preparedStatement.setString(7, car.getStatus().name());
            preparedStatement.setString(8, car.getLokation());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Kunne ikke oprette bil");
        }
    }

    public String getMostRentedCarBrand() throws SQLException {
        Connection database = new ConnectionManager().getConnection();

        PreparedStatement preparedStatement = database.prepareStatement(
                "SELECT maerke, COUNT(*) as antal" +
                        "FROM bil WHERE status = 'UDLEJET'" +
                        "GROUP BY maerke ORDER BY antal DESC LIMIT 1"
        );

        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            return rs.getString("maerke");
        }
        return null;
    }

    public Car getCarById(int bil_id) throws SQLException {
        Connection database = new ConnectionManager().getConnection();
        Car car = null;

        PreparedStatement preparedStatement = database.prepareStatement(
                "SELECT * FROM bil WHERE bil_id = ?"
        );

        preparedStatement.setInt(1, bil_id);

        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {

            CarStatus status = CarStatus.valueOf(rs.getString("status"));

            car = new Car(
                    rs.getInt("bil_id"),
                    rs.getString("vognummer"),
                    rs.getString("stelnummer"),
                    rs.getString("maerke"),
                    rs.getString("model"),
                    rs.getString("nummerplade"),
                    status,
                    rs.getString("lokation")
            );
        }
        return car;
    }

    public void updateCarStatus(int bil_id, CarStatus status) throws SQLException {
        Connection database = new ConnectionManager().getConnection();


        PreparedStatement preparedStatement = database.prepareStatement(
                "UPDATE bil SET status = ? WHERE bil_id = ?"
        );

        preparedStatement.setString(1, status.name());
        preparedStatement.setInt(2, bil_id);

        preparedStatement.executeUpdate();
    }

    public List<Car> getAllCars() throws SQLException {
        Connection database = new ConnectionManager().getConnection();

        List<Car> cars = new ArrayList<>();

        PreparedStatement preparedStatement = database.prepareStatement(
                "SELECT * FROM bil"
        );

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {

            CarStatus status = CarStatus.valueOf(rs.getString("status"));

            Car car = new Car(
                    rs.getInt("bil_id"),
                    rs.getString("vognummer"),
                    rs.getString("stelnummer"),
                    rs.getString("maerke"),
                    rs.getString("model"),
                    rs.getString("nummerplade"),
                    status,
                    rs.getString("lokation")
            );

            cars.add(car);
        }
        return cars;
    }

    public void deleteCar(int bil_id) throws SQLException {
        Connection database = new ConnectionManager().getConnection();

        PreparedStatement preparedStatement = database.prepareStatement(
                "DELETE FROM bil WHERE bil_id = ?"
        );
        preparedStatement.setInt(1, bil_id);
        preparedStatement.executeUpdate();
    }
    public List<Car> getCarsByStatus (CarStatus status) throws SQLException {
        Connection database = new ConnectionManager().getConnection();
        List<Car> cars = new ArrayList<>();
        PreparedStatement preparedStatement = database.prepareStatement(
                "SELECT * FROM bil WHERE status = ?"
        );
        preparedStatement.setString(1, status.name());
        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {

            Car car = new Car(
                    rs.getInt("bil_id"),
                    rs.getString("vognummer"),
                    rs.getString("stelnummer"),
                    rs.getString("maerke"),
                    rs.getString("model"),
                    rs.getString("nummerplade"),
                    CarStatus.valueOf(rs.getString("status")),
                    rs.getString("lokation")
                    );
            cars.add(car);
        }
        return cars;
    }

    public List<Car> getBilerMedSkader() throws SQLException {
        Connection database = new ConnectionManager().getConnection();

        List<Car> skadetCars = new ArrayList<>();

        PreparedStatement preparedStatement = database.prepareStatement(
                "SELECT * FROM bil WHERE status = 'SKADET'"
        );

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {

            CarStatus status = CarStatus.valueOf(rs.getString("status"));

            Car car = new Car(
                    rs.getInt("bil_id"),
                    rs.getString("vognummer"),
                    rs.getString("stelnummer"),
                    rs.getString("maerke"),
                    rs.getString("model"),
                    rs.getString("nummerplade"),
                    status,
                    rs.getString("lokation")
            );

            skadetCars.add(car);
        }

        return skadetCars;
    }

    public List<Car> getTilbageleveredeBiler() throws SQLException {
        Connection database = new ConnectionManager().getConnection();

        List<Car> tilbageLeveretBiler = new ArrayList<>();

        PreparedStatement preparedStatement = database.prepareStatement(
                "SELECT * FROM bil WHERE status = 'TILBAGELEVERET'"
        );

        ResultSet rs = preparedStatement.executeQuery();

        while (rs.next()) {

            CarStatus status = CarStatus.valueOf(rs.getString("status"));

            Car car = new Car(
                    rs.getInt("bil_id"),
                    rs.getString("vognummer"),
                    rs.getString("stelnummer"),
                    rs.getString("maerke"),
                    rs.getString("model"),
                    rs.getString("nummerplade"),
                    status,
                    rs.getString("lokation")
            );

            tilbageLeveretBiler.add(car);
        }

        return tilbageLeveretBiler;
    }

    public int getAntalTilbageleveredeBiler() throws SQLException {
        Connection database = new ConnectionManager().getConnection();

        PreparedStatement preparedStatement = database.prepareStatement(
                "SELECT COUNT(*) AS total FROM bil WHERE status = 'TILBAGELEVERET'"
        );

        ResultSet rs = preparedStatement.executeQuery();

        if (rs.next()) {
            return rs.getInt("total");
        }

        return 0;
    }
}




