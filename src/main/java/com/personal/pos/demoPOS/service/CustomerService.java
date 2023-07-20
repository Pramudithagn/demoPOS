package com.personal.pos.demoPOS.service;

import com.personal.pos.demoPOS.dto.request.CustomerRequestDto;

import java.util.List;

public interface CustomerService {
        public String saveCustomer(CustomerRequestDto dto);
        public com.personal.pos.demoPOS.dto.response.CustomerResponseDto findCustomer (String id) throws ClassNotFoundException;
        public String updateCustomer(CustomerRequestDto dto, String id) throws ClassNotFoundException;
        public String deleteCustomer(String id);
        public List<com.personal.pos.demoPOS.dto.response.CustomerResponseDto> findAllCustomers();
    }

