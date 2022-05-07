package ru.service.shelter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.service.shelter.dto.NewAnimal;
import ru.service.shelter.services.AnimalService;
import ru.service.shelter.services.AnimalTypeService;
import ru.service.shelter.services.GenderService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class ShelterController {
    AnimalService animalService;
    AnimalTypeService animalTypeService;
    GenderService genderService;

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

    @RequestMapping(value =  {"/", "/index"} , method = RequestMethod.GET)
    public String mainURL (Model model) {
        model.addAttribute("listOfAnimals", animalService.getAllAnimals());
        model.addAttribute("listOfAnimalsType", animalTypeService.getAllAnimalTypes());
        model.addAttribute("listOfGender", genderService.getMapGender());
        return "index";
    }

    @RequestMapping(value =  "/addAnimal" , method=RequestMethod.POST)
    public String addAnimal (@ModelAttribute("newanimal") NewAnimal newAnimal, HttpServletResponse response) throws IOException {
        animalService.addNewAnimal(newAnimal);
        return "redirect:/index";
    }

    @RequestMapping(value =  "/addAnimalType" , method=RequestMethod.POST)
    public String addNewType (@ModelAttribute("newTypeOfAnimal") String newTypeOfAnimal, HttpServletResponse response) throws IOException {
        animalTypeService.addNewType(newTypeOfAnimal);
        return "redirect:/index";
    }

    @RequestMapping(value =  "/delete" , method = RequestMethod.GET)
    public String delete (@RequestParam("id") String id, HttpServletResponse response) {
        animalService.deleteAnimalsById(Long.parseLong(id));
        return "redirect:/index";
    }

    @RequestMapping("/edit/{id}")
    public String editAnimalForm (@PathVariable("id") long id, Model model) throws IOException {
        model.addAttribute("listOfGender", genderService.getMapGender());
        model.addAttribute("listOfAnimalsType", animalTypeService.getAllAnimalTypes());
        model.addAttribute("animal", animalService.getAnimalById(id));
        return "edit";
    }

    @RequestMapping(path =  "/updateAnimal/{id}", method = RequestMethod.POST)
    public String updateAnimal (@PathVariable("id") long id,
                                NewAnimal editAnimal,
                                HttpServletResponse response) throws IOException {
        animalService.updateAnimals(editAnimal);
        return "redirect:/index";
    }

}
