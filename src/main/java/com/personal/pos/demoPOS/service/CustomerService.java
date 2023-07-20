package com.personal.pos.demoPOS.service;

import com.personal.pos.demoPOS.dto.request.CustomerRequestDto;
import com.personal.pos.demoPOS.dto.response.CustomerResponseDto;
import com.personal.pos.demoPOS.dto.response.paginate.PaginatedCustomerResponseDto;

import java.util.List;

public interface CustomerService {
        public String saveCustomer(CustomerRequestDto dto);
        public CustomerResponseDto findCustomer (String id) throws ClassNotFoundException;
        public String updateCustomer(CustomerRequestDto dto, String id) throws ClassNotFoundException;
        public String deleteCustomer(String id);
        public PaginatedCustomerResponseDto findAllCustomers(
                String searchText, int page, int size
        );
    }

