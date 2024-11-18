package com.alucontrol.customerservice.service;

import com.alucontrol.customerservice.entity.Customer;
import com.alucontrol.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerService {

    CustomerRepository customerRepository;

    @Autowired
    public CreateCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}
