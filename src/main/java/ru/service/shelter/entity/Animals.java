package ru.service.shelter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "animals")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Animals {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private AnimalType animalType;

    @Column(name = "gender")
    private AnimalGender animalGender;

    @Column(name = "date_reception")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat (pattern="yyyy-MM-dd")
    private Date dateOfReception;

    @Column(name = "description")
    private String description;

    public Animals(AnimalType animalType, AnimalGender animalGender, Date dateOfReception, String description) {
        this.animalType = animalType;
        this.animalGender = animalGender;
        this.dateOfReception = dateOfReception;
        this.description = description;
    }
}
