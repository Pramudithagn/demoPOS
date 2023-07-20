package com.personal.pos.demoPOS.service.impl;

import com.personal.pos.demoPOS.dto.CustomerDto;
import com.personal.pos.demoPOS.dto.request.CustomerRequestDto;
import com.personal.pos.demoPOS.dto.response.CustomerResponseDto;
import com.personal.pos.demoPOS.entity.Customer;
import com.personal.pos.demoPOS.repo.CustomerRepo;
import com.personal.pos.demoPOS.service.CustomerService;
import com.personal.pos.demoPOS.util.IdGenerator;
import com.personal.pos.demoPOS.util.mapper.CustomerMapper;
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
    @Autowired
    private CustomerMapper customerMapper;


    @Override
    public String saveCustomer(CustomerRequestDto dto) {

        CustomerDto cDto = new CustomerDto(idGenerator.generateId(10), dto.getName(), dto.getAddress(), dto.getSalary());
        return customerRepo.save(customerMapper.toCustomer(cDto)).getId()+ " Saved!";
    }

    @Override
    public CustomerResponseDto findCustomer(String id) throws ClassNotFoundException {
       /* Optional<Customer> selectedCustomer = customerRepo.findById(id);
        if (selectedCustomer.isPresent()){
            return selectedCustomer.get().toString();
        }
        return null;*/
        Customer c = customerRepo.findById(id).orElse(null);
        if (c == null) {
            throw new ClassNotFoundException("Not Found");
        }
        return new CustomerResponseDto(c.getId(), c.getName(), c.getAddress(), c.getSalary());

        //return customerRepo.findById(id);

    }

    @Override
    public String updateCustomer(CustomerRequestDto dto, String id) {
        Customer c = customerRepo.findById(id).orElse(null);
        if (null == c) return "Not found";
        c.setName(dto.getName());
        c.setAddress(dto.getAddress());
        c.setSalary(dto.getSalary());
        customerRepo.save(c); // update
        return c.getName() + " was Updated!";
    }

    @Override
    public String deleteCustomer(String id) {

        customerRepo.deleteById(id);
        return id + " was deleted!";
    }

    @Override
    public List<CustomerResponseDto> findAllCustomers() {
        List<CustomerResponseDto> dtoList = new ArrayList<>();
        List<Customer> list = customerRepo.findAll();
        for (Customer c : list
        ) {
            dtoList.add(new CustomerResponseDto(
                    c.getId(), c.getName(), c.getAddress(), c.getSalary()
            ));
        }
        return dtoList;
    }
}
