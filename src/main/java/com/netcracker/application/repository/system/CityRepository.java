package com.netcracker.application.repository.system;

import com.netcracker.application.model.system.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {
    City findCityById(Long id);
    List<City> findAll();
    City getCityByName(String name);
}
