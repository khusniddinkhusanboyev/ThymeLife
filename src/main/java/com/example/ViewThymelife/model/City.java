package com.example.ViewThymelife.model;

import jakarta.persistence.*;

@Entity
@Table
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String countrycode;
    private String district;
    private Long population;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountrycode() {
        return countrycode;
    }

    public String getDistrict() {
        return district;
    }

    public Long getPopulation() {
        return population;
    }
}
