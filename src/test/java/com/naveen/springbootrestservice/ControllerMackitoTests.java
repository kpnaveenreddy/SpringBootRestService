package com.naveen.springbootrestservice;

import com.naveen.springbootcountryproject.beans.Country;
import com.naveen.springbootcountryproject.controllers.CountryController;
import com.naveen.springbootcountryproject.services.CountryService;
import org.junit.jupiter.api.ClassOrderer;
import org.junit.jupiter.api.ClassOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {ControllerMackitoTests.class})
//@TestMethodOrder(OrderAnnotation.class)
public class ControllerMackitoTests {

    @Mock
    CountryService countryService;

    @InjectMocks
    CountryController countryController;

    List<Country> mycountries;  //use for mock data
    Country country;


    @Test @Order(1)
    public void test_getAllCountries()
    {
        mycountries = new ArrayList<Country>();
        mycountries.add(new Country(1,"India","Delhi"));
        mycountries.add(new Country(2,"USA","Washington"));

        when(countryService.getAllCountries()).thenReturn(mycountries); //Mocking
           ResponseEntity<List<Country>> res = countryController.getCountries();

           assertEquals(HttpStatus.FOUND,res.getStatusCode());
           assertEquals(2,res.getBody().size());

    }

    @Test @Order(2)
    public void test_getCountrybyID()
    {
      country = new Country(2,"USA","Washington");
      int countryID=2;

      when(countryService.getCountrybyID(countryID)).thenReturn(country);
      ResponseEntity<Country> res= countryController.getCountryById(countryID);

        // assertEquals(HttpStatus.FOUND,res.getStatusCode());
      assertEquals(HttpStatus.OK,res.getStatusCode());
      assertEquals(countryID,res.getBody().getId());

    }

    @Test @Order(3)
    public void test_getCountrybyName()
    {
        country=new Country(2,"USA","Washington");
        String countryName="USA";

        when(countryService.getCountrybyName(countryName)).thenReturn(country); //Mocking
        ResponseEntity<Country> res = countryController.getCountryByName(countryName);

        assertEquals(HttpStatus.OK,res.getStatusCode());
        assertEquals(countryName,res.getBody().getCountryName());
    }




}
