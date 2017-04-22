package com.multiple.common.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multiple.common.model.SMSDetails;
import com.multiple.common.repository.SMSDetailsRepository;
import com.multiple.common.service.SMSDetailsService;
import com.multiple.common.util.PropsValues;
import com.kpit.www.SendOTP.OTPResponse;
import com.OTPService;
/**
 * Service implementation for SMSDetails.
 * 
 * @author Priyanka
 */
@Service
public class SMSDetailsServiceImpl implements SMSDetailsService {

	@Autowired
	private SMSDetailsRepository SMSDetailsRepository;
	
	@Autowired
	private PropsValues propsValue;

	@Override
	public SMSDetails save(SMSDetails data) {
		try {
			 OTPResponse response=OTPService.sendOtp(data.getMobileno(),data.getMessagetext(),propsValue.SMS_SOURCE,propsValue.SMS_MODULE,
					propsValue.SMS_IDENTIFICATIONID,propsValue.SMS_SOURCE,propsValue.SMS_URL);
		 } catch(Exception ex) {
           System.out.println(ex.getMessage());
		 }
		 
		return SMSDetailsRepository.save(data);		
	}

}
