package com.netcracker.application.service.system.addressService;

import com.netcracker.application.model.system.Address;

import java.util.List;

public interface AddressService {
    boolean checkAddress(String cityName, String streetName, String houseNumber);
    List<Address> findAll();
    Address findOne(Long id);
}
