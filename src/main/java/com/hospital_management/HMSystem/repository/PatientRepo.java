package com.hospital_management.HMSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.hospital_management.HMSystem.models.Patient;


@SuppressWarnings("unused")
public interface PatientRepo extends JpaRepository<Patient, Long>, CrudRepository<Patient, Long> {
    // Custom query methods can be defined here if needed
    
}
