package com.tacuri.domain.mappers;

import com.tacuri.domain.jpa.CountriesJpa;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CountriesControllerMapper {

  CountriesJpa toCountriesJpa(CountriesJpa countriesJpa);
}
