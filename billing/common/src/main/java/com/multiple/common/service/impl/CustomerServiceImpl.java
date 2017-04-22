package com.multiple.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiple.common.model.Customer;
import com.multiple.common.model.ProductMaster;
import com.multiple.common.repository.CustomerRepository;
import com.multiple.common.repository.ProductRepository;
import com.multiple.common.service.CustomerService;
import com.multiple.common.service.ProductService;

/**
 * Service implementation for City.
 * 
 * @author Waheed
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer save(Customer customer) throws Exception {
		return customerRepository.save(customer);
	}

	@Override
	public void delete(Customer customer) {
		customerRepository.delete(customer);		
	}

	@Override
	public Customer restore(Customer customer) {
		return customerRepository.save(customer);
	}

	@Override
	public Customer update(Customer customer) throws Exception {
		return customerRepository.save(customer);
	}

	@Override
	public Customer findById(long customerId) {
		return customerRepository.findOne(customerId);
	}

	@Override
	public List<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}

	
}
