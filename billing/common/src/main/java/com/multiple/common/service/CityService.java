package com.multiple.common.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.multiple.common.exception.DuplicateAreaException;
import com.multiple.common.exception.DuplicateCityException;
import com.multiple.common.exception.NoSuchCityException;
import com.multiple.common.exception.NoSuchCountryException;
import com.multiple.common.model.TimeZoneEnum;
import com.multiple.common.model.location.CityMaster;
import com.multiple.kernel.exception.BusinessException;
import com.multiple.kernel.exception.SystemException;

/**
 * Service interface for City.
 * 
 * @author Rohit
 */
public interface CityService {

	/**
	 * Save city
	 * 
	 * @param cityName
	 * @param showInPopup
	 * @param countryId
	 * @param timeZoneName
	 * @return
	 * @throws DuplicateCityException
	 */
	
	CityMaster save(String cityName, long countryId)
			throws DuplicateCityException, SystemException, BusinessException,
			IOException;

	/**
	 * Delete City
	 * 
	 * @param cityId
	 * @return
	 * @throws NoSuchCityException
	 */
	CityMaster delete(long cityId) throws NoSuchCityException;

	/**
	 * Restore City
	 * 
	 * @param cityId
	 * @return
	 * @throws NoSuchCityException
	 */
	CityMaster restore(long cityId) throws NoSuchCityException;

	/**
	 * Update
	 * 
	 * @param cityId
	 * @param cityName
	 * @param showInPopup
	 * @param countryId
	 * @param timeZoneName
	 * @return
	 * @throws NoSuchCityException
	 * @throws DuplicateCityException
	 */
	CityMaster update(long cityId, String cityName, long stateId,
			long countryId) throws NoSuchCityException,
			DuplicateCityException, SystemException, BusinessException,
			IOException;

	//
	// /**
	// *
	// * @param start
	// * @param end
	// * @return
	// */
	// List<CityMaster> findByInActive(int start, int end);

	// List<CityMaster> findByActive(int start, int end);

	/**
	 * 
	 * @return
	 */
	List<CityMaster> findByActive(boolean active);

	/**
	 * Fetch with country
	 * 
	 * @param cityId
	 * @return
	 * @throws NoSuchCityException
	 */
	CityMaster findById(long cityId) throws NoSuchCityException;

	/**
	 * without country
	 * 
	 * @return
	 */

	/**
	 * 
	 * @param countryId
	 * @return
	 */
	List<CityMaster> findByCountryId(long countryId);

	List<CityMaster> findByIds(Long[] cities);



	/**
	 * without country
	 * 
	 * @return
	 */
	List<CityMaster> findByCityName(String name);

	List<CityMaster> findLatestAdded(int start, int end);
	
	CityMaster save(String cityName, Long stateId, Long countryId) throws BusinessException ;
	
	List<CityMaster> findByStateId(Long stateId);


	
	
	
}
