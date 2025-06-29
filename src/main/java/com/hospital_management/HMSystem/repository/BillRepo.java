package com.hospital_management.HMSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hospital_management.HMSystem.models.Bill;

public interface BillRepo extends JpaRepository<Bill, Long> {
    // Define any custom query methods if needed

    
}