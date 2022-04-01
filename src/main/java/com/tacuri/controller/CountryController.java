package com.tacuri.controller;

import com.tacuri.domain.jpa.CountriesJpa;
import com.tacuri.domain.mappers.CountriesControllerMapper;
import com.tacuri.service.ICountriesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/countries")
@Log4j2
@RequiredArgsConstructor
public class CountryController {

  private final ICountriesService countriesService;
  private final CountriesControllerMapper countriesControllerMapper;

  @GetMapping("/{id}")
  public ResponseEntity<Object> getCountry(@PathVariable Integer id) {
    return new ResponseEntity<>(countriesService.getCountryById(id), HttpStatus.OK);
  }

  @PostMapping("/save-country")
  public ResponseEntity<Object> saveCountry(@RequestBody CountriesJpa countriesJpa) {
    countriesService.saveCountry(countriesControllerMapper.toCountriesJpa(countriesJpa));
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Object> deleteCountry(@PathVariable Integer id) {
    countriesService.deleteCountry(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
