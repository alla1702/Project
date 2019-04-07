package by.itacademy.tsvirko.dto;

import by.itacademy.tsvirko.entity.Year;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateNewCarDto {

    private Long modelCarId;
    private Long fuelTypeId;
    private Integer rentalPrice;
    private Year year;
    private String description;
}