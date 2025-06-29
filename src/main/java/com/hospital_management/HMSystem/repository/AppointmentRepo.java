package com.hospital_management.HMSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.hospital_management.HMSystem.models.Appointment;

@SuppressWarnings("unused")
public interface AppointmentRepo extends JpaRepository<Appointment, Long>, CrudRepository<Appointment, Long> {
    // Define any custom query methods if needed
    // For example, you can add methods to find appointments by patientId or doctorId
    // List<Appointment> findByPatientId(Long patientId);
    
}
