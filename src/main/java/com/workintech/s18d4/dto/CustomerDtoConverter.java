package com.workintech.s18d4.dto;

import com.workintech.s18d4.entity.Customer;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CustomerDtoConverter {

    public CustomerResponse convert(Customer customer) {
        return new CustomerResponse(customer.getId(),customer.getEmail(),customer.getSalary());
    }

    public List<CustomerResponse> convertCustomerResponseList(List<Customer> customers) {
        List<CustomerResponse> customerResponseList = new ArrayList<>();
        for (Customer customer : customers) {
            customerResponseList.add(convert(customer));
        }
        return customerResponseList;
    }
}
