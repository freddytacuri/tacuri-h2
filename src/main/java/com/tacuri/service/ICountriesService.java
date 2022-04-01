package com.tacuri.service;

import com.tacuri.domain.jpa.CountriesJpa;

public interface ICountriesService {

  CountriesJpa getCountryById(Integer id);

  void saveCountry(CountriesJpa country);

  void deleteCountry(Integer id);
}
