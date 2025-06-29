package com.hospital_management.HMSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.hospital_management.HMSystem.models.Doctor;

@SuppressWarnings("unused")
public interface DoctorRepo extends JpaRepository<Doctor, Long>, CrudRepository<Doctor, Long> {
    // Custom query methods can be defined here if needed

    
}