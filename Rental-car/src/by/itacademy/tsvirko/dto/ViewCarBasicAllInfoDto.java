package by.itacademy.tsvirko.dto;

import by.itacademy.tsvirko.entity.FuelType;
import by.itacademy.tsvirko.entity.ModelCar;
import by.itacademy.tsvirko.entity.Year;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewCarBasicAllInfoDto {

    private Long id;
    private String modelCarName;
    private String fuelTypeName;
    private int rentalPrice;
    private String year;
    private String description;
}