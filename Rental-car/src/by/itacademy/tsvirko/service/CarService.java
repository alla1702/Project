package by.itacademy.tsvirko.service;

import by.itacademy.tsvirko.dao.CarDao;
import by.itacademy.tsvirko.dto.CreateNewCarDto;
import by.itacademy.tsvirko.dto.ViewCarBasicAllInfoDto;
import by.itacademy.tsvirko.dto.ViewCarBasicInfoDto;
import by.itacademy.tsvirko.dto.ViewCarFullInfoDto;
import by.itacademy.tsvirko.entity.Car;
import by.itacademy.tsvirko.entity.FuelType;
import by.itacademy.tsvirko.entity.ModelCar;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class CarService {

    private static final CarService INSTANCE = new CarService();

    public List<ViewCarBasicInfoDto> findAll() {
        return CarDao.getInstance().findAll().stream()
                .map(it -> new ViewCarBasicInfoDto(it.getId()))
                .collect(Collectors.toList());
    }

    public ViewCarFullInfoDto findById(Long carId) {
        return CarDao.getInstance().findById(carId)
                .map(it -> ViewCarFullInfoDto.builder()
                        .modelCarName(it.getModelCar().getName())
                        .fuelTypeName(it.getFuelType().getName())
                        .rentalPrice(it.getRentalPrice())
                        .year(it.getYear().getValue())
                        .description(it.getDescription())
                        .build())
                .orElse(null);
    }

    public ViewCarBasicInfoDto save(CreateNewCarDto dto) {
        Car savedCar = CarDao.getInstance().save(
                Car.builder()
                        .modelCar(ModelCar.builder()
                                .id(dto.getModelCarId())
                                .build())
                        .fuelType(FuelType.builder()
                                .id(dto.getFuelTypeId())
                                .build())
                        .rentalPrice(dto.getRentalPrice())
                        .year(dto.getYear())
                        .description(dto.getDescription())
                        .build());

        return new ViewCarBasicInfoDto(savedCar.getId());
    }

    public List<ViewCarBasicAllInfoDto> findAllList() {
        return CarDao.getInstance().findAll().stream()
                .map(it -> new ViewCarBasicAllInfoDto(it.getId(), it.getModelCar().getName(), it.getFuelType().getName(), it.getRentalPrice(), it.getYear().getValue(), it.getDescription()))
                .collect(Collectors.toList());
    }

    public static CarService getInstance() {
        return INSTANCE;
    }
}