package com.alucontrol.customerservice.controller;

import com.alucontrol.customerservice.entity.Customer;
import com.alucontrol.customerservice.service.ReadCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class ReadCustomerController {

    private final ReadCustomerService readCustomerService;

    @Autowired
    public ReadCustomerController(ReadCustomerService readCustomerService) {
        this.readCustomerService = readCustomerService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getCustomerNameById(@PathVariable Long id) {

        Customer customer = readCustomerService.findCustomerById(id);
        return ResponseEntity.ok(customer.getName());
    }
}
