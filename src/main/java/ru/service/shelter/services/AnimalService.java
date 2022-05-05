package ru.service.shelter.services;

import ru.service.shelter.entity.Animals;

import java.util.List;

public interface AnimalService {
    List<Animals> getAllAnimals();
    Animals getAnimalById(Long id);
    void deleteAnimalsById(Long id);
    Animals updateAnimals(Long id, Animals animals);
}
