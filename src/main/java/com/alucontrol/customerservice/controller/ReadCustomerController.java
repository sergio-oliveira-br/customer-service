package com.alucontrol.customerservice.controller;

import com.alucontrol.customerservice.entity.Customer;
import com.alucontrol.customerservice.service.ReadCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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

        System.out.println("Customer Service: Acessando customer name by ID:" + id);
        Customer customer = readCustomerService.findCustomerById(id);
        System.out.println("Dados encontrados: " + customer);
        return ResponseEntity.ok(customer.getName());
    }

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers() {

        List<Customer> allCustomer = readCustomerService.findAllCustomer();
        return ResponseEntity.ok(allCustomer);
    }
}
