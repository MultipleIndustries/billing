package com.multiple.common.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiple.common.exception.DuplicateCountryException;
import com.multiple.common.exception.NoSuchCountryException;
import com.multiple.common.exception.NoSuchCurrencyException;
//import com.multiple.common.model.CurrencyMaster;
import com.multiple.common.model.location.CountryMaster;
import com.multiple.common.repository.CountryRepository;
import com.multiple.common.service.CountryService;
//import com.multiple.common.service.CurrencyService;
import com.multiple.common.util.CommonUtil;
import com.multiple.kernel.exception.CustomException;

/**
 * Service implementation for Country.
 * 
 * @author Priyanka
 */
@Service
public class CountryServiceImpl implements CountryService {

	// private static final Log logger =
	// LogFactory.getLog(CountryServiceImpl.class);
	// StopWatch stopWatch=new StopWatch();
	//

	// @Autowired
	private CommonUtil commonUtil;

	@Autowired
	private CountryRepository countryRepository;
	
//	@Autowired
//	private CurrencyService currencyService; 


	@Override
	public CountryMaster save(String countryName)
			throws DuplicateCountryException {
		CountryMaster countryMaster = findByName(countryName);
		if (countryMaster != null) {// country already exist
			throw new DuplicateCountryException(
					CustomException.DUPLICATE_COUNTRY.getCode());
		} else {
			if (commonUtil != null)
			commonUtil.deleteCache("country");
//			CurrencyMaster currency = new CurrencyMaster();
//			currency.setCurrencyId(currencyId);
			CountryMaster country = new CountryMaster(countryName);
			return countryRepository.save(country);
		}
	}


	@Override
	public CountryMaster update(long countryId, String countryName)
			throws DuplicateCountryException, NoSuchCountryException {
		CountryMaster country = findByName(countryName);
		if (country != null && country.getCountryId() != countryId) {
			throw new DuplicateCountryException(
					CustomException.DUPLICATE_COUNTRY.getCode());
		} else {
			
			country =findById(countryId);
//			CurrencyMaster currency = currencyService.findById(currencyId);
			country.setCountryName(countryName);
//			country.setCurrency(currency);
			return countryRepository.save(country);
			
			
			
			
		}
	}

	public CountryMaster delete(long countryId) throws NoSuchCountryException {
		CountryMaster country = findById(countryId);
		country.setActive(false);
		return countryRepository.save(country);
	}

	public CountryMaster restore(long countryId) throws NoSuchCountryException {
		CountryMaster country = findById(countryId);
		country.setActive(true);
		return countryRepository.save(country);
	}

	public List<CountryMaster> findByActive(boolean active) {
		return countryRepository.findByActiveOrderByCountryNameAsc(active);
			
	}

	@Override
	public CountryMaster findById(long countryId) throws NoSuchCountryException {
		CountryMaster country = countryRepository.findOne(countryId);
		if (country == null) {
			throw new NoSuchCountryException(
					CustomException.NO_SUCH_COUNTRY.getCode());
		}
		return country;
	}

//	@Override
//	// @Cacheable(value="country")
//	public Page<CountryMaster> findByActive(int start, int end) {
//		// stopWatch.start();
//		Page<CountryMaster> countryList = countryRepository
//				.findAll(new PageRequest(start, end, Direction.ASC,
//						"countryName"));
//		// stopWatch.stop();
//
//		return countryList;
//	}

	@Override
	public List<CountryMaster> findByIds(Long[] countries) {
		Iterable<Long> countryIds = Arrays.asList(countries);
		return countryRepository.findAll(countryIds);
	}

	@Override
	public CountryMaster findByName(String name) {
		return countryRepository.findByCountryName(name);
	}


}
