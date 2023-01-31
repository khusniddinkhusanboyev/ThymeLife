package com.example.ViewThymelife.controller;

import com.example.ViewThymelife.model.City;
import com.example.ViewThymelife.repository.Cityrepository;
import com.example.ViewThymelife.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CityController {
    @Autowired
    private final Cityrepository cityrepository;
    @Autowired
    private final CityService cityService;

    public CityController(Cityrepository cityrepository, CityService cityService) {
        this.cityrepository = cityrepository;
        this.cityService = cityService;
    }

    @GetMapping("/details")
    public ResponseEntity getAll(){
        List<City> cities=cityService.getAll();
        return ResponseEntity.ok(cities);
    }

    @GetMapping("/employee")
    public ModelAndView showCity(){
        ModelAndView mav=new ModelAndView("listcity");
        List<City> list=cityrepository.findAll();
        mav.addObject("list-cities" , list);
        return mav;
    }
}
