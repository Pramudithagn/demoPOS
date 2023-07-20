package com.personal.pos.demoPOS.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data // tostring,getter,setter,hashcode
public class CustomerDto {
    private  String id;
    private String name;
    private String address;
    private double salary;

}
