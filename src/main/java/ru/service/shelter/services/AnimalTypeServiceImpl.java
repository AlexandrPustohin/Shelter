package ru.service.shelter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.service.shelter.dto.AnimalsDTO;
import ru.service.shelter.dto.AnimalsTypeDTO;
import ru.service.shelter.entity.AnimalType;
import ru.service.shelter.repositories.AnimalTypeRepository;

import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class AnimalTypeServiceImpl implements AnimalTypeService{
    AnimalTypeRepository animalTypeRepository;

    @Autowired
    public void setAnimalTypeRepository(AnimalTypeRepository animalTypeRepository) {
        this.animalTypeRepository = animalTypeRepository;
    }

    @Override
    public List<AnimalsTypeDTO> getAllAnimalTypes() {
        List<AnimalsTypeDTO> animalsList = animalTypeRepository.findAll().stream()
                .map(type -> new AnimalsTypeDTO(type))
                .collect(Collectors.toList());
        return animalsList;
    }

    @Override
    public String getTypeById(long id) {
        return null;
    }

    @Override
    public void addNewType(String type) {
       animalTypeRepository.save(new AnimalType(type));
    }
}
