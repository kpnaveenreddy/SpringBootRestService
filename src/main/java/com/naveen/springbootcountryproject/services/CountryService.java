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

//    static HashMap<Integer, Country> countryIdMap;

    public CountryService()
    {
//        Country indiaCountry=new Country(1,"India","Delhi");
//        Country usaCountry=new Country(2,"USA","Washington");
//        Country ukCountry=new Country(3,"UK","London");
//
//        countryIdMap.put(1,indiaCountry);
//        countryIdMap.put(2,usaCountry);
//        countryIdMap.put(3,ukCountry);
//        Hasp Map we are using to pass all three parameters as one object

    }

    public List<Country> getAllCountries()
    {
        return countryrep.findAll();
//        List countries=new ArrayList(countryIdMap.values());
//        return countries;
    }


    public Country getCountrybyID(int id)
    {
        return countryrep.findById(id).get();
//      Country country=  countryIdMap.get(id);
//      return country;
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
//        for(int i:countryIdMap.keySet())
//        {
//            if(countryIdMap.get(i).getCountryName().equals(countryName))
//                country = countryIdMap.get(i);
//        }
//        return country;
    }

    public Country addCountry(Country country)
    {
        country.setId(getMaxId());
        countryrep.save(country);
        return country;

//        country.setId(getMaxId());
//        countryIdMap.put(country.getId(),country);
//        return country;
    }

    // Utility merthod to get max id

    public  int getMaxId()
    {
        return countryrep.findAll().size()+1;

//        int max=0;
//        for(int id:countryIdMap.keySet())
//            if(max<=id)
//                max=id;
//            return max+1;
    }

    public Country updateCountry(Country country)
    {
        countryrep.save(country);
        return country;
//        if(country.getId()>0)
//            countryIdMap.put(country.getId(),  country);
//        return country;

    }

    public AddResponce deleteCountry(int id)
    {
        countryrep.deleteById(id);
        AddResponce res=new AddResponce();
        res.setMsg("Country Deleted..... !");
        res.setId(id);
        return res;
//        countryIdMap.remove(id);
//        AddResponce res=new AddResponce();
//        res.setMsg("Country deleted...");
//        res.setId(id);
//        return res;

    }
}

