package by.itacademy.tsvirko.service;

import by.itacademy.tsvirko.dao.FuelTypeDao;
import by.itacademy.tsvirko.entity.FuelType;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class FuelTypeService {

    private static final FuelTypeService INSTANCE = new FuelTypeService();

    public List<FuelType> findAll() {
        return FuelTypeDao.getInstance().findAll();
    }

    public static FuelTypeService getInstance() {
        return INSTANCE;
    }
}
