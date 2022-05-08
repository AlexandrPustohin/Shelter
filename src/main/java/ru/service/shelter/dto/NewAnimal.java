package ru.service.shelter.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class NewAnimal {
    private long id;
    private String animalType;
    private String animalGender;
    private String dateOfReception;
    private String description;

    public NewAnimal(String animalType, String animalGender, String dateOfReception, String description) {
        this.animalType = animalType;
        this.animalGender = animalGender;
        this.dateOfReception = dateOfReception;
        this.description = description;
    }

    public NewAnimal(long id, String animalType, String animalGender, String dateOfReception, String description) {
        this.id = id;
        this.animalType = animalType;
        this.animalGender = animalGender;
        this.dateOfReception = dateOfReception;
        this.description = description;
    }
}
