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

import com.hospital_management.HMSystem.models.Appointment;
import com.hospital_management.HMSystem.repository.AppointmentRepo;

@RestController
@RequestMapping("/api/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentRepo appointmentRepo;

    @GetMapping
    public List<Appointment> getAllAppointments() {
        List<Appointment> appointment = appointmentRepo.findAll();
        return appointment;
    }

    @GetMapping("/{id}")
    public Appointment getAppointmentId(@PathVariable Long id){
        return appointmentRepo.findById(id).orElse(null);
    }

    @PostMapping
    public Appointment addAppointment(@RequestBody Appointment appointment){
        return appointmentRepo.save(appointment);
    }

    @PutMapping("/{id}")
    public Appointment updateAppointment(@PathVariable Long id,@RequestBody Appointment appointment){
        Appointment existingApp = appointmentRepo.findById(id).orElse(null);
        if(existingApp != null){
            existingApp.setPatientId(appointment.getPatientId());
            existingApp.setDoctorId(appointment.getDoctorId());
            existingApp.setDate(appointment.getDate());
            existingApp.setStatus(appointment.getStatus());
            
            return appointmentRepo.save(existingApp);
        } else {
            return null; // or throw an exception if appointment not found
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAppointment(@PathVariable Long id){
        appointmentRepo.deleteById(id);
    }
}
