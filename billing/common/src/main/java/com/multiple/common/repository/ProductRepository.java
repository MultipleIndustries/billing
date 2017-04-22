package com.multiple.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiple.common.model.ProductMaster;

public interface ProductRepository extends JpaRepository<ProductMaster, Long> {

		
}
