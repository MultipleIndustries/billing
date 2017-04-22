package com.multiple.common.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.multiple.common.model.location.CityMaster;
import com.multiple.common.model.location.StateMaster;

public interface StateRepository extends JpaRepository<StateMaster, Long> {

	
	@Query("select state from StateMaster state join fetch state.country where state.stateId = ?1") 
	StateMaster findByStateId(Long stateId);

	@Query("select state from StateMaster state join fetch state.country where state.stateName=?1")
	List<StateMaster> findByStateName(String stateName);


	@Query("select state from StateMaster state join fetch state.country where state.active = ?1 Order By state.stateName Asc")
	List<StateMaster> findByActive(boolean Active);
	
	
	@Query("select state from StateMaster state join fetch state.country where state.active = true Order By state.stateName Asc")
	List<StateMaster> findAllByActiveTrue();
	
	@Query("select state from StateMaster state join fetch state.country where state.active = 1 and state.country.countryId=?1 Order By state.stateName Asc")
	List<StateMaster> findByCountryCountryIdAndActiveTrueOrderByStateNameAsc(
			long countryId);
	
	
	List<StateMaster> findByCountryCountryId(Long countryId);
}
