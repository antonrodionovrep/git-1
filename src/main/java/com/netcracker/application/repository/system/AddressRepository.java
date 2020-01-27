package com.netcracker.application.repository.system;

import com.netcracker.application.model.system.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {
    Address getAddressById(Long id);
    List<Address> findAll();
    //@Query("SELECT a FROM addresses WHERE ")
    //Address getAddressForCheck(String cityName, String streetName, String houseNumber);
}
