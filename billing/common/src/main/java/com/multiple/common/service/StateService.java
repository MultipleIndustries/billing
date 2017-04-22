package com.multiple.common.service;

import java.util.List;

import com.multiple.common.exception.DuplicateStateException;
import com.multiple.common.exception.NoSuchCityException;
import com.multiple.common.exception.NoSuchCountryException;
import com.multiple.common.model.location.StateMaster;
import com.multiple.kernel.exception.BusinessException;

public interface StateService {
	
	
	StateMaster save(String stateName, Long countryId) throws DuplicateStateException,NoSuchCountryException ;

	List<StateMaster> findByActive(boolean active);
	
	StateMaster findByStateNameAndStateId(String stateName, Long StateId);
	
	List<StateMaster> findByStateCountryCountryId(Long countryId);

	StateMaster findByStateId(long stateId) throws NoSuchCityException,BusinessException;

	StateMaster update(Long stateId,String cityName, long countryId) throws DuplicateStateException, NoSuchCountryException;
	
	List<StateMaster> findByStateName(String name);

	StateMaster delete(Long stateId) ;

	StateMaster  restore(Long stateId) ;
	
}

