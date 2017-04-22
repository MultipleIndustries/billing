package com.multiple.common.repository;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.multiple.common.model.location.CityMaster;

public interface CityRepository extends JpaRepository<CityMaster, Long> {

	@Query("select city from CityMaster city join fetch city.country join fetch city.state where city.active = ?1 Order By city.cityName Asc")
	List<CityMaster> findByActive(boolean active);

	@Query("select city from CityMaster city join fetch city.country where city.active = 1 and city.country.countryId=?1 Order By city.cityName Asc")
	List<CityMaster> findByCountryCountryIdAndActiveTrueOrderByCityNameAsc(
			long countryId);

	@Query("select city from CityMaster city join fetch city.country join fetch city.state where city.cityName=?1")
	List<CityMaster> findByCityName(String cityName);

	@Query("select city from CityMaster city join fetch city.country join fetch city.state where city.cityId=?1")
	CityMaster findByCityId(Long id);

	@Query("select city from CityMaster city join fetch city.country where city.country.countryId=?1 and city.cityName= ?2 Order By city.cityName Asc")
	CityMaster findByCountryCountryIdAndCityName(long countryId, String cityName);
	
	@Query("select city from CityMaster city join fetch city.country join fetch city.state where city.active = 1 and city.state.stateId=?1 Order By city.cityName Asc")
	List<CityMaster> findByStateStateIdAndActiveTrueOrderByCityNameAsc(long stateId);
	
	
	
	//List<CityMaster> findByActive( boolean active);

	
//	@Query(value = "select city from CityMaster city join fetch city.country  where city.active = 1 and city.showInPopup = 1", countQuery = "select count(c) from CityMaster  c where c.active = 1")
//	Page<CityMaster> findByActiveTrue(Pageable page);
}
