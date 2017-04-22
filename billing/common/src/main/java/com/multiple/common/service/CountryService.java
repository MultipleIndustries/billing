package com.multiple.common.service;

import java.util.List;

import com.multiple.common.exception.DuplicateCountryException;
import com.multiple.common.exception.NoSuchCountryException;
import com.multiple.common.exception.NoSuchCurrencyException;
import com.multiple.common.model.location.CountryMaster;

/**
 * Service interface for Country.
 * 
 * @author Priyanka
 */
public interface CountryService {

	CountryMaster save(String countryName)
			throws DuplicateCountryException;

	CountryMaster delete(long countryId) throws NoSuchCountryException;

	CountryMaster restore(long countryId) throws NoSuchCountryException;

	CountryMaster update(long countryId, String countryName)
			throws NoSuchCountryException, DuplicateCountryException;

	List<CountryMaster> findByActive(boolean active);

	CountryMaster findById(long countryId) throws NoSuchCountryException;

	List<CountryMaster> findByIds(Long[] countries);

	CountryMaster findByName(String name);
}
