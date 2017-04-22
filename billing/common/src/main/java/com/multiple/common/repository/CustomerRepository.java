package com.multiple.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiple.common.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

		
}
