package com.multiple.common.service;

import java.util.List;

import com.multiple.common.model.VariantMaster;

/**
 * Service interface for City.
 * 
 * @author Waheed 
 */
public interface VariantService {

	VariantMaster save(VariantMaster variant)	throws Exception;
	void delete(VariantMaster variant) ;
	VariantMaster restore(VariantMaster variant) ;
	VariantMaster update(VariantMaster variant) throws Exception;
	VariantMaster findById(long variant) ;
	List<VariantMaster> findByProductId(long productId);
	List<VariantMaster> findAllVariants();
	
}
