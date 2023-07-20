package com.personal.pos.demoPOS.api;

import com.personal.pos.demoPOS.dto.request.CustomerRequestDto;
import com.personal.pos.demoPOS.service.CustomerService;
import com.personal.pos.demoPOS.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin //haven't configured
@RequestMapping("/api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}) // http://localhost:8000/api/v1/customer/create (POST)
    public ResponseEntity<StandardResponse> save(@RequestBody CustomerRequestDto dto){

        return new ResponseEntity<>(
                new StandardResponse(
                        201/*????*/,
                        customerService.saveCustomer(dto),
                        null
                ), HttpStatus .CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StandardResponse> findCustomer(@PathVariable String id) throws ClassNotFoundException{

        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        id+" details!",
                        customerService.findCustomer(id)
                ), HttpStatus.OK
        );
    }

    @PutMapping(value = "/modify", params = {"id"})
    public ResponseEntity<StandardResponse> updateCustomer(@RequestBody CustomerRequestDto dto, @RequestParam String id) throws ClassNotFoundException{
        return new ResponseEntity<>(
                new StandardResponse(
                        201,
                        customerService.updateCustomer(dto, id),
                        null
                ), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<StandardResponse> deleteCustomer(@PathVariable String id){
        return new ResponseEntity<>(
                new StandardResponse(
                        204,
                        customerService.deleteCustomer(id),
                        null
                ), HttpStatus.NO_CONTENT
        );
    }

    @GetMapping(value = "/list", params = {"searchText","page","size"})
    public ResponseEntity<StandardResponse> findAllCustomer(
            @RequestParam String searchText,
            @RequestParam int page,
            @RequestParam int size){

        return new ResponseEntity<>(
                new StandardResponse(
                        200,
                        "Data List!",
                        customerService.findAllCustomers(searchText, page, size)
                ), HttpStatus.OK
        );
    }


}
