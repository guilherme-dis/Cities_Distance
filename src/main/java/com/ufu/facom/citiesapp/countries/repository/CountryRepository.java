package com.ufu.facom.citiesapp.countries.repository;
import com.ufu.facom.citiesapp.countries.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CountryRepository extends JpaRepository<Country, Long> {
}
