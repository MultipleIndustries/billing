package com.multiple.common.service;

import java.util.List;

import com.multiple.common.model.ProductMaster;


/**
 * Service interface for City.
 * 
 * @author Waheed 
 */
public interface ProductService {
	
	ProductMaster save(ProductMaster product)	throws Exception;
	void delete(ProductMaster product) ;
	ProductMaster restore(ProductMaster product) ;
	ProductMaster update(ProductMaster product) throws Exception;
	ProductMaster findById(long productId) ;
	List<ProductMaster> findAllProducts();

}
