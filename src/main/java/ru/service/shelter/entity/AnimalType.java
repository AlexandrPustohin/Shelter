package ru.service.shelter.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "animal_type")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnimalType {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "animal_type")
    private String animalType;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_id")
    private List<Animal> animals;

    public AnimalType(String animalType) {
        this.animalType = animalType;
    }
}
