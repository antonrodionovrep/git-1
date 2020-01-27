package com.netcracker.application.controller.system;

import com.netcracker.application.model.system.BillingAcc;
import com.netcracker.application.model.system.Client;
import com.netcracker.application.model.system.Service;
import com.netcracker.application.service.system.clientService.ClientService;
import com.netcracker.application.service.system.houseService.HouseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class ClientController {
    private final ClientService clientService;
    private final HouseService houseService;

    public ClientController(ClientService clientService, HouseService houseService) {
        this.clientService = clientService;
        this.houseService = houseService;
    }

    @GetMapping("/api/clients")
    public List<Client> clients(){
        return clientService.getAllClients();
    }

    @GetMapping("/api/clients/{id}")
    public Client client(@PathVariable String id){
        return clientService.getClientById(id);
    }

    @DeleteMapping("/api/clients/{id}")
    public boolean deleteClient(@PathVariable String id){
        return clientService.deleteClient(id);
    }

    @PostMapping("/api/clients/checkAddress")
    public boolean checkAddress(String cityName, String streetName, String houseNumber){
        return houseService.checkHouse(cityName, streetName, houseNumber);
    }

    @PostMapping("/api/clients/addClient")
    public boolean addClient(String surname, String name, String patronymic, String phoneNumber,
                             String cityName, String streetName, String houseNumber, String flat){
        return clientService.addClient(surname, name, patronymic, phoneNumber, cityName, streetName, houseNumber, Integer.parseInt(flat));
    }

    @GetMapping("/api/clients/{clientId}/billingAcc")
    public BillingAcc clientBillingAcc(@PathVariable String clientId){
        return clientService.clientBillingAccByClientId(clientId);
    }

    @PostMapping("/api/clients/{clientId}/billingAcc/add")
    public boolean addBillingAcc(@PathVariable String clientId, String cardNumber, String surname, String name,
                                 String patronymic, String CVV, String validDate){
        return clientService.addBillingAccForClient(clientId, cardNumber, surname, name, patronymic,
                CVV, validDate);
    }

    @GetMapping("/api/clients/{clientId}/service")
    public Service getServiceFromClient(@PathVariable String clientId){
        return clientService.getClientById(clientId).getService();
    }

    @PostMapping("/api/clients/{clientId}/service/add")
    public boolean addServiceForClient(@PathVariable String clientId, String serviceName){
        return clientService.addService(clientId, serviceName);
    }

    @DeleteMapping("/api/clients/{clientId}/service/deleteService")
    public boolean deleteClientService(@PathVariable String clientId){
        return clientService.deleteService(clientId);
    }

    @DeleteMapping("/api/clients/{clientId}/billingAcc/deleteBillingAcc")
    public boolean deleteClientBillingAcc(@PathVariable String clientId){
        return clientService.deleteBillingAcc(clientId);
    }
}