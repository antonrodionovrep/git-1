package com.netcracker.application.repository.system;

import com.netcracker.application.model.system.House;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface HouseRepository extends JpaRepository<House, Long> {
    House getHouseById(Long id);
    List<House> getHouseByHouseNumber(String houseNumber);
    @Query("SELECT h FROM House h WHERE house_number = :houseNum AND " +
            "street_id = (select id from Street WHERE name = :streetN) " +
            "AND city_id = (select id from City WHERE name = :cityN)")
    House findHouseByCityNameAndStreetNameAndHouseNumber(@Param("houseNum") String houseNumber,
                                                               @Param("streetN") String streetName,
                                                               @Param("cityN") String cityName);
}
