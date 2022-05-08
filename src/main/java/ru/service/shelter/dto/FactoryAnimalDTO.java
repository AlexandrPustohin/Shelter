package ru.service.shelter.dto;

import org.springframework.stereotype.Component;
import ru.service.shelter.entity.Animal;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FactoryAnimalDTO {

    public AnimalDTO fromAnimalToAnimalDTO(Animal animal) {
        return AnimalDTO.builder()
                .id(animal.getId())
                .animalType(animal.getAnimalType().getAnimalType())
                .dateOfReception(animal.getDateOfReception())
                .animalGender(animal.getAnimalGender().getTitle())
                .description(animal.getDescription())
                .build();
    }
    public List<AnimalDTO> createAnimalDTOList(List<Animal> products){
        return products.stream()
                .map(this::fromAnimalToAnimalDTO)
                .collect(Collectors.toList());
    }

}
