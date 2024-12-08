package com.alucontrol.customerservice.service;

import com.alucontrol.customerservice.entity.Customer;
import com.alucontrol.customerservice.exceptions.CustomerNotFoundException;
import com.alucontrol.customerservice.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

@Service
public class UpdateCustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public UpdateCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    public Customer updateCustomer(Long id, BigDecimal amount) {

        Optional<Customer> customer = customerRepository.findById(id);
        if (customer.isPresent()) {
            Customer customerToUpdate = customer.get();

            // Internal service: increase TotalSpent in customer data
            increaseTotalSpent(customerToUpdate, amount);

            customerRepository.save(customerToUpdate);
            return customerToUpdate;
        }
        throw new CustomerNotFoundException("Cliente id " + id + " não encontrado");
    }


    public void increaseTotalSpent (Customer customer, BigDecimal amount) {

        Customer customerToUpdate = customerRepository.findById(customer.getId()).get();
        customerToUpdate.setTotalSpent(customer.getTotalSpent().add(amount));
    }
}
