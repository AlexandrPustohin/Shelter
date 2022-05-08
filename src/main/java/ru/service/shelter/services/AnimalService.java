package ru.service.shelter.services;

import ru.service.shelter.dto.NewAnimal;
import ru.service.shelter.entity.Animal;
import ru.service.shelter.exseption.ResourceNotFoundException;

import java.util.List;

public interface AnimalService {
    List<Animal> getAllAnimals();
    Animal getAnimalById(long id) throws ResourceNotFoundException;
    Animal deleteAnimalById(long id) throws ResourceNotFoundException;
    void updateAnimal(NewAnimal animal) throws ResourceNotFoundException;
    void addNewAnimal(NewAnimal newAnimal);
}
