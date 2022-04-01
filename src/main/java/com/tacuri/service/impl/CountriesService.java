package com.tacuri.service.impl;

import com.tacuri.domain.jpa.CountriesJpa;
import com.tacuri.exceptions.InternalErrorException;
import com.tacuri.exceptions.NotFoundException;
import com.tacuri.repository.ICountriesRepository;
import com.tacuri.service.ICountriesService;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountriesService implements ICountriesService {

  private final ICountriesRepository countriesRepository;

  @Override
  public CountriesJpa getCountryById(Integer id) {
    CountriesJpa response = countriesRepository.getCountriesJpaById(id).orElse(null);
    if (Objects.isNull(response)) {
      throw new NotFoundException();
    }
    return response;
  }

  @Override
  public void saveCountry(CountriesJpa country) {
    try {
      countriesRepository.save(country);
    } catch (Exception exception) {
      throw new InternalErrorException();
    }
  }

  @Override
  public void deleteCountry(Integer id) {
    CountriesJpa countriesJpa = getCountryById(id);
    countriesRepository.delete(countriesJpa);
  }
}
