package ru.service.shelter.entity;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "animals")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Animal {
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
}
