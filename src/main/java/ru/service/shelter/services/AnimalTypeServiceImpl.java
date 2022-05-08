package ru.service.shelter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.service.shelter.dto.FactoryAnimalTypeDTO;
import ru.service.shelter.entity.AnimalType;
import ru.service.shelter.exseption.ResourceNotFoundException;
import ru.service.shelter.repositories.AnimalTypeRepository;

import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class AnimalTypeServiceImpl implements AnimalTypeService{
    AnimalTypeRepository animalTypeRepository;
    FactoryAnimalTypeDTO factoryAnimalTypeDTO;

    @Autowired
    public void setFactoryAnimalTypeDTO(FactoryAnimalTypeDTO factoryAnimalTypeDTO) {
        this.factoryAnimalTypeDTO = factoryAnimalTypeDTO;
    }

    @Autowired
    public void setAnimalTypeRepository(AnimalTypeRepository animalTypeRepository) {
        this.animalTypeRepository = animalTypeRepository;
    }

    @Override
    public List<AnimalType> getAllAnimalTypes() {
        return animalTypeRepository.findAll();
    }

    @Override
    public String getTypeById(long id) {
        return animalTypeRepository.getById(id).getAnimalType();
    }

    @Override
    public void addNewType(String type) {
        Optional<AnimalType> animalType = Optional.ofNullable(animalTypeRepository.findByAnimalType(type));
        if(!animalType.isPresent()){
            animalTypeRepository.save(new AnimalType(type));
        }
    }

    @Override
    public AnimalType getTypeByName(String type) throws ResourceNotFoundException {
        Optional<AnimalType> animalType = Optional.of(animalTypeRepository.findByAnimalType(type));
        if(!animalType.isPresent()) throw new ResourceNotFoundException("Не найдено в БД");
        return animalType.get();
    }
}
