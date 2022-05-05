package ru.service.shelter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ShelterController {

    @RequestMapping(value =  "/" , method = RequestMethod.GET)
    public String table () {
        return "index";
    }
}
