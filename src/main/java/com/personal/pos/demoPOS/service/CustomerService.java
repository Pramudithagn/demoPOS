package com.personal.pos.demoPOS.service;

import com.personal.pos.demoPOS.dto.request.CustomerDto;
import com.personal.pos.demoPOS.dto.response.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
        public String saveCustomer(CustomerDto dto);
        public CustomerResponseDto findCustomer (String id) throws ClassNotFoundException;
        public String updateCustomer(CustomerDto dto, String id);
        public String deleteCustomer(String id);
        public List<CustomerResponseDto> findAllCustomers();
    }

