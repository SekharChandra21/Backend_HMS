package com.hospital_management.HMSystem.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hospital_management.HMSystem.models.Patient;
import com.hospital_management.HMSystem.repository.PatientRepo;

@RestController
@RequestMapping("/api/patients")
public class patientController {

    @Autowired
    private PatientRepo repo;
    
    @GetMapping
    public List<Patient> getAllPatients() {
        List<Patient> patients = repo.findAll();
        return patients;
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Long id) {
        return repo.findById(id).orElse(null); // or throw an exception if patient not found
    }

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        return repo.save(patient);
    }

    @PutMapping("/{id}")
    public Patient updatePatient(@PathVariable Long id,@RequestBody Patient patient) {
        // Assuming the patient ID is set in the request body
        Patient existingPatient = repo.findById(id)
            .orElse(null); // or throw an exception if patient not found
        if (existingPatient != null) {
            existingPatient.setName(patient.getName());
            existingPatient.setAge(patient.getAge());
            existingPatient.setBloodGroup(patient.getBloodGroup());
            existingPatient.setGender(patient.getGender());
            existingPatient.setPhoneNumber(patient.getPhoneNumber());
            existingPatient.setAddress(patient.getAddress());
            return repo.save(existingPatient);
        }
        return null; // or throw an exception if patient not found
    }

    @DeleteMapping("/{id}")
    public void deletePatient(@PathVariable Long id) {
        repo.deleteById(id);
    }// or handle the case where the patient does not exist
}
