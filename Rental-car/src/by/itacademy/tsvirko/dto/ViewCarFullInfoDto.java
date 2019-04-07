package by.itacademy.tsvirko.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewCarFullInfoDto {

    private String modelCarName;
    private String fuelTypeName;
    private int rentalPrice;
    private String year;
    private String description;
}
