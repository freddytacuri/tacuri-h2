package com.tacuri.service.impl;

import com.tacuri.domain.jpa.CountriesJpa;
import com.tacuri.repository.ICountriesRepository;
import com.tacuri.service.ICountriesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountriesService implements ICountriesService {

  private final ICountriesRepository ICountriesRepository;

  @Override
  public CountriesJpa getCountryById(Integer id) {
    return ICountriesRepository.getCountriesJpaById(id).orElse(null);
  }
}
