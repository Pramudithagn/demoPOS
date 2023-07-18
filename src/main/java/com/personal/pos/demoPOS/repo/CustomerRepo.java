package com.personal.pos.demoPOS.repo;

import com.personal.pos.demoPOS.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer,String> {
}
