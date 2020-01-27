package com.netcracker.application.service.system.houseService;

import com.netcracker.application.model.system.House;
import com.netcracker.application.repository.system.CityRepository;
import com.netcracker.application.repository.system.HouseRepository;
import com.netcracker.application.repository.system.StreetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService{
    private final CityRepository cityRepository;
    private final StreetRepository streetRepository;
    private final HouseRepository houseRepository;

    public HouseServiceImpl(CityRepository cityRepository, StreetRepository streetRepository, HouseRepository houseRepository) {
        this.cityRepository = cityRepository;
        this.streetRepository = streetRepository;
        this.houseRepository = houseRepository;
    }

    @Override
    public boolean checkHouse(String cityName, String streetName, String houseNumber) {
        if(cityRepository.getCityByName(cityName)==null){
            return false;
        } else if (streetRepository.getStreetByName(streetName)==null){
            return false;
        } else if (houseRepository.getHouseByHouseNumber(houseNumber)==null) {
            return false;
        } else {
            return true; //houseRepository.getHouseByCityNameAndStreetNameAndHouseNumber(cityName, streetName, houseNumber) != null;
        }
    }

    @Override
    public List<House> getAll() {
        return houseRepository.findAll();
    }
}
