package by.itacademy.tsvirko.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ViewUserFullInfoDto {

    private String username;
    private String password;
    private String role;
}