package ru.service.shelter.dto;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class AnimalDTO {
    private  long id;
    private String animalType;
    private String animalGender;
    private Date dateOfReception;
    private String description;

    public AnimalDTO(String animalType, String animalGender, Date dateOfReception, String description) {
        this.animalType = animalType;
        this.animalGender = animalGender;
        this.dateOfReception = dateOfReception;
        this.description = description;
    }
}
