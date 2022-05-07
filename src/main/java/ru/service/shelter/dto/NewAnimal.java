package ru.service.shelter.dto;

import lombok.NoArgsConstructor;
import ru.service.shelter.entity.Animals;

import java.util.Date;

@NoArgsConstructor
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAnimalType() {
        return animalType;
    }

    public void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    public String getAnimalGender() {
        return animalGender;
    }

    public void setAnimalGender(String animalGender) {
        this.animalGender = animalGender;
    }

    public String getDateOfReception() {
        return dateOfReception;
    }

    public void setDateOfReception(String dateOfReception) {
        this.dateOfReception = dateOfReception;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
