package com.multiple.common.service;

import java.util.List;

import com.multiple.common.exception.DuplicateAreaException;
import com.multiple.common.exception.NoSuchAreaException;
import com.multiple.common.model.location.AreaMaster;

/**
 * Service interface for Area.
 * 
 * @author Rohit
 */
public interface AreaService {

	/**
	 * Save Area
	 * 
	 * @param areaName
	 * @param cityId
	 * @param countryId
	 * @param latitude
	 * @param longitude
	 * @return Area
	 * @throws DuplicateAreaException
	 */
	AreaMaster save(String areaName, Long cityId, Long countryId,
			double latitude, double longitude) throws DuplicateAreaException;

	/**
	 * Delete Area
	 * 
	 * @param areaId
	 * @return Area
	 * @throws NoSuchAreaException
	 */
	AreaMaster delete(long areaId) throws NoSuchAreaException;

	/**
	 * Restore Area
	 * 
	 * @param areaId
	 * @return Area
	 * @throws NoSuchAreaException
	 */
	AreaMaster restore(long areaId) throws NoSuchAreaException;

	/**
	 * Update  Area
	 * 
	 * @param areaId
	 * @param areaName
	 * @param cityId
	 * @param countryId
	 * @param latitude
	 * @param longitude
	 * @return
	 * @throws NoSuchAreaException
	 * @throws DuplicateAreaException
	 */
	AreaMaster update(long areaId, String areaName, Long cityId,
			Long countryId, double latitude, double longitude)
			throws NoSuchAreaException, DuplicateAreaException;

	/**
	 * Use this method if you need complete object
	 * 
	 * @param areaId
	 * @return AreaMaster 
	 * @throws NoSuchAreaException
	 */
	AreaMaster findById(long areaId) throws NoSuchAreaException;

	/**
	 * Find Active List , Fetch join up to first level
	 * 
	 * @return List<AreaMaster>
	 */
	List<AreaMaster> findByActive(boolean active);
	
	/**
	 * Use this method only for name validation
	 * It will return only area no join
	 * 
	 * @param areaName
	 * @return Area
	 */
	List<AreaMaster> findByName(String areaName);

	/**
	 * This methods filters area list based on city and country id.
	 * 
	 * @param cityId
	 * @param countryId
	 * @return list of area
	 * 
	 * @author Debjyoti Nath
	 */
	List<AreaMaster> findAllByActiveByCityIdAndCountryId(long cityId,long countryId);
	
	List<AreaMaster> findActiveByCityId(long cityId);
}
