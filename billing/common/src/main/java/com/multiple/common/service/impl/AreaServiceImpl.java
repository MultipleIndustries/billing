package com.multiple.common.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiple.common.exception.DuplicateAreaException;
import com.multiple.common.exception.NoSuchAreaException;
import com.multiple.common.model.location.AreaMaster;
import com.multiple.common.model.location.CityMaster;
import com.multiple.common.model.location.CountryMaster;
import com.multiple.common.repository.AreaRepository;
import com.multiple.common.service.AreaService;
import com.multiple.kernel.exception.CustomException;

/**
 * Service implementation for area.
 * 
 * @author Rohit
 */
@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	public AreaRepository areaRepository;

	@Override
	public AreaMaster save(String areaName, Long cityId, Long countryId,
			double latitude, double longitude) throws DuplicateAreaException {
		List<AreaMaster> areas = findByName(areaName);
		if (areas.size()>0) { // area already exist
			for (AreaMaster areamaster : areas) {
				if (areamaster.getCity().getCityId() == cityId
						&& areamaster.getCountry().getCountryId() == countryId) {
					throw new DuplicateAreaException(
							CustomException.DUPLICATE_AREA.getCode());
				}
			}
		} 
		CityMaster city = new CityMaster();
		city.setCityId(cityId);
		CountryMaster country = new CountryMaster();
		country.setCountryId(countryId);
		AreaMaster area = new AreaMaster(areaName, city, country, latitude,
				longitude);
		return areaRepository.save(area);
	}

	@Override
	public AreaMaster delete(long areaId) throws NoSuchAreaException {
		AreaMaster area = findById(areaId);
		area.setActive(false);
		return areaRepository.save(area);
	}

	@Override
	public AreaMaster restore(long areaId) throws NoSuchAreaException {
		AreaMaster area = findById(areaId);
		area.setActive(true);
		return areaRepository.save(area);
	}

	@Override
	public AreaMaster update(long areaId, String areaName, Long cityId,
			Long countryId, double latitude, double longitude)
			throws NoSuchAreaException, DuplicateAreaException {
		List<AreaMaster> areas = findByName(areaName);
		if (areas != null) { // area already exist
			for (AreaMaster areamaster : areas) {
				if (areamaster.getAreaId() != areaId && areamaster.getCity().getCityId() == cityId
						&& areamaster.getCountry().getCountryId() == countryId) {
					throw new DuplicateAreaException(
							CustomException.DUPLICATE_AREA.getCode());
				}
			}
		}
		AreaMaster area = findById(areaId);
		CityMaster city = new CityMaster();
		city.setCityId(cityId);
		CountryMaster country = new CountryMaster();
		country.setCountryId(countryId);
		area.setAreaName(areaName);
		area.setCity(city);
		area.setCountry(country);
		area.setLatitude(latitude);
		area.setLongitude(longitude);
		return areaRepository.save(area);
	}

//	@Override
//	public List<AreaMaster> findByInActive(int start, int end) {
//		Page<AreaMaster> areaList = areaRepository
//				.findByActiveFalseOrderByAreaNameAsc(new PageRequest(start,
//						end, Direction.ASC, "areaName"));
//		return areaList.getContent();
//	}
//
//	@Override
//	public List<AreaMaster> findByActive(int start, int end) {
//		Page<AreaMaster> areaList = areaRepository
//				.findByActiveTrueOrderByAreaNameAsc(new PageRequest(start, end,
//						Direction.ASC, "areaName"));
//		return areaList.getContent();
//	}

	@Override
	public AreaMaster findById(long areaId) throws NoSuchAreaException {
		AreaMaster area = areaRepository.findById(areaId);
		if (area == null) {
			throw new NoSuchAreaException(
					CustomException.NO_SUCH_AREA.getCode());
		}
		return area;
	}

	@Override
	public List<AreaMaster> findByActive(boolean active) {
		return areaRepository.findByActiveOrderByAreaNameAsc(active);
	}

	@Override
	public List<AreaMaster> findByName(String areaName) {
		return areaRepository.findByAreaName(areaName);
	}

	@Override
	public List<AreaMaster> findAllByActiveByCityIdAndCountryId(long cityId,
			long countryId) {
		return areaRepository
				.findByCityCityIdAndCountryCountryIdAndActiveTrueOrderByAreaNameAsc(
						cityId, countryId);
	}

	@Override
	public List<AreaMaster> findActiveByCityId(long cityId) {
		return areaRepository.findByActiveTrueAndCityCityId(cityId);
	}

}
