package ru.service.shelter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.service.shelter.dto.*;
import ru.service.shelter.exseption.ResourceNotFoundException;
import ru.service.shelter.services.AnimalService;
import ru.service.shelter.services.AnimalTypeService;
import ru.service.shelter.services.GenderService;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ShelterRestController {
    AnimalService animalService;
    AnimalTypeService animalTypeService;
    GenderService genderService;
    FactoryAnimalDTO factoryAnimalDTO;
    FactoryAnimalTypeDTO factoryAnimalTypeDTO;

    @Autowired
    public void setFactoryAnimalTypeDTO(FactoryAnimalTypeDTO factoryAnimalTypeDTO) {
        this.factoryAnimalTypeDTO = factoryAnimalTypeDTO;
    }

    @Autowired
    public void setFactoryAnimalDTO(FactoryAnimalDTO factoryAnimalDTO) {
        this.factoryAnimalDTO = factoryAnimalDTO;
    }

    @Autowired
    public void setGenderService(GenderService genderService) {
        this.genderService = genderService;
    }

    @Autowired
    public void setAnimalService(AnimalService animalService) {
        this.animalService = animalService;
    }

    @Autowired
    public void setAnimalTypeService(AnimalTypeService animalTypeService) {
        this.animalTypeService = animalTypeService;
    }

    @GetMapping("/getAllAnimals")
    public ResponseEntity<List<AnimalDTO>> getAllAnimals() {
        return ResponseEntity.ok(factoryAnimalDTO.createAnimalDTOList(animalService.getAllAnimals()));
    }

    @GetMapping("/getAnimal/{id}")
    public ResponseEntity<AnimalDTO> getAnimalById(@PathVariable("id") long id) throws ResourceNotFoundException {
       return ResponseEntity.ok(factoryAnimalDTO.fromAnimalToAnimalDTO(animalService.getAnimalById(id)));
    }

    @DeleteMapping("/deleteAnimal/{id}")
    public ResponseEntity<AnimalDTO> deleteAnimal(@PathVariable("id") long id) throws ResourceNotFoundException {
        return ResponseEntity.ok(factoryAnimalDTO.fromAnimalToAnimalDTO(animalService.deleteAnimalById(id)));
    }

    @GetMapping("/addType/{newType}")
    public ResponseEntity<List<AnimalTypeDTO>> addNewType (@PathVariable("newType") String newType) {
        animalTypeService.addNewType(newType);
        return ResponseEntity.ok(factoryAnimalTypeDTO.createAnimalDTOList(animalTypeService.getAllAnimalTypes()));
    }

    @PostMapping("/addAnimal")
    public ResponseEntity<?> addNewAnimal(@RequestBody NewAnimal newAnimal) throws ResourceNotFoundException {
        animalService.addNewAnimal(newAnimal);
        return ResponseEntity.ok("OK");
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAnimal(@RequestBody NewAnimal newAnimal) throws ResourceNotFoundException {
        animalService.updateAnimal(newAnimal);
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/getAllType")
    public ResponseEntity<List<AnimalTypeDTO>> getAllTypes() {
        return ResponseEntity.ok(factoryAnimalTypeDTO.createAnimalDTOList(animalTypeService.getAllAnimalTypes()));
    }

    @GetMapping("/getGenderList")
    public ResponseEntity<Map<String, String>> getGenders() {
        return ResponseEntity.ok(genderService.getMapGender());
    }

}
