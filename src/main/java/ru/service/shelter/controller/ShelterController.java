package ru.service.shelter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.service.shelter.dto.FactoryAnimalDTO;
import ru.service.shelter.dto.FactoryAnimalTypeDTO;
import ru.service.shelter.dto.NewAnimal;
import ru.service.shelter.exseption.ResourceNotFoundException;
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
    FactoryAnimalDTO factoryAnimalDTO;
    FactoryAnimalTypeDTO factoryAnimalTypeDTO;

    @Autowired
    public void setFactoryAnimalDTO(FactoryAnimalDTO factoryAnimalDTO) {
        this.factoryAnimalDTO = factoryAnimalDTO;
    }
    @Autowired
    public void setFactoryAnimalTypeDTO(FactoryAnimalTypeDTO factoryAnimalTypeDTO) {
        this.factoryAnimalTypeDTO = factoryAnimalTypeDTO;
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

    @RequestMapping(value =  {"/", "/index"} , method = RequestMethod.GET)
    public String mainURL (Model model) {
        model.addAttribute("listOfAnimals", factoryAnimalDTO.createAnimalDTOList(animalService.getAllAnimals()));
        model.addAttribute("listOfAnimalsType", factoryAnimalTypeDTO.createAnimalDTOList(animalTypeService.getAllAnimalTypes()));
        model.addAttribute("listOfGender", genderService.getMapGender());
        return "index";
    }

    @RequestMapping(value =  "/addAnimal" , method=RequestMethod.POST)
    public String addAnimal (@ModelAttribute("newanimal") NewAnimal newAnimal, HttpServletResponse response) {
        animalService.addNewAnimal(newAnimal);
        return "redirect:/index";
    }

    @RequestMapping(value =  "/addAnimalType" , method=RequestMethod.POST)
    public String addNewType (@ModelAttribute("newTypeOfAnimal") String newTypeOfAnimal, HttpServletResponse response) {
        animalTypeService.addNewType(newTypeOfAnimal);
        return "redirect:/index";
    }

    @RequestMapping(value =  "/delete" , method = RequestMethod.GET)
    public String delete (@RequestParam("id") long id, HttpServletResponse response) throws ResourceNotFoundException {
        animalService.deleteAnimalById(id);
        return "redirect:/index";
    }

    @RequestMapping("/edit/{id}")
    public String editAnimalForm (@PathVariable("id") long id, Model model) throws IOException, ResourceNotFoundException {
        model.addAttribute("listOfGender", genderService.getMapGender());
        model.addAttribute("listOfAnimalsType", animalTypeService.getAllAnimalTypes());
        model.addAttribute("animal", animalService.getAnimalById(id));
        return "edit";
    }

    @RequestMapping(path =  "/updateAnimal/{id}", method = RequestMethod.POST)
    public String updateAnimal (@PathVariable("id") long id,
                                @ModelAttribute("editanimal") NewAnimal editAnimal,
                                HttpServletResponse response) throws IOException, ResourceNotFoundException {
        animalService.updateAnimal(editAnimal);
        return "redirect:/index";
    }

    @RequestMapping(value =  "/card" , method = RequestMethod.GET)
    public String cardAnimal (@RequestParam("id") long id, Model model) throws ResourceNotFoundException {
        model.addAttribute("animal", factoryAnimalDTO.fromAnimalToAnimalDTO(animalService.getAnimalById(id)));
        return "card";
    }

}
