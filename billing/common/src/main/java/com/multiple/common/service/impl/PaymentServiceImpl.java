package com.multiple.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiple.common.model.Payment;
import com.multiple.common.repository.PaymentRepository;
import com.multiple.common.service.PaymentService;

/**
 * Service implementation for City.
 * 
 * @author Waheed
 */
@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public Payment save(Payment payment) throws Exception {
		return paymentRepository.save(payment);
	}

	@Override
	public void delete(Payment payment) {
		paymentRepository.delete(payment);
	}

	@Override
	public Payment restore(Payment payment) {
		return paymentRepository.save(payment);
	}

	@Override
	public Payment update(Payment payment) throws Exception {
		return paymentRepository.save(payment);
	}

	@Override
	public Payment findById(long paymentId) {
		return paymentRepository.findOne(paymentId);
	}

	@Override
	public List<Payment> findAllPayments() {
		return paymentRepository.findAll();
	}

	
	
}
