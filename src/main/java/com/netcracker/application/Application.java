package com.netcracker.application;

import com.netcracker.application.model.system.*;
import com.netcracker.application.repository.system.AddressRepository;
import com.netcracker.application.repository.system.CityRepository;
import com.netcracker.application.repository.system.HouseRepository;
import com.netcracker.application.repository.system.StreetRepository;
import com.netcracker.application.service.system.clientService.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
//    @Bean
//    CommandLineRunner runner(@Autowired ClientService clientService, AddressRepository addressRepository,
//                             HouseRepository houseRepository, CityRepository cityRepository,
//                             StreetRepository streetRepository){
//        return args -> {
//            City one = new City("Saratov");
//            Street sOne = new Street("Some Street");
//            Street sTwo = new Street("Another Street");
//            House hOne = new House(one, sOne, "3");
//            House hTwo = new House(one, sTwo, "1");
//            Address addressOne = new Address(hOne, 13);
//            Address addressTwo = new Address(hTwo, 11);
//            Address addressThird = new Address(hTwo, 12);
//            Client client1 = new Client("1","a","b","c","+89996667771",
//                    addressOne, null, null);
//            Client client2 = new Client("2","Alla","Ya","V bar","+89996667772",
//                    addressTwo,null,null);
//            Client client3 = new Client("3","Ivanov","Ivan","Ivanovich","+89996667773",
//                    addressThird, null, null);
//            cityRepository.save(one);
//            streetRepository.save(sOne);
//            streetRepository.save(sTwo);
//            houseRepository.save(hOne);
//            houseRepository.save(hTwo);
//            addressRepository.save(addressOne);
//            addressRepository.save(addressTwo);
//            addressRepository.save(addressThird);
//            clientService.saveClient(client1);
//            clientService.saveClient(client2);
//            clientService.saveClient(client3);
//        };
//      }
}