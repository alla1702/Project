package by.itacademy.tsvirko.service;

import by.itacademy.tsvirko.dao.UserDao;
import by.itacademy.tsvirko.dto.*;
import by.itacademy.tsvirko.entity.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class UserService {

    private static final UserService INSTANCE = new UserService();

    public List<ViewUserBasicInfoDto> findAll() {
        return UserDao.getInstance().findAll().stream()
                .map(it -> new ViewUserBasicInfoDto(it.getId(), it.getUsername()))
                .collect(Collectors.toList());
    }

    public ViewUserFullInfoDto findById(Long userId) {
        return UserDao.getInstance().findById(userId)
                .map(it -> ViewUserFullInfoDto.builder()
                        .username(it.getUsername())
                        .password(it.getPassword())
                        .role(it.getRole().getValue())
                        .build())
                .orElse(null);
    }

    public ViewUserBasicInfoDto save(CreateNewUserDto dto) {
        User savedUser = UserDao.getInstance().save(
                User.builder()
                        .username(dto.getUsername())
                        .password(dto.getPassword())
                        .role(dto.getRole())
                        .build());

        return new ViewUserBasicInfoDto(savedUser.getId(), savedUser.getUsername());
    }

    public static UserService getInstance() {
        return INSTANCE;
    }
}