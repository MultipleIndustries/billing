package com.multiple.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.multiple.common.model.location.CountryMaster;


public interface CountryRepository extends JpaRepository<CountryMaster, Long> {

	@Query("select country from CountryMaster country where country.active = ?1 order by country.countryName ASC")
	List<CountryMaster> findByActiveOrderByCountryNameAsc(boolean active);
	
	CountryMaster findByCountryName(String name);
}
