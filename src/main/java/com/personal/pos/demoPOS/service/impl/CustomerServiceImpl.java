package com.personal.pos.demoPOS.service.impl;

import com.personal.pos.demoPOS.dto.request.CustomerDto;
import com.personal.pos.demoPOS.repo.CustomerRepo;
import com.personal.pos.demoPOS.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Override
    public String saveCustomer(CustomerDto dto) {
        customerRepo.save();
        return null;
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
