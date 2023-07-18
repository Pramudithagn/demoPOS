package com.personal.pos.demoPOS.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data // tostring,getter,setter,hashcode
public class CustomerResponseDto {
    private String id;
    private String name;
    private String address;
    private double salary;

}
