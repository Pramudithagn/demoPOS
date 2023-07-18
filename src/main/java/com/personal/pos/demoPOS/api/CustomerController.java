package com.personal.pos.demoPOS.api;

import com.personal.pos.demoPOS.dto.request.CustomerDto;
import com.personal.pos.demoPOS.dto.response.CustomerResponseDto;
import com.personal.pos.demoPOS.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create") // http://localhost:8000/api/v1/customer/create (POST)
    public String save(@RequestBody CustomerDto dto){

        return customerService.saveCustomer(dto);
    }

    @GetMapping("/{id}")
    public String findCustomer(@PathVariable String id){

        return customerService.findCustomer(id);
    }

    @PutMapping(value = "/modify", params = {"id"})
    public String updateCustomer(@RequestBody CustomerDto dto, @RequestParam String id){
        return dto+"-"+id;
    }

    @DeleteMapping("/remove/{id}")
    public String deleteCustomer(@PathVariable String id){
        return id+" - customer";
    }

    @GetMapping("/list")
    public List<CustomerResponseDto> findAllCustomer(){

        return customerService.findAllCustomers();
    }


}
