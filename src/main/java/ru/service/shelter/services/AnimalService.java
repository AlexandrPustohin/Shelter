package ru.service.shelter.services;

import ru.service.shelter.dto.AnimalsDTO;
import ru.service.shelter.dto.NewAnimal;
import ru.service.shelter.entity.Animals;

import java.util.List;

public interface AnimalService {
    List<AnimalsDTO> getAllAnimals();
    Animals getAnimalById(long id);
    void deleteAnimalsById(long id);
    void updateAnimals(NewAnimal animals);
    void addNewAnimal(NewAnimal newAnimal);
}
