package ru.service.shelter.services;

import ru.service.shelter.dto.AnimalsTypeDTO;
import ru.service.shelter.entity.AnimalType;

import java.util.List;

public interface AnimalTypeService {
    List<AnimalsTypeDTO> getAllAnimalTypes();
    String getTypeById(long id);
    void addNewType(String type);
}
