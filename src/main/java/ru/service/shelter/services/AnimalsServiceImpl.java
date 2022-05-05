package ru.service.shelter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.service.shelter.entity.Animals;
import ru.service.shelter.repositories.AnimalsRepository;

import java.util.List;

@Component
@Transactional
public class AnimalsServiceImpl implements AnimalService{
    AnimalsRepository animalsRepository;

    @Autowired
    public void setAnimalsRepository(AnimalsRepository animalsRepository) {
        this.animalsRepository = animalsRepository;
    }

    @Override
    public List<Animals> getAllAnimals() {
        return animalsRepository.findAll();
    }

    @Override
    public Animals getAnimalById(Long id) {
        return null;
    }

    @Override
    public void deleteAnimalsById(Long id) {

    }

    @Override
    public Animals updateAnimals(Long id, Animals animals) {
        return null;
    }
}
