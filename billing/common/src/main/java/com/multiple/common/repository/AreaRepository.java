package com.multiple.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.multiple.common.model.location.AreaMaster;

public interface AreaRepository extends JpaRepository<AreaMaster, Long> {
	
	@Query("select a from AreaMaster a join fetch a.city join fetch a.country where a.active =?1 Order By areaName ASC")
	List<AreaMaster> findByActiveOrderByAreaNameAsc(boolean active);
	
	List<AreaMaster> findByAreaName(String name);
	
	@Query("select a from AreaMaster a join fetch a.city join fetch a.country where a.areaId=?1")
	AreaMaster findById(long areaId);
	/**
	 * This methods filters area list based on city and country id.
	 * @param cityId
	 * @param countryId
	 * @return list of area
	 * 
	 * @author Debjyoti Nath
	 */
	@Query("select a from AreaMaster a join fetch a.city join fetch a.country where a.active =1 and a.city.cityId=?1 and a.country.countryId=?2 Order By areaName ASC")
	List<AreaMaster> findByCityCityIdAndCountryCountryIdAndActiveTrueOrderByAreaNameAsc(long cityId,long countryId);
	
	@Query("select a from AreaMaster a join fetch a.city join fetch a.country where a.active =1 and a.city.cityId=?1 Order By areaName ASC")
	List<AreaMaster> findByActiveTrueAndCityCityId(long cityId);
}
