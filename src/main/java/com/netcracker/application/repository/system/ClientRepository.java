package com.netcracker.application.repository.system;

import com.netcracker.application.model.system.Address;
import com.netcracker.application.model.system.BillingAcc;
import com.netcracker.application.model.system.Client;
import com.netcracker.application.model.system.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, String> {
    List<Client> findAll();
    Client getClientById(String id);
    Client getClientByPhoneNumber(String phoneNumber);
    @Modifying
    @Query("UPDATE Client " +
            "SET surname = :surnameU, name = :nameU, patronymic = :patronymicU, phoneNumber = :phoneNumberU," +
            "address = :addressU, service = :serviceU, billingAcc = :billingAccU WHERE id =:idU")
    boolean updateClient(@Param("idU") String id, @Param("surnameU") String surname,@Param("name") String name,
                      @Param("patronymic") String patronymic, @Param("phoneNumberU") String phoneNumber,
                      @Param("addressU") Long address, @Param("serviceU") Long service, @Param("billingAccU") Long billingAcc);
}
