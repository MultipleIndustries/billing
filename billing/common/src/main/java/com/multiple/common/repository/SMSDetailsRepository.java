package com.multiple.common.repository;

import com.multiple.common.model.SMSDetails;

import java.awt.print.Pageable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface SMSDetailsRepository extends JpaRepository<SMSDetails, Long> {


}
