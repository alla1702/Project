package by.itacademy.tsvirko.dao;

import by.itacademy.tsvirko.connection.ConnectionPool;
import by.itacademy.tsvirko.entity.FuelType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FuelTypeDao {

    private static final FuelTypeDao INSTANCE = new FuelTypeDao();

    private static final String FIND_ALL = "SELECT id, name FROM rental_car_storage.fuel_type";

    public List<FuelType> findAll() {
        List<FuelType> fuelTypes = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()) {
                FuelType fuelType = FuelType.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .build();
                fuelTypes.add(fuelType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return fuelTypes;
    }

    public static FuelTypeDao getInstance() {
        return INSTANCE;
    }
}