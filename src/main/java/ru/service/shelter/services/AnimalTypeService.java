package ru.service.shelter.services;

import ru.service.shelter.entity.AnimalType;
import ru.service.shelter.exseption.ResourceNotFoundException;

import java.util.List;

public interface AnimalTypeService {
    List<AnimalType> getAllAnimalTypes();
    String getTypeById(long id);
    void addNewType(String type);
    AnimalType getTypeByName(String type) throws ResourceNotFoundException;
}
