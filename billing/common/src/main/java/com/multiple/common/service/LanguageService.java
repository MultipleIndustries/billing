package com.multiple.common.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.ModelMap;

import com.multiple.common.exception.DuplicateLanguageException;
import com.multiple.common.exception.NoSuchLanguageException;
import com.multiple.common.model.LanguageMaster;
import com.google.api.client.http.HttpRequest;

/**
 * Service interface for Area.
 * 
 * @author Vinay Kahar
 */
public interface LanguageService {
	
	ModelMap addLanguage(ModelMap model, Long id) throws NoSuchLanguageException ;

	ModelMap saveLanguage(ModelMap model, LanguageMaster languageMaster)
			throws DuplicateLanguageException;
	
	ModelMap getListingDetails(ModelMap model);
	
	Map<String, Object> getListingDetailsByPagination(Map<String, Object> model, Integer iColumns, 
			Integer sEcho, Integer iSortingCols, Integer iDisplayStart, Integer iDisplayLength, boolean active, HttpServletRequest request);
	
	void deleteRestore(Long id, boolean result);
	
	LanguageMaster findById(long languageId) throws NoSuchLanguageException;
	
	LanguageMaster findByName(String name);
	
	LanguageMaster findByShortName(String shortName);
	
	List<LanguageMaster> findByActive(boolean active);
}
