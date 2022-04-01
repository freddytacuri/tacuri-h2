package com.tacuri.service.impl;

import com.tacuri.domain.jpa.CountriesJpa;
import com.tacuri.exceptions.NotFoundException;
import com.tacuri.repository.ICountriesRepository;
import com.tacuri.service.ICountriesService;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CountriesService implements ICountriesService {

  private final ICountriesRepository ICountriesRepository;

  @Override
  public CountriesJpa getCountryById(Integer id) {
    CountriesJpa response = ICountriesRepository.getCountriesJpaById(id).orElse(null);
    if (Objects.isNull(response)) {
      throw new NotFoundException();
    }
    return response;
  }
}
