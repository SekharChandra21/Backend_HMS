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

import com.hospital_management.HMSystem.repository.DoctorRepo;
import com.hospital_management.HMSystem.models.Doctor;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {
    
    @Autowired
    private DoctorRepo doctorRepo;

    @GetMapping
    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = doctorRepo.findAll();
        return doctors;
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Long id) {
        return doctorRepo.findById(id).orElse(null); // or throw an exception if doctor not found
    }

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorRepo.save(doctor);
    }

    @PutMapping("/{id}")
    public Doctor updateDoctor(@PathVariable Long id, @RequestBody Doctor doctor) {
        Doctor existingDoctor = doctorRepo.findById(id)
            .orElse(null); // or throw an exception if doctor not found
        if (existingDoctor != null) {
            existingDoctor.setName(doctor.getName());
            existingDoctor.setExperience(doctor.getExperience());
            existingDoctor.setQualification(doctor.getQualification());
            existingDoctor.setSpecialization(doctor.getSpecialization());
            existingDoctor.setPhoneNumber(doctor.getPhoneNumber());
            existingDoctor.setEmail(doctor.getEmail());
            return doctorRepo.save(existingDoctor);
        }
        return null; // or throw an exception if doctor not found
    }

    @DeleteMapping("/{id}")
    public void deleteDoctor(@PathVariable Long id) {
        doctorRepo.deleteById(id);
    } // or handle the case where the doctor does not exist

}
