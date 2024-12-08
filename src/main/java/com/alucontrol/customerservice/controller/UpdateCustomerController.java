package com.alucontrol.customerservice.controller;

import com.alucontrol.customerservice.entity.Customer;
import com.alucontrol.customerservice.service.UpdateCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/customers")
public class UpdateCustomerController {

    private final UpdateCustomerService updateCustomerService;

    @Autowired
    public UpdateCustomerController(UpdateCustomerService updateCustomerService) {
        this.updateCustomerService = updateCustomerService;
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id,
                                                   @RequestParam BigDecimal amount) {

        Customer customer = updateCustomerService.updateCustomer(id, amount);
        return ResponseEntity.ok(customer);
    }
}
