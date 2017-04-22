package com.multiple.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiple.common.model.VariantMaster;

public interface VariantRepository extends JpaRepository<VariantMaster, Long> {

		
}
