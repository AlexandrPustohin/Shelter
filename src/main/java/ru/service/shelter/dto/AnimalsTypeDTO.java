package ru.service.shelter.dto;

import lombok.Getter;
import lombok.Setter;
import ru.service.shelter.entity.AnimalType;

@Getter
@Setter
public class AnimalsTypeDTO {
    private long id;
    private String animalType;

    public AnimalsTypeDTO(AnimalType animalType) {
        this.id = animalType.getId();
        this.animalType = animalType.getAnimalType();
    }
}
