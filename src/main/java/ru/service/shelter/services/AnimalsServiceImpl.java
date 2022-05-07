package ru.service.shelter.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ru.service.shelter.dto.AnimalsDTO;
import ru.service.shelter.dto.NewAnimal;
import ru.service.shelter.entity.AnimalGender;
import ru.service.shelter.entity.Animals;
import ru.service.shelter.repositories.AnimalTypeRepository;
import ru.service.shelter.repositories.AnimalsRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Transactional
public class AnimalsServiceImpl implements AnimalService{
    AnimalsRepository animalsRepository;
    AnimalTypeRepository animalTypeRepository;

    @Autowired
    public void setAnimalsRepository(AnimalsRepository animalsRepository) {
        this.animalsRepository = animalsRepository;
    }

    @Autowired
    public void setAnimalTypeRepository(AnimalTypeRepository animalTypeRepository) {
        this.animalTypeRepository = animalTypeRepository;
    }

    @Override
    public List<AnimalsDTO> getAllAnimals() {
        List<AnimalsDTO> animalsList = animalsRepository.findAll().stream()
                .map(animals -> new AnimalsDTO(animals))
                .collect(Collectors.toList());
        return animalsList;
    }

    @Override
    public Animals getAnimalById(long id) {
        return animalsRepository.getById(id);
    }

    @Override
    public void deleteAnimalsById(long id) {
        animalsRepository.deleteById(id);
    }

    @Override
    public void updateAnimals(NewAnimal newAnimal) {
        Animals animal = animalsRepository.getById(newAnimal.getId());
        animal.setAnimalType(animalTypeRepository.getById(Long.parseLong(newAnimal.getAnimalType())));
        animal.setAnimalGender(Enum.valueOf(AnimalGender.class, newAnimal.getAnimalGender()));
        try {
            animal.setDateOfReception(getDate(newAnimal.getDateOfReception()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        animal.setDescription(newAnimal.getDescription());
        animalsRepository.saveAndFlush(animal);
    }

    @Override
    public void addNewAnimal(NewAnimal newAnimal) {
        Animals animal = new Animals();
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
        if(day.isEmpty()|| day==null){return  new Date();}//отсекаем пустую дату
        //переводим дату в нужный формат
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(day);
    }
}
