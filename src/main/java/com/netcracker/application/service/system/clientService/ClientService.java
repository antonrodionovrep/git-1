package com.netcracker.application.service.system.clientService;

import com.netcracker.application.model.system.BillingAcc;
import com.netcracker.application.model.system.Client;

import java.util.List;

public interface ClientService {
    List<Client> getAllClients();
    Client getClientById(String id);
    boolean deleteClient(String id);
    boolean saveClient(Client client);
    boolean addClient(String surname, String name, String patronymic, String phoneNumber,
                      String cityName, String streetName, String houseNumber, int flat);
    BillingAcc clientBillingAccByClientId(String id);
    boolean addBillingAccForClient(String clientId, String cardNumber, String surname, String name,
                                String patronymic, String CVV, String validDate);
    boolean addService(String clientId, String serviceName);
    boolean deleteService(String clientId);
    boolean deleteBillingAcc(String clientId);
}
