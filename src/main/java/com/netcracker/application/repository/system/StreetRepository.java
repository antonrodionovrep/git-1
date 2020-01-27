package com.netcracker.application.repository.system;

import com.netcracker.application.model.system.Street;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StreetRepository extends JpaRepository<Street, Long> {
    Street getStreetByName(String name);
}
