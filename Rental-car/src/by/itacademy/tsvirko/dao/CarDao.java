package by.itacademy.tsvirko.dao;

import by.itacademy.tsvirko.connection.ConnectionPool;
import by.itacademy.tsvirko.entity.Car;
import by.itacademy.tsvirko.entity.FuelType;
import by.itacademy.tsvirko.entity.ModelCar;
import by.itacademy.tsvirko.entity.Year;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CarDao {

    private static final CarDao INSTANCE = new CarDao();

    private static final String FIND_ALL =
            "SELECT " +
                    "c.id AS car_id, " +
                    "m.id AS model_car_id, " +
                    "m.name AS model_car_name, " +
                    "f.id AS fuel_type_id, " +
                    "f.name AS fuel_type_name, " +
                    "c.rental_price, " +
                    "c.car_year, " +
                    "c.description " +
                    "FROM rental_car_storage.car c " +
                    "INNER JOIN rental_car_storage.model_car m " +
                    "ON c.model_car_id = m.id " +
                    "INNER JOIN rental_car_storage.fuel_type f " +
                    "ON c.fuel_type_id = f.id";

    private static final String SAVE =
            "INSERT INTO rental_car_storage.car (model_car_id, fuel_type_id, rental_price, car_year, description) " +
                    "VALUES (?, ?, ?, ?, ?)";

    private static final String FIND_BY_ID = FIND_ALL + " WHERE c.id = ?";

    public Car save(Car car) {
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, car.getModelCar().getId());
            preparedStatement.setLong(2, car.getFuelType().getId());
            preparedStatement.setInt(3, car.getRentalPrice());
            preparedStatement.setString(4, car.getYear().name());
            preparedStatement.setString(5, car.getDescription());

            preparedStatement.executeUpdate();

            ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                car.setId(generatedKeys.getLong("id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        try (Connection connection = ConnectionPool.getConnection();
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL);
            while (resultSet.next()) {
                Car car = getCarFromResultSet(resultSet);
                cars.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cars;
    }

    public Optional<Car> findById(Long carId) {
        Optional<Car> car = Optional.empty();
        try (Connection connection = ConnectionPool.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            preparedStatement.setLong(1, carId);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                car = Optional.of(getCarFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return car;
    }

    private Car getCarFromResultSet(ResultSet resultSet) throws SQLException {
        return Car.builder()
                .id(resultSet.getLong("car_id"))
                .modelCar(ModelCar.builder()
                        .id(resultSet.getLong("model_car_id"))
                        .name(resultSet.getString("model_car_name"))
                        .build())
                .fuelType(FuelType.builder()
                        .id(resultSet.getLong("fuel_type_id"))
                        .name(resultSet.getString("fuel_type_name"))
                        .build())
                .rentalPrice(resultSet.getInt("rental_price"))
                .year(Year.valueOf(resultSet.getString("car_year")))
                .description(resultSet.getString("description"))
                .build();
    }

    public static CarDao getInstance() {
        return INSTANCE;
    }
}