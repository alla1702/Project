package by.itacademy.tsvirko.dao;

import by.itacademy.tsvirko.connection.ConnectionPool;
import by.itacademy.tsvirko.entity.ModelCar;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ModelCarDao {

    private static final ModelCarDao INSTANCE = new ModelCarDao();

    private static final String FIND_ALL = "SELECT id, name FROM rental_car_storage.model_car";

    public List<ModelCar> findAll() {
        List<ModelCar> modelCars = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()) {
                ModelCar modelCar = ModelCar.builder()
                        .id(resultSet.getLong("id"))
                        .name(resultSet.getString("name"))
                        .build();
                modelCars.add(modelCar);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return modelCars;
    }

    public static ModelCarDao getInstance() {
        return INSTANCE;
    }
}