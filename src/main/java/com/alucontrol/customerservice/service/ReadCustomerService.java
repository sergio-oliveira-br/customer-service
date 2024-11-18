package com.alucontrol.customerservice.service;

import com.alucontrol.customerservice.entity.Customer;
import com.alucontrol.customerservice.exceptions.CustomerNotFoundException;
import com.alucontrol.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReadCustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public ReadCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer findCustomerById(Long id) {

        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            return customer.get();
        }
        throw new CustomerNotFoundException("Cliente id '" + id + "' não encontrado");
    }

    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }
}
