package com.netcracker.application.service.system.clientService;

import com.netcracker.application.model.system.*;
import com.netcracker.application.repository.system.*;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{
    private final ClientRepository clientRepository;
    private final AddressRepository addressRepository;
    private final HouseRepository houseRepository;
    private final BillingAccRepository billingAccRepository;
    private final ServiceRepository serviceRepository;

    public ClientServiceImpl(ClientRepository clientRepository, AddressRepository addressRepository,
                             HouseRepository houseRepository, BillingAccRepository billingAccRepository,
                             ServiceRepository serviceRepository) {
        this.clientRepository = clientRepository;
        this.addressRepository = addressRepository;
        this.houseRepository = houseRepository;
        this.billingAccRepository = billingAccRepository;
        this.serviceRepository = serviceRepository;
    }

    @Override
    public List<Client> getAllClients(){
        return clientRepository.findAll();
    }

    @Override
    public Client getClientById(String id){
        return clientRepository.getClientById(id);
    }

    @Override
    public boolean deleteClient(String id){
        clientRepository.delete(clientRepository.getClientById(id));
        return true;
    }

    @Override
    public boolean saveClient(Client client){
        clientRepository.save(client);
        return true;
    }

    @Override
    public boolean addClient(String surname, String name, String patronymic, String phoneNumber,
                             String cityName, String streetName, String houseNumber, int flat) {
        Client client = new Client();
        client.setSurname(surname);
        client.setName(name);
        client.setPatronymic(patronymic);
        client.setPhoneNumber(phoneNumber);
        Address address = new Address();
        House house = houseRepository.findHouseByCityNameAndStreetNameAndHouseNumber(houseNumber, streetName, cityName);
//        House house = new House();
//        if(list.size()==1){
//            house = list.get(0);
//        }
        address.setHouse(house);
        address.setFlat(flat);
        client.setAddress(address);
        addressRepository.save(address);
        return saveClient(client);
    }

    @Override
    public BillingAcc clientBillingAccByClientId(String id) {
        return getClientById(id).getBillingAcc();
    }

    @Override
    public boolean addBillingAccForClient(String clientId, String cardNumber, String surname, String name,
                                       String patronymic, String CVV, String validDate){
        Client client = this.getClientById(clientId);
        if(client.getBillingAcc() == null) {
            BillingAcc billingAcc = new BillingAcc(cardNumber, surname, name, patronymic, CVV, validDate, BigDecimal.ZERO);
            billingAccRepository.save(billingAcc);
            client.setBillingAcc(billingAcc);
            clientRepository.save(client);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean addService(String clientId, String serviceName){
        Client client = getClientById(clientId);
        com.netcracker.application.model.system.Service service = serviceRepository.getServiceByName(serviceName);
        client.setService(service);
        clientRepository.save(client);
        return true;
    }

    @Override
    public boolean deleteBillingAcc(String clientId){
        Client client = getClientById(clientId);
        BillingAcc billingAcc = client.getBillingAcc();
        billingAccRepository.delete(billingAcc);
        client.setBillingAcc(null);
        clientRepository.save(client);
        return true;
    }

    @Override
    public boolean deleteService(String clientId){
        Client client = getClientById(clientId);
        com.netcracker.application.model.system.Service service = client.getService();
        serviceRepository.delete(service);
        client.setService(null);
        clientRepository.save(client);
        return true;
    }
}
