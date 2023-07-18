package com.personal.pos.demoPOS.api;

import com.personal.pos.demoPOS.dto.request.CustomerDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @PostMapping("/create") // http://localhost:8000/api/v1/customer/create (POST)
    public String save(@RequestBody CustomerDto dto){
        return dto.toString();
    }

    @GetMapping("/{id}")
    public String findCustomer(@PathVariable String id){
        return id+"-customer";
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
    public String findAllCustomer(){
        return "all customers";
    }


}
