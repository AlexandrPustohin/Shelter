package ru.service.shelter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.service.shelter.dto.FactoryAnimalDTO;
import ru.service.shelter.dto.NewAnimal;
import ru.service.shelter.entity.Animal;
import ru.service.shelter.entity.AnimalGender;
import ru.service.shelter.exseption.ResourceNotFoundException;
import ru.service.shelter.repositories.AnimalTypeRepository;
import ru.service.shelter.repositories.AnimalsRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
@Transactional
public class AnimalsServiceImpl implements AnimalService{
    AnimalsRepository animalsRepository;
    AnimalTypeRepository animalTypeRepository;
    FactoryAnimalDTO factoryAnimalDTO;

    @Autowired
    public void setFactoryAnimalDTO(FactoryAnimalDTO factoryAnimalDTO) {
        this.factoryAnimalDTO = factoryAnimalDTO;
    }

    @Autowired
    public void setAnimalsRepository(AnimalsRepository animalsRepository) {
        this.animalsRepository = animalsRepository;
    }

    @Autowired
    public void setAnimalTypeRepository(AnimalTypeRepository animalTypeRepository) {
        this.animalTypeRepository = animalTypeRepository;
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalsRepository.findAll();
    }

    @Override
    public Animal getAnimalById(long id) throws ResourceNotFoundException {
        Optional<Animal> animal = Optional.of(animalsRepository.getById(id));
        if(!animal.isPresent()){
            throw new ResourceNotFoundException("Запись не найдена в БД");
        }
        return animal.get();
    }

    @Override
    public Animal deleteAnimalById(long id) throws ResourceNotFoundException {
        Optional<Animal> animal = Optional.of(animalsRepository.getById(id));
        if(!animal.isPresent()){
            throw new ResourceNotFoundException("Запись не найдена в БД");
        }
        animalsRepository.deleteById(id);
        return animal.get();
    }

    @Override
    public void updateAnimal(NewAnimal newAnimal) throws ResourceNotFoundException {
        Optional<Animal> animal = Optional.of(animalsRepository.getById(newAnimal.getId()));
        if(!animal.isPresent()){
            throw new ResourceNotFoundException("Запись не найдена в БД");
        }
        animal.get().setAnimalType(animalTypeRepository.getById(Long.parseLong(newAnimal.getAnimalType())));
        animal.get().setAnimalGender(Enum.valueOf(AnimalGender.class, newAnimal.getAnimalGender()));
        try {
            animal.get().setDateOfReception(getDate(newAnimal.getDateOfReception()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        animal.get().setDescription(newAnimal.getDescription());
        animalsRepository.saveAndFlush(animal.get());
    }

    @Override
    public void addNewAnimal(NewAnimal newAnimal) {
        Animal animal = new Animal();
        animal.setAnimalType(animalTypeRepository.getById(Long.parseLong(newAnimal.getAnimalType())));
        animal.setAnimalGender(Enum.valueOf(AnimalGender.class, newAnimal.getAnimalGender()));
        try {
            animal.setDateOfReception(getDate(newAnimal.getDateOfReception()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        animal.setDescription(newAnimal.getDescription());
        animalsRepository.save(animal);
    }

    private Date getDate(String day) throws ParseException {
        if(day.isEmpty() || day==null) {return  new Date();}//отсекаем пустую дату
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(day);
    }
}
