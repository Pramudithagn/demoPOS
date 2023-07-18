package com.personal.pos.demoPOS.entity;


import lombok.*;


import javax.persistence.Entity;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString

public class Customer {
    @Id
    private String id;
    private String name;
    private String address;
    private double salary;
}
