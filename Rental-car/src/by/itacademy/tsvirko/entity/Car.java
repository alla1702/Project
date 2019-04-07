package by.itacademy.tsvirko.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Car {

    private Long id;
    private ModelCar modelCar;
    private FuelType fuelType;
    private Integer rentalPrice;
    private Year year;
    private String description;
}