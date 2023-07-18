package com.personal.pos.demoPOS.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data // tostring,getter,setter,hashcode
public class CustomerDto {
    private String name;
    private String address;
    private double salary;

}
