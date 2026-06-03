package com.workintech.s18d4.service;

import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public Customer find(long id) {
       return customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found"));
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer update(long id, Customer customer) {
        Customer db = customerRepository.getById(id);

        db.setFirstName(customer.getFirstName());
        db.setLastName(customer.getLastName());
        db.setEmail(customer.getEmail());
        db.setAddress(customer.getAddress());

        return customerRepository.save(db);
    }

    public Customer delete(long id) {
        Optional<Customer> account = customerRepository.findById(id);

        if (account.isEmpty()) {
            return null;
        }

        customerRepository.delete(account.get());
        return account.get();
    }
}
