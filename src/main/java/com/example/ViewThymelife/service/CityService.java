package com.example.ViewThymelife.service;

import com.example.ViewThymelife.model.City;
import com.example.ViewThymelife.repository.Cityrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    @Autowired
    private final Cityrepository cityrepository;

    public CityService(Cityrepository cityrepository) {
        this.cityrepository = cityrepository;
    }

    public List<City> getAll(){
       return cityrepository.findAll();
    }

    public City save(City city){
        return cityrepository.save(city);
    }


}
