package com.multiple.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiple.common.model.Bill;
import com.multiple.common.repository.BillRepository;
import com.multiple.common.service.BillService;

/**
 * Service implementation for City.
 * 
 * @author Waheed
 */
@Service
public class BillServiceImpl implements BillService {

	@Autowired
	private BillRepository billRepository;

	@Override
	public Bill save(Bill bill) throws Exception {
		
		return billRepository.save(bill);
	}

	@Override
	public void delete(Bill bill) {
		billRepository.delete(bill);
	}

	@Override
	public Bill restore(Bill bill) {
		return billRepository.save(bill);
	}

	@Override
	public Bill update(Bill bill) throws Exception {
		return billRepository.save(bill);
	}

	@Override
	public Bill findById(long billId) {
		return billRepository.findOne(billId); 
	}

	@Override
	public List<Bill> findAllBills() {
		return billRepository.findAll();
	}

	
	
}
