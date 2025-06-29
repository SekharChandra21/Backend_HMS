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

import com.hospital_management.HMSystem.models.Bill;
import com.hospital_management.HMSystem.repository.BillRepo;

@RestController
@RequestMapping("/api/bills")
public class BillController {
    
    @Autowired
    private BillRepo billRepo;

    @GetMapping
    public List<Bill> getAllBills() {
        List<Bill> bills = billRepo.findAll();
        return bills;
    }

    @GetMapping("/{id}")
    public Bill getBill(@PathVariable Long id) {
        return billRepo.findById(id).orElse(null); // or throw an exception if bill not found
    }

    @PostMapping
    public Bill addBill(@RequestBody Bill bill) {
        return billRepo.save(bill);
    }

    @PutMapping("/{id}")
    public Bill updateBill(@PathVariable Long id,@RequestBody Bill bill) {
        Bill existingBill = billRepo.findById(id).orElse(null); // or throw an exception if bill not found
        if (existingBill != null) {
            existingBill.setAmount(bill.getAmount());
            existingBill.setPatientId(bill.getPatientId());
            existingBill.setAppointmentId(bill.getAppointmentId());
            existingBill.setStatus(bill.getStatus());
            
            return billRepo.save(existingBill);
        }
        return null;
    }
    
    @DeleteMapping("/{id}")
    public void deleteBill(@PathVariable Long id) {
        billRepo.deleteById(id); // or throw an exception if bill not found
    }
}
