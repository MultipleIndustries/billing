package com.multiple.common.service;

import java.util.List;

import com.multiple.common.model.Bill;
import com.multiple.common.model.ProductMaster;


/**
 * Service interface for City.
 * 
 * @author Waheed 
 */
public interface BillService {

	Bill save(Bill bill)	throws Exception;
	void delete(Bill bill) ;
	Bill restore(Bill bill) ;
	Bill update(Bill bill) throws Exception;
	Bill findById(long billId) ;
	List<Bill> findAllBills();

}
