package com.netcracker.application.repository.system;

import com.netcracker.application.model.system.BillingAcc;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillingAccRepository extends JpaRepository<BillingAcc, Long> {
    @Override
    BillingAcc getOne(Long aLong);
    @Override
    List<BillingAcc> findAll();
}