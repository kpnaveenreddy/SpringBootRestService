package com.naveen.springbootcountryproject.repositories;

import com.naveen.springbootcountryproject.beans.Country;
import org.springframework.data.jpa.repository.JpaRepository;


//Beanclass Name & Primary key data type we need to pass in jpa repo
public interface CountryRepository extends JpaRepository<Country, Integer>
{


}
