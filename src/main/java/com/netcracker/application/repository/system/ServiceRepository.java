package com.netcracker.application.repository.system;

import com.netcracker.application.model.system.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepository extends JpaRepository<Service, Long> {
    Service getServiceByName(String serviceName);
}