package com.naveen.springbootcountryproject.services;


import com.naveen.springbootcountryproject.beans.Country;
import com.naveen.springbootcountryproject.controllers.AddResponce;
import com.naveen.springbootcountryproject.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Component
@Service
public class CountryService {

    @Autowired
     CountryRepository countryrep;



//    public CountryService(){}

    public List<Country> getAllCountries()
    {
        List<Country > countries=countryrep.findAll();
        return countries;
    }


    public Country getCountrybyID(int id)
    {
        List<Country> countries =countryrep.findAll();
        Country country= null;
        for(Country con:countries)
        {
            if(con.getId()==id)
                country=con;
        }
        return country;
    }

    public Country getCountrybyName(String countryName)
    {
        List<Country> countries= countryrep.findAll();
        Country country=null;

        for(Country con:countries)
        {
            if(con.getCountryName().equalsIgnoreCase(countryName))
                country=con;
        }
        return country;
    }

    public Country addCountry(Country country)
    {
        country.setId(getMaxId());
        countryrep.save(country);
        return country;
    }


    public Country updateCountry(Country country)
    {
        countryrep.save(country);
        return country;

    }

    public void deleteCountry(Country country)
    {
        countryrep.delete(country);
    }
//    public AddResponce deleteCountry(int id)
//    {
//        countryrep.deleteById(id);
//        AddResponce res=new AddResponce();
//        res.setMsg("Country Deleted..... !");
//        res.setId(id);
//        return res;
//
//    }

    // Utility merthod to get max id

    public  int getMaxId()
    {
        return countryrep.findAll().size()+1;
    }
}

