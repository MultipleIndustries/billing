package com.multiple.common.service.impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiple.common.exception.DuplicateCityException;
import com.multiple.common.exception.DuplicateStateException;
import com.multiple.common.exception.NoSuchCityException;
import com.multiple.common.exception.NoSuchCountryException;
import com.multiple.common.model.location.CityMaster;
import com.multiple.common.model.location.CountryMaster;
import com.multiple.common.model.location.StateMaster;
import com.multiple.common.repository.StateRepository;
import com.multiple.common.service.CountryService;
import com.multiple.common.service.StateService;
import com.multiple.kernel.exception.BusinessException;
import com.multiple.kernel.exception.CustomException;
import com.multiple.kernel.exception.SystemException;

@Service
public class StateServiceImpl implements StateService {
	
	@Autowired
	private StateRepository stateRepository;
	
	@Autowired
	private CountryService countryService;

	@Override
	public StateMaster save(String stateName, Long countryId)
			throws DuplicateStateException, NoSuchCountryException {
		List<StateMaster> stateList = findByStateName(stateName);
		
		for(StateMaster smm : stateList)
		{
			if (smm!=null && smm.getCountry().getCountryId() == countryId)
			{
				throw new DuplicateStateException(CustomException.DUPLICATE_STATE.getCode());
			}
		}
		CountryMaster country = countryService.findById(countryId);
		StateMaster state = new StateMaster(stateName,country);
		return stateRepository.save(state);
	}

	@Override
	public List<StateMaster> findByActive(boolean active) {
		
		return stateRepository.findByActive(active);
	}

	@Override
	public StateMaster findByStateNameAndStateId(String stateName, Long StateId) {
		
		return null;
	}

	@Override
	public List<StateMaster> findByStateCountryCountryId(Long countryId) {
		return stateRepository.findByCountryCountryIdAndActiveTrueOrderByStateNameAsc(countryId);
	}

	@Override
	public StateMaster findByStateId(long stateId) {			
		return stateRepository.findByStateId(stateId);
	}

	@Override
	public StateMaster update(Long stateId, String stateName, long countryId)
			throws DuplicateStateException, NoSuchCountryException {
		List<StateMaster> sm = findByStateName(stateName);
		for(StateMaster stm: sm)
		{
			if(stm!=null && stm.getCountry().getCountryId()==countryId && stm.getStateId()!=stateId)
			{
				throw new DuplicateStateException(CustomException.DUPLICATE_STATE.getCode());
			}
		}
		StateMaster state = findByStateId(stateId);
		state.setStateName(stateName);
		CountryMaster country = countryService.findById(countryId);
		state.setCountry(country);
		return stateRepository.save(state);
		}
	

	@Override
	public List<StateMaster> findByStateName(String name) {

		return stateRepository.findByStateName(name);
	}

	@Override
	public StateMaster delete(Long stateId) {
		StateMaster state = findByStateId(stateId);
		state.setActive(false);
		return stateRepository.save(state);
		
	}

	@Override
	public StateMaster restore(Long stateId){
		StateMaster state = findByStateId(stateId);
		state.setActive(true);
		 return stateRepository.save(state);
	}
	
	
}