package com.personal.pos.demoPOS.service;

import com.personal.pos.demoPOS.dto.request.CustomerDto;
import com.personal.pos.demoPOS.dto.response.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
        public String saveCustomer(CustomerDto dto);
        public String findCustomer(String id);
        public String updateCustomer(CustomerDto dto, String id);
        public String deleteCustomer(String id);
        public List<CustomerResponseDto> findAllCustomers();
    }

