package com.multiple.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiple.common.model.ImageMaster;


public interface ImageRepository extends JpaRepository<ImageMaster, Long> {

}
