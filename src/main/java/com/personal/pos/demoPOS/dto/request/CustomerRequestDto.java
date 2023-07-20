package com.personal.pos.demoPOS.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data // tostring,getter,setter,hashcode
public class CustomerRequestDto {
    private String name;
    private String address;
    private double salary;

}
