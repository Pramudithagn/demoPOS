package com.personal.pos.demoPOS.service.impl;

import com.personal.pos.demoPOS.dto.request.CustomerDto;
import com.personal.pos.demoPOS.dto.response.CustomerResponseDto;
import com.personal.pos.demoPOS.entity.Customer;
import com.personal.pos.demoPOS.repo.CustomerRepo;
import com.personal.pos.demoPOS.service.CustomerService;
import com.personal.pos.demoPOS.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
       /* Optional<Customer> selectedCustomer = customerRepo.findById(id);
        if (selectedCustomer.isPresent()){
            return selectedCustomer.get().toString();
        }
        return null;*/
            return customerRepo.findById(id).orElse(null).toString();
            //return customerRepo.findById(id);

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
    public List<CustomerResponseDto> findAllCustomers()
    {
        List<CustomerResponseDto> dtoList = new ArrayList<>();
        List<Customer> list = customerRepo.findAll();
        for (Customer c: list
        ) {
            dtoList.add(new CustomerResponseDto(
                    c.getId(),c.getName(),c.getAddress(),c.getSalary()
            ));
        }
        return dtoList;
    }
}
