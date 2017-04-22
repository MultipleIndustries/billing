package com.multiple.common.service;

import java.util.List;

import com.multiple.common.model.Payment;
import com.multiple.common.model.ProductMaster;


/**
 * Service interface for City.
 * 
 * @author Waheed 
 */
public interface PaymentService {

	Payment save(Payment payment)	throws Exception;
	void delete(Payment payment) ;
	Payment restore(Payment payment) ;
	Payment update(Payment payment) throws Exception;
	Payment findById(long paymentId) ;	
	List<Payment> findAllPayments();
}
