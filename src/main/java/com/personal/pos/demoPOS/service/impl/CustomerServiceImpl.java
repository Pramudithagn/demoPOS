package com.personal.pos.demoPOS.service.impl;

import com.personal.pos.demoPOS.dto.request.CustomerDto;
import com.personal.pos.demoPOS.entity.Customer;
import com.personal.pos.demoPOS.repo.CustomerRepo;
import com.personal.pos.demoPOS.service.CustomerService;
import com.personal.pos.demoPOS.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;
    @Autowired
    private IdGenerator idGenerator;

    @Override
    public String saveCustomer(CustomerDto dto) {

        Customer c1 = new Customer(
                idGenerator.generateId(10), dto.getName(), dto.getAddress(), dto.getSalary()
        );
        customerRepo.save(c1);
        return c1.getId() + " Saved!";
    }

    @Override
    public String findCustomer(String id) {
        return null;
    }

    @Override
    public String updateCustomer(CustomerDto dto, String id) {
        return null;
    }

    @Override
    public String deleteCustomer(String id) {
        return null;
    }

    @Override
    public String findAllCustomers() {
        return null;
    }
}
