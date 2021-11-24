package com.naveen.springbootcountryproject.controllers;


import com.naveen.springbootcountryproject.beans.Country;
import com.naveen.springbootcountryproject.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
     CountryService countryService;

    @GetMapping("/getcountries")
    public List<Country> getCountries()
    {
       return  countryService.getAllCountries();
    }


    @GetMapping("/getcountries/{id}")
    public ResponseEntity<Country> getCountryById(@PathVariable(value = "id")int id)
    {
        try {
            Country country = countryService.getCountrybyID(id);
            return new ResponseEntity<Country>(country, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/getcountries/countryname")
    public ResponseEntity<Country> getCountryByName(@RequestParam(value = "name")String countryName)
    {
        try {
            Country country = countryService.getCountrybyName(countryName);
            return new ResponseEntity<Country>(country, HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/addcountry")
    public Country addCountry(@RequestBody Country country){
        return countryService.addCountry(country);
    }

    @PutMapping("/updatecountry/{id}")
    public ResponseEntity<Country> updateCountry(@PathVariable(value = "id") int id, @RequestBody Country country) {
        try {


            Country existCountry = countryService.getCountrybyID(id);
            existCountry.setCountryName(country.getCountryName());
            existCountry.setCountryCapital(country.getCountryCapital());

            Country updated_country =  countryService.updateCountry(existCountry);
            return new ResponseEntity<Country>(updated_country,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
    }

    @DeleteMapping("/deletecounry/{id}")
    public AddResponce deleteCountry(@PathVariable(value = "id")int id)
    {
        return countryService.deleteCountry(id);
    }
}

