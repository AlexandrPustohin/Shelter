package ru.service.shelter.dto;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import ru.service.shelter.entity.Animals;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class AnimalsDTO {
    private  long id;
    private String animalType;
    private String animalGender;
    private Date dateOfReception;
    private String description;

    public AnimalsDTO(Animals animals) {
        this.id = animals.getId();
        this.animalType = animals.getAnimalType().getAnimalType();
        this.animalGender = animals.getAnimalGender().getTitle();
        this.dateOfReception = animals.getDateOfReception();
        this.description = animals.getDescription();
    }

    public AnimalsDTO(String animalType, String animalGender, Date dateOfReception, String description) {
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

    public Date getDateOfReception() {
        return dateOfReception;
    }

    public void setDateOfReception(Date dateOfReception) {
        this.dateOfReception = dateOfReception;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
