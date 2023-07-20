package com.personal.pos.demoPOS.service.impl;

import com.personal.pos.demoPOS.dto.CustomerDto;
import com.personal.pos.demoPOS.dto.request.CustomerRequestDto;
import com.personal.pos.demoPOS.dto.response.CustomerResponseDto;
import com.personal.pos.demoPOS.dto.response.paginate.PaginatedCustomerResponseDto;
import com.personal.pos.demoPOS.entity.Customer;
import com.personal.pos.demoPOS.repo.CustomerRepo;
import com.personal.pos.demoPOS.service.CustomerService;
import com.personal.pos.demoPOS.util.IdGenerator;
import com.personal.pos.demoPOS.util.mapper.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional<Customer> byId = customerRepo.findById(id);
        if (byId.isPresent()) {
            return customerMapper.toCustomerResponseDto(byId.get());

            }
            throw new ClassNotFoundException("Not Found");


            //return customerRepo.findById(id);

        }


    @Override
    public String updateCustomer(CustomerRequestDto dto, String id) throws ClassNotFoundException {
            Optional<Customer> byId = customerRepo.findById(id);
            if (byId.isPresent()){
                byId.get().setName(dto.getName());
                byId.get().setAddress(dto.getAddress());
                byId.get().setSalary(dto.getSalary());
                customerRepo.save(byId.get());
                return byId.get().getName() + " was Updated!";
            }
            throw new ClassNotFoundException("Not Found");
    }

    @Override
    public String deleteCustomer(String id) {

        customerRepo.deleteById(id);
        return id + " was deleted!";
    }

    @Override
    public PaginatedCustomerResponseDto findAllCustomers(
            String searchText, int page, int size
    ) {
        // create method with a custom query=? (find data)
        // create method with a custom query=? (count)
        return new PaginatedCustomerResponseDto(
                customerRepo.countCustomer(searchText),
                customerMapper.toCustomerResponseDtoList(customerRepo.searchCustomer(
                        searchText, PageRequest.of(page, size)
                ))
        );

//        List<CustomerResponseDto> dtoList = new ArrayList<>();
//        List<Customer> list = customerRepo.findAll();
//        for (Customer c : list
//        ) {
//            dtoList.add(new CustomerResponseDto(
//                    c.getId(), c.getName(), c.getAddress(), c.getSalary()
//            ));
//        }
//        return dtoList;
    }
}
