package ru.service.shelter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private Date dateOfReception;

    @Column(name = "description")
    private String description;


}
