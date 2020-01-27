package com.netcracker.application.service.system.addressService;

import com.netcracker.application.model.system.Address;
import com.netcracker.application.repository.system.AddressRepository;

import java.util.List;

public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;

    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public boolean checkAddress(String cityName, String streetName, String houseNumber) {
        return false;
    }

    @Override
    public List<Address> findAll() {
        return addressRepository.findAll();
    }

    @Override
    public Address findOne(Long id) {
        return addressRepository.getAddressById(id);
    }
}
