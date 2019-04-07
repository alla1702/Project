package by.itacademy.tsvirko.dto;

import by.itacademy.tsvirko.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateNewUserDto {

    private String username;
    private String password;
    private Role role;
}