package com.multiple.common.service;

import java.util.List;

import com.multiple.common.model.Customer;


/**
 * Service interface for City.
 * 
 * @author Waheed 
 */
public interface CustomerService {
	
	Customer save(Customer customer)	throws Exception;
	void delete(Customer customer) ;
	Customer restore(Customer customer) ;
	Customer update(Customer customer) throws Exception;
	Customer findById(long customerId) ;
	List<Customer> findAllCustomers();

}
