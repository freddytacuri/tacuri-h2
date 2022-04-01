package com.tacuri.controller;

import com.tacuri.service.ICountriesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/countries")
@Log4j2
@RequiredArgsConstructor
public class CountryController {

  private final ICountriesService countriesService;

  @GetMapping("/{id}")
  public ResponseEntity<Object> getCountry(@PathVariable Integer id) {
    return new ResponseEntity<>(countriesService.getCountryById(id), HttpStatus.OK);
  }

}
