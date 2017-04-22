package com.multiple.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiple.common.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

		
}
