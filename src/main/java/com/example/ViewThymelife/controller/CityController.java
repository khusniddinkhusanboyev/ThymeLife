package com.example.ViewThymelife.controller;

import com.example.ViewThymelife.model.City;
import com.example.ViewThymelife.repository.Cityrepository;
import com.example.ViewThymelife.service.CityService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/api")
public class CityController {

    @Autowired
    private final CityService cityService;
    public CityController(Cityrepository cityrepository, CityService cityService) {
        this.cityService = cityService;
    }
    @RequestMapping(value = "/city",method = RequestMethod.GET)
    public String showCity(Model model){
        model.addAttribute("cities" , cityService.getAll());
        return "listcity";
    }

    @GetMapping("/details")
    public ResponseEntity getAll(){
        List<City> cities=cityService.getAll();
        return ResponseEntity.ok(cities);
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("endPoints", new City());
        return "form-complition";
    }

    @PostMapping("/createe")
    public String addToDB(@ModelAttribute City city){
        cityService.save(city);
        return "listcity";

    }

}
