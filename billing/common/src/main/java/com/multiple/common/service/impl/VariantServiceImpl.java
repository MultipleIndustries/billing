package com.multiple.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiple.common.model.VariantMaster;
import com.multiple.common.repository.VariantRepository;
import com.multiple.common.service.VariantService;

/**
 * Service implementation for City.
 * 
 * @author Waheed
 */
@Service
public class VariantServiceImpl implements VariantService {

	@Autowired
	private VariantRepository variantRepository;

	@Override
	public VariantMaster save(VariantMaster variant) throws Exception {
		return variantRepository.save(variant);
	}

	@Override
	public void delete(VariantMaster variant) {
		variantRepository.delete(variant);
		
	}

	@Override
	public VariantMaster restore(VariantMaster variant) {
		return variantRepository.save(variant);
	}

	@Override
	public VariantMaster update(VariantMaster variant) throws Exception {
		return variantRepository.save(variant);
	}

	@Override
	public VariantMaster findById(long variantId) {
		return variantRepository.findOne(variantId);
	}

	@Override
	public List<VariantMaster> findByProductId(long productId) {
		return null;
	}

	@Override
	public List<VariantMaster> findAllVariants() {
		return variantRepository.findAll();
	}

	
	
	
}
