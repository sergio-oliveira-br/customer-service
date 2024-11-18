package com.alucontrol.customerservice.controller;

import com.alucontrol.customerservice.entity.Customer;
import com.alucontrol.customerservice.service.CreateCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/customers")
public class CreateCustomerController {

    private final CreateCustomerService createCustomerService;

    @Autowired
    public CreateCustomerController(CreateCustomerService createCustomerService) {
        this.createCustomerService = createCustomerService;
    }

    @PostMapping
    public ResponseEntity<Customer> createCustomer(@Validated @RequestBody Customer customer) {

        createCustomerService.saveCustomer(customer);
        return ResponseEntity.status(HttpStatus.CREATED).body(customer);
    }
}
