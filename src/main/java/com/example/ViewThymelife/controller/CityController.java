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
    private final Cityrepository cityrepository;
    @Autowired
    private final CityService cityService;

    public CityController(Cityrepository cityrepository, CityService cityService) {
        this.cityrepository = cityrepository;
        this.cityService = cityService;
    }
    @RequestMapping(value = "/city",method = RequestMethod.GET)
    public String showCity(Model model){
        model.addAttribute("cities" , cityrepository.findAll());
        return "listcity";
    }





























   /*@RequestMapping(value = "/time",method = RequestMethod.GET)
    public ModelAndView show(){
        ModelAndView mav=new ModelAndView("listcity");
        mav.a("list-cities" , cityrepository.findAll());
        return mav;
    }*/
    @RequestMapping("/error")
    @ResponseBody
    String error(HttpServletRequest request) {
        return "<h1>Error occurred</h1>";
    }

    @GetMapping("/details")
    public ResponseEntity getAll(){
        List<City> cities=cityService.getAll();
        return ResponseEntity.ok(cities);
    }

}
