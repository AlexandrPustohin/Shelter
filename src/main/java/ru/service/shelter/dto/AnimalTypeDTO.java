package ru.service.shelter.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import ru.service.shelter.entity.AnimalType;

@Getter
@Setter
@Builder
public class AnimalTypeDTO {
    private long id;
    private String animalType;
}
