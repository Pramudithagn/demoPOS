package com.personal.pos.demoPOS.repo;

import com.personal.pos.demoPOS.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
public interface CustomerRepo extends JpaRepository<Customer,String> {
}
