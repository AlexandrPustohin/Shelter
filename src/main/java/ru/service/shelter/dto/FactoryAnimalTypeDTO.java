package ru.service.shelter.dto;

import org.springframework.stereotype.Component;
import ru.service.shelter.entity.AnimalType;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FactoryAnimalTypeDTO {

    public AnimalTypeDTO fromAnimalTypeToAnimalTypeDTO(AnimalType animalType) {
        return AnimalTypeDTO.builder()
                .id(animalType.getId())
                .animalType(animalType.getAnimalType())
                .build();
    }
    public List<AnimalTypeDTO> createAnimalDTOList(List<AnimalType> types){
        return types.stream()
                .map(this::fromAnimalTypeToAnimalTypeDTO)
                .collect(Collectors.toList());
    }
}
