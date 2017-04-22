package com.multiple.common.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.multiple.common.model.LanguageMaster;

public interface LanguageRepository extends JpaRepository<LanguageMaster, Long> {
	LanguageMaster findByShortName(String name);

	LanguageMaster findByLanguageName(String name);

	List<LanguageMaster> findByActive(boolean active);
	
	@Modifying
	@Transactional
	@Query("update LanguageMaster lm set lm.active = ?1 where lm.languageId = ?2")
	int deleteRestoreLanguage(boolean active, Long id);
	
	
	@Query(value = "select lang from LanguageMaster lang "
			 + "where  lang.active=?1", countQuery = "select count(lang) from LanguageMaster lang where  lang.active=?1")
	Page<Object[]> findByActive(boolean active, Pageable page);
}
