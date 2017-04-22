package com.multiple.common.service.impl;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multiple.common.exception.DuplicateCityException;
import com.multiple.common.exception.NoSuchCityException;
import com.multiple.common.exception.NoSuchCountryException;
import com.multiple.common.model.location.CityMaster;
import com.multiple.common.model.location.CountryMaster;
import com.multiple.common.model.location.StateMaster;
import com.multiple.common.repository.CityRepository;
import com.multiple.common.service.CityService;
import com.multiple.common.service.CountryService;
import com.multiple.common.service.ImageService;
import com.multiple.common.service.StateService;
import com.multiple.kernel.exception.BusinessException;
import com.multiple.kernel.exception.CustomException;
import com.multiple.kernel.exception.SystemException;

/**
 * Service implementation for City.
 * 
 * @author Rohit
 */
@Service
public class CityServiceImpl implements CityService {

	@Autowired
	private CityRepository cityRepository;
	
	@Autowired
	private StateService stateService;
	
	@Autowired
	private CountryService countryService;

	/*
	 * @Override public CityMaster save(String cityName, boolean showInPopup,
	 * long countryId, String timeZone, MultipartFile profile) throws
	 * DuplicateCityException, SystemException, BusinessException, IOException {
	 * 
	 * 
	 * CityMaster city = cityRepository.findByCountryCountryIdAndCityName(
	 * countryId, cityName); if (city != null) { // city already exist throw new
	 * DuplicateCityException( CustomException.DUPLICATE_CITY.getCode());
	 * 
	 * } ImageMaster cityImage = null; if (profile != null && profile.getSize()
	 * > 0) { String filename = profile.getOriginalFilename(); String ext =
	 * filename.substring(filename.lastIndexOf(".")); cityImage =
	 * imageService.addRestaurantImage(profile.getBytes(), ext, "City." + ext,
	 * false, false, "City", cityName);
	 * 
	 * }
	 * 
	 * 
	 * CountryMaster country = new CountryMaster();
	 * country.setCountryId(countryId); city = new CityMaster(cityName,
	 * showInPopup, country, timeZone); city.setProfileImage(cityImage); return
	 * cityRepository.save(city); }
	 */

	@Override
	public CityMaster delete(long cityId) throws NoSuchCityException {
		CityMaster city = findById(cityId);
		city.setActive(false);
		return cityRepository.save(city);
	}

	@Override
	public CityMaster restore(long cityId) throws NoSuchCityException {
		CityMaster city = findById(cityId);
		city.setActive(true);
		return cityRepository.save(city);
	}

	@Transactional
	@Override
	public CityMaster update(long cityId, String cityName, long stateId,
			long countryId) throws NoSuchCityException, DuplicateCityException,
			SystemException, BusinessException, IOException {
		List<CityMaster> cities = findByCityName(cityName);
		if (cities.size() > 0) { // city already exist
			for (CityMaster citymaster : cities) {
				if (citymaster.getCountry().getCountryId() == countryId
						&& citymaster.getState().getStateId() == stateId
						&& citymaster.getCityId() != cityId) {
					throw new DuplicateCityException(
							CustomException.DUPLICATE_CITY.getCode());
				}
			}
		}

		CityMaster city = findById(cityId);
		// ImageMaster profile = null;
		// String ext = null;
		/*
		 * if (profileBs != null && profileBs.length > 0) { ext =
		 * profileImage.substring(profileImage.lastIndexOf(".") + 1); profile =
		 * imageService.addRestaurantImage(profileBs, ext, "City." + ext, false,
		 * false, "City", cityName); if (city.getProfileImage() != null) {
		 * imageService.delete(city.getProfileImage().getImageId()); }
		 * city.setProfileImage(profile); }
		 */

		city.setCityName(cityName);
		// city.setShowInPopup(showInPopup);
		// city.setTimeZone(cityTimeZone);
		CountryMaster country = countryService.findById(countryId);
		StateMaster state = stateService.findByStateId(stateId);	
		city.setState(state);
		city.setCountry(country);
		// CityMaster updateCity = new CityMaster(cityName,state,country);
		// city.setCityTimeZone(updateCity.getCityTimeZone());
		return cityRepository.save(city);
	}

	@Override
	public List<CityMaster> findByActive(boolean active) {
		return cityRepository.findByActive(active);
	}

	@Override
	public List<CityMaster> findByCountryId(long countryId) {
		return cityRepository
				.findByCountryCountryIdAndActiveTrueOrderByCityNameAsc(countryId);
	}

	@Override
	public List<CityMaster> findByIds(Long[] cities) {
		Iterable<Long> citiesId = Arrays.asList(cities);
		return cityRepository.findAll(citiesId);
	}

	@Override
	public List<CityMaster> findByCityName(String name) {
		return cityRepository.findByCityName(name);
	}

	@Override
	public CityMaster findById(long cityId) throws NoSuchCityException {
		CityMaster city = cityRepository.findByCityId(cityId);
		if (city == null) {
			throw new NoSuchCityException(
					CustomException.NO_SUCH_CITY.getCode());
		}
		return city;
	}

	@Override
	public List<CityMaster> findLatestAdded(int start, int end) {
		// Page<CityMaster> latestCities = cityRepository.findByActiveTrue(new
		// PageRequest(start, end, Direction.DESC,
		// "createdOn"));
		// return latestCities.getContent();
		return null;
	}

	@Override
	public CityMaster save(String cityName, Long stateId, Long countryId)
			throws BusinessException{

		List<CityMaster> cities = cityRepository.findByCityName(cityName);
		if (cities.size() > 0) {
			for (CityMaster citymaster : cities) {
				if ((citymaster.getState().getStateId() == stateId)
						&& (citymaster.getCountry().getCountryId() == countryId)) {
					throw new DuplicateCityException(
							CustomException.DUPLICATE_CITY.getCode());
				}
			}
		}

		CountryMaster country = countryService.findById(countryId);
		StateMaster state = stateService.findByStateId(stateId);	
		CityMaster city1 = new CityMaster(cityName, state, country);
		return cityRepository.save(city1);
	}

	@Override
	public CityMaster save(String cityName, long countryId)
			throws DuplicateCityException, SystemException, BusinessException,
			IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CityMaster> findByStateId(Long stateId) {
		
		return cityRepository.findByStateStateIdAndActiveTrueOrderByCityNameAsc(stateId);
	}

}
