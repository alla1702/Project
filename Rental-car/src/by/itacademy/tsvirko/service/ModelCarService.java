package by.itacademy.tsvirko.service;

import by.itacademy.tsvirko.dao.ModelCarDao;
import by.itacademy.tsvirko.entity.ModelCar;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ModelCarService {

    private static final ModelCarService INSTANCE = new ModelCarService();

    public List<ModelCar> findAll() {
        return ModelCarDao.getInstance().findAll();
    }

    public static ModelCarService getInstance() {
        return INSTANCE;
    }
}