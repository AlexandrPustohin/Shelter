package ru.service.shelter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ru.service.shelter.entity.Animals;
import ru.service.shelter.services.AnimalService;

@Controller
public class ShelterController {
    AnimalService animalService;

    @Autowired
    public void setAnimalService(AnimalService animalService) {
        this.animalService = animalService;
    }

    @RequestMapping(value =  "/" , method = RequestMethod.GET)
    public String table (Model model) {
        model.addAttribute("listOfAnimals", animalService.getAllAnimals());
        return "index";
    }
}
