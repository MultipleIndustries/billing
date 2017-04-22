package com.multiple.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiple.common.model.Bill;

public interface BillRepository extends JpaRepository<Bill, Long> {

		
}
