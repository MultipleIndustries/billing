package com.multiple.common.service.impl;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.multiple.common.exception.DuplicateLanguageException;
import com.multiple.common.exception.NoSuchLanguageException;
import com.multiple.common.model.LanguageMaster;
import com.multiple.common.repository.LanguageRepository;
import com.multiple.common.service.LanguageService;
import com.multiple.kernel.exception.CustomException;

/**
 * Service interface for Area.
 * 
 * @author Vinay Kahar
 */
@Service
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageRepository repository;
	
	@Override
	public ModelMap addLanguage(ModelMap model, Long id) throws NoSuchLanguageException {
		LanguageMaster languageMaster = null;
		
		if(id!=null)
			languageMaster = findById(id);
		else
			languageMaster = new LanguageMaster();
			model.addAttribute("language", languageMaster);
		return model;
		
	}
	
	@Override
	public ModelMap saveLanguage(ModelMap model, LanguageMaster languageMaster)
			throws DuplicateLanguageException {
		
		LanguageMaster langByName = findByName(languageMaster.getLanguageName());
		LanguageMaster langByShortName = findByShortName(languageMaster.getShortName());
		
		if ((langByName!= null && languageMaster.getLanguageId()==null) || (
				languageMaster.getLanguageId()!=null && langByName!=null
				&& !languageMaster.getLanguageId().equals(langByName.getLanguageId()))) 
			throw new DuplicateLanguageException(
					CustomException.DUPLICATE_LANGUAGE.getCode());
		
		if( (langByShortName != null && languageMaster.getLanguageId()==null)||(
				languageMaster.getLanguageId()!=null && langByShortName!=null
				&& !languageMaster.getLanguageId().equals(langByShortName.getLanguageId())))
			throw new DuplicateLanguageException(
					CustomException.DUPLICATE_LANGUAGE_CODE.getCode());
		if(languageMaster.getLanguageId()!=null){
			try {
				LanguageMaster	languageMaster2 = findById(languageMaster.getLanguageId());
				languageMaster2.setLanguageName(languageMaster.getLanguageName());
				languageMaster2.setShortName(languageMaster.getShortName());
				languageMaster = languageMaster2;
			} catch (NoSuchLanguageException e) {
			}
		}
		
		model.addAttribute("language",repository.save(languageMaster));
		return model;
		
	}
	
	@Override
	public ModelMap getListingDetails(ModelMap model) {
		model.put("activeList", findByActive(true));
		model.put("inactiveList", findByActive(false));
		return model;
	}
	
	@Override
	public LanguageMaster findById(long languageId)
			throws NoSuchLanguageException {
		LanguageMaster language = repository.findOne(languageId);
		if (language == null) {
			throw new NoSuchLanguageException(
					CustomException.NO_SUCH_LANGUAGE.getCode());
		}
		return language;
	}
	
	@Override
	public LanguageMaster findByName(String name) {
		return repository.findByLanguageName(name);
	}
	
	@Override
	public LanguageMaster findByShortName(String shortName) {
		return repository.findByShortName(shortName);
	}

	@Override
	public List<LanguageMaster> findByActive(boolean active) {
		return repository.findByActive(active);
	}

	@Override
	public void deleteRestore(Long id, boolean result) {
		repository.deleteRestoreLanguage(result, id);
	}

	@Override
	public Map<String, Object> getListingDetailsByPagination(Map<String, Object> model, Integer iColumns, Integer sEcho, Integer iSortingCols,
			Integer iDisplayStart, Integer iDisplayLength, boolean active, HttpServletRequest request) {
		
		int sortColNo = 0;
		String sortColDir = "";
		String sSearch = null;
		try {
			sortColNo = Integer.parseInt((String) request
					.getParameter("iSortCol_0"));
			sortColDir = (String) request.getParameter("sSortDir_0");
			sSearch = (String) request.getParameter("sSearch");
			sSearch = sSearch == null ? "" : sSearch;
		} catch (Exception e) {
			sortColNo = 0;
			sortColDir = "asc";
		}
		int pageNo = (iDisplayStart + iDisplayLength) / iDisplayLength;
		int count = (pageNo-1)*iDisplayLength;
		Direction dir = sortColDir.equalsIgnoreCase("asc") ? Direction.ASC
				: Direction.DESC;
		Page<Object[]> pageObj = repository.findByActive(active, new PageRequest(pageNo-1, iDisplayLength, dir, "languageName"));
		List<Object[]> langList = pageObj.getContent();
		
		Long iTotalRecords = (long) pageObj.getTotalElements();
		model.put("draw", pageNo);
		model.put("iTotalRecords", iTotalRecords);
		model.put("iTotalDisplayRecords", iTotalRecords);
		model.put("sEcho", sEcho + "");
		model.put("iDisplayLength", "10");
		model.put("aaData", langList);
		
		
		return model;
	}

	

}
