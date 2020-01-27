package com.netcracker.application.service.system.houseService;

import com.netcracker.application.model.system.House;

import java.util.List;

public interface HouseService {
    boolean checkHouse(String cityName, String streetName, String houseNumber);
    List<House> getAll();
}
