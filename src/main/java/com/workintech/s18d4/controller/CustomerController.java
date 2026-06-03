package com.workintech.s18d4.controller;

import com.workintech.s18d4.dto.CustomerDtoConverter;
import com.workintech.s18d4.dto.CustomerResponse;
import com.workintech.s18d4.entity.Customer;
import com.workintech.s18d4.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<CustomerResponse> getAll() {
        List<Customer> customers = customerService.findAll();
        List<CustomerResponse> customersResponse = new ArrayList<>();
        for (Customer dbCustomer : customers) {
            customersResponse.add(new CustomerResponse(dbCustomer.getId(),dbCustomer.getEmail(),dbCustomer.getSalary()));
        }
        return customersResponse;
    }

    @GetMapping("/{id}")
    public CustomerResponse getById(@PathVariable long id) {
        Customer dbCustomer = customerService.find(id);
        return new CustomerResponse(dbCustomer.getId(),dbCustomer.getEmail(),dbCustomer.getSalary());
    }

    @PostMapping
    public CustomerResponse create(@RequestBody Customer customer) {
        Customer dbCustomer = customerService.save(customer);
        return new CustomerResponse(dbCustomer.getId(),dbCustomer.getEmail(),dbCustomer.getSalary());
    }

    @PutMapping("/{id}")
    public CustomerResponse update(@PathVariable long id, @RequestBody Customer customer) {
        Customer dbCustomer = customerService.update(id, customer);
        return new CustomerResponse(dbCustomer.getId(),dbCustomer.getEmail(),dbCustomer.getSalary());
    }

    @DeleteMapping("/{id}")
    public CustomerResponse delete(@PathVariable long id) {
        Customer dbCustomer = customerService.delete(id);
        return new CustomerResponse(dbCustomer.getId(),dbCustomer.getEmail(),dbCustomer.getSalary());
    }
}
