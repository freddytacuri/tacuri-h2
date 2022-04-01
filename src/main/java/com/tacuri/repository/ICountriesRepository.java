package com.tacuri.repository;

import com.tacuri.domain.jpa.CountriesJpa;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountriesRepository extends CrudRepository<CountriesJpa, Integer> {

  Optional<CountriesJpa> getCountriesJpaById(Integer id);
}
