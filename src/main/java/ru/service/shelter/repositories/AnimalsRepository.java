package ru.service.shelter.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.service.shelter.entity.Animals;

@Repository
public interface AnimalsRepository extends JpaRepository<Animals, Long> {


}
