/**
 * Copyright (c) 2014 Astrika, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.multiple.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Priyanka
 */
@Component("propsValues")
public class PropsValues {

	@Value("#{portalProperties['session.cookie.domain']}")
	public String SESSION_COOKIE_DOMAIN;

	@Value("#{portalProperties['session.enable.persistent.cookies']}")
	public boolean SESSION_ENABLE_PERSISTENT_COOKIES;

	@Value("#{portalProperties['session.test.cookie.support']}")
	public boolean SESSION_TEST_COOKIE_SUPPORT;

	@Value("#{portalProperties['session.timeout']}")
	public int SESSION_TIMEOUT;

	@Value("#{portalProperties['session.timeout.auto.extend']}")
	public boolean SESSION_TIMEOUT_AUTO_EXTEND;

	@Value("#{portalProperties['session.timeout.redirect.on.expire']}")
	public boolean SESSION_TIMEOUT_REDIRECT_ON_EXPIRE;

	@Value("#{portalProperties['session.timeout.warning']}")
	public int SESSION_TIMEOUT_WARNING;

	@Value("#{portalProperties['captcha.engine.simplecaptcha.background.producers']}")
	public String CAPTCHA_ENGINE_SIMPLECAPTCHA_BACKGROUND_PRODUCERS;

	@Value("#{portalProperties['captcha.engine.simplecaptcha.gimpy.renderers']}")
	public String CAPTCHA_ENGINE_SIMPLECAPTCHA_GIMPY_RENDERERS;

	@Value("#{portalProperties['captcha.engine.simplecaptcha.height']}")
	public int CAPTCHA_ENGINE_SIMPLECAPTCHA_HEIGHT;

	@Value("#{portalProperties['captcha.engine.simplecaptcha.noise.producers']}")
	public String CAPTCHA_ENGINE_SIMPLECAPTCHA_NOISE_PRODUCERS;

	@Value("#{portalProperties['captcha.engine.simplecaptcha.text.producers']}")
	public String CAPTCHA_ENGINE_SIMPLECAPTCHA_TEXT_PRODUCERS;

	@Value("#{portalProperties['captcha.engine.simplecaptcha.width']}")
	public int CAPTCHA_ENGINE_SIMPLECAPTCHA_WIDTH;

	@Value("#{portalProperties['captcha.engine.simplecaptcha.word.renderers']}")
	public String CAPTCHA_ENGINE_SIMPLECAPTCHA_WORD_RENDERERS;

	@Value("#{portalProperties['captcha.max.challenges']}")
	public int CAPTCHA_MAX_CHALLENGES = 1;

	@Value("#{portalProperties['pagination.start']}")
	public int PAGINATION_SART;

	@Value("#{portalProperties['pagination.end']}")
	public int PAGINATION_END;
	
	@Value("#{portalProperties['email.memberauthentication']}")
	public String MEMBER_AUTHENTICATION;

	@Value("#{portalProperties['email.forgotpassword']}")
	public String FORGOT_PASSWORD;

	@Value("#{portalProperties['email.forgotlogin']}")
	public String FORGOT_LOGIN;

	@Value("#{portalProperties['email.resetPasswordForInstructor']}")
	public String RESET_PASSWORD_FOR_INSTRUCTOR;
	
	@Value("#{portalProperties['email.restAdminDetailsMail']}")
	public String RESTAURANT_ADMIN_DETAILS_MAIL;
	
	@Value("#{portalProperties['email.resetPasswordForUniversityAdmin']}")
	public String RESET_PASSWORD_FOR_UNIVERSITY_ADMIN;
	
	@Value("#{portalProperties['email.resetPasswordForCorporateAdmin']}")
	public String RESET_PASSWORD_FOR_CORPORATE_ADMIN;
	
	@Value("#{portalProperties['email.companyAdminDetailsMail']}")
	public String COMPANY_ADMIN_DETAILS_MAIL;
	
	@Value("#{portalProperties['email.corporateAdminDetailsMail']}")
	public String CORPORATE_ADMIN_DETAILS_MAIL;
	
	@Value("#{portalProperties['email.resetPasswordForBrandAdmin']}")
	public String RESET_PASSWORD_FOR_BRAND_ADMIN;
	
	@Value("#{portalProperties['email.brandAdminDetailsMail']}")
	public String BRAND_ADMIN_DETAILS_MAIL;

	@Value("#{portalProperties['root.url']}")
	public String ROOT_URL;
	
	@Value("#{portalProperties['email.restFeatureChangeMailToComp']}")
	public String REST_FEATURE_CHANGE_TO_COMPANY;
	
	@Value("#{portalProperties['email.restFeatureChangeMailToBrand']}")
	public String REST_FEATURE_CHANGE_TO_BRAND;
	
	@Value("#{portalProperties['email.brandFeatureChangeMailToComp']}")
	public String BRAND_FEATURE_CHANGE_TO_COMPANY;
	
	@Value("#{portalProperties['context.url']}")
	public String CONTEXT_URL;
	
	@Value("#{portalProperties['website.name']}")
	public String WEBSITE_NAME;

	@Value("#{portalProperties['root.restpasswordurl']}")
	public String RESET_PASSWPRD_URL;

	@Value("#{portalProperties['email.from']}")
	public String EMAIL_FROM;
	
	@Value("#{portalProperties['emailto.admin']}")
	public String EMAIL_TO_ADMIN;
	
//	@Value("#{gourmet7Properties['g7.base.currency']}")
//	public String BASE_CURRENCY;

	@Value("#{portalProperties['member.firstCardNumber']}")
	public String FIRST_CARD_NUMBER;
	
	@Value("#{portalProperties['evite.eviteInvitation']}")
	public String EVITE_INVITATION;
	
	@Value("#{portalProperties['evite.eviteCancellation']}")
	public String EVITE_CANCELLATION;
	
	@Value("#{portalProperties['evite.eviteEdit']}")
	public String EVITE_EDIT;
	
	@Value("#{portalProperties['documents.root']}")
	public String DOCUMENTS_ROOT;
	
	@Value("#{portalProperties['documents.url']}")
	public String DOCUMENT_URL;
	
	@Value("#{portalProperties['promocode.timeDifference']}")
	public long  PROMOCODE_TIME_DIFF;
	
	@Value("#{portalProperties['email.promocodemail']}")
	public String PROMOCODE_MAIL;
	
	@Value("#{portalProperties['email.individualvouchermail']}")
	public String INDIVIDUAL_VOUCHER_MAIL;
	
	@Value("#{portalProperties['email.giftedvouchermail']}")
	public String GIFTED_VOUCHER_MAIL;
	
	@Value("#{portalProperties['email.corporatevouchermail']}")
	public String CORPORATE_VOUCHER_MAIL;
	
	@Value("#{portalProperties['base.currency']}")
	public int BASE_CURRENCY;

	@Value("#{portalProperties['pagination.interval']}")
	public int PAGINATION_INTERVAL;
	
	@Value("#{portalProperties['email.corporatecodemail']}")
	public String CORPORATE_CODE_MAIL;
	
	@Value("#{portalProperties['email.corporatedlinkmail']}")
	public String CORPORATE_DLINK_MAIL;
	
	@Value("#{portalProperties['email.memberdlinkmail']}")
	public String MEMBER_DLINK_MAIL;
	
	@Value("#{portalProperties['simple.dateformate']}")
	public String SIMPLE_DATE_FORMAT;
	
	@Value("#{portalProperties['simple.timeformate']}")
	public String SIMPLE_TIME_FORMAT;
	
	@Value("#{portalProperties['simple.datetimeformate']}")
	public String SIMPLE_DATETIME_FORMAT;
	
	@Value("#{portalProperties['simple.datetimezoneformate']}")
	public String SIMPLE_DATE_TIMEZONE_FORMAT;
	
	@Value("#{portalProperties['special.dateformate']}")
	public String SPECIAL_DATE_FORMAT;
	
	@Value("#{portalProperties['slash.dateformat']}")
	public String DATE_FORMAT;
	
	@Value("#{portalProperties['email.memberdetailsmail']}")
	public String MEMEBER_DETAILS_MAIL;
	
	@Value("#{portalProperties['point.membershipDefaultValue']}")
	public int MEMBERSHIP_DEFAULT_POINTVALUE;
	
	@Value("#{portalProperties['point.membershipCancellationAmount']}")
	public int MEMBERSHIP_CANCELLATION_VALUE;
	
	@Value("#{portalProperties['point.restaurantDefaultValue']}")
	public int RESTAURANT_DEFAULT_POINTVALUE;
	
	@Value("#{portalProperties['imagesupportedformat']}")
	public String IMAGE_SUPPORTED_FORMAT;
	
	@Value("#{portalProperties['default.timezone']}")
	public String DEFAULT_TIMEZONE;
	
	
	@Value("#{portalProperties['session.warning']}")
	public int CONCURRENCY_SESSION_WARNING;
	
	
	@Value("#{portalProperties['session.expire']}")
	public int CONCURRENCY_SESSION_EXPIRE;
	
	@Value("#{portalProperties['prefix.company']}")
	public String COMPANY_LOGIN_PREFIX;
	
	@Value("#{portalProperties['prefix.brand']}")
	public String BRAND_LOGIN_PREFIX;
	
	@Value("#{portalProperties['prefix.rest']}")
	public String RESTAURANT_LOGIN_PREFIX;
	
	@Value("#{portalProperties['prefix.corporate']}")
	public String CORPORATE_LOGIN_PREFIX;
	
	@Value("#{portalProperties['trial.tenure']}")
	public String TRIAL_TENURE;
	
	@Value("#{portalProperties['trial.cities']}")
	public String TRIAL_CITIES;
	
	@Value("#{portalProperties['course.header']}")
	public String COURSE_HEADER;
	
	@Value("#{portalProperties['course.courseInvitation']}")
	public String COURSE_INVITATION;
	
	@Value("#{portalProperties['courseBatch.courseBatchInvitation']}")
	public String COURSE_BATCH_INVITATION;
	
	
	@Value("#{portalProperties['sms.provider.source']}")
	public String SMS_SOURCE;
	
	@Value("#{portalProperties['sms.provider.module']}")
	public String SMS_MODULE;
	
	@Value("#{portalProperties['sms.provider.identificationId']}")
	public String SMS_IDENTIFICATIONID;
	
	@Value("#{portalProperties['sms.provider.target']}")
	public String SMS_TARGET;
	
	@Value("#{portalProperties['sms.otp.message']}")
	public String SMS_OTP_MSG;
	
	@Value("#{portalProperties['sms.register.message']}")
	public String SMS_REGISTER_MSG;
	
	@Value("#{portalProperties['sms.provider.url']}")
	public String SMS_URL;
	
	@Value("#{esignProperties['esignCode']}") 
	public String esignCode;
	
	@Value("#{esignProperties['signKeyStore']}") 
	public String signKeyStore;
	
	@Value("#{esignProperties['sa']}") 
	public String sa;
	 
	@Value("#{esignProperties['licenseKey']}") 
	public String licenseKey;
	
	  //private static String asaLicenseKey;
	@Value("#{esignProperties['terminalId']}") 
	public String terminalId;
	
	@Value("#{esignProperties['publicKeyFile']}") 
	public String publicKeyFile;
	
	@Value("#{esignProperties['publicKeyFileDSIG']}") 
	public String publicKeyFileDSIG;
	
	@Value("#{esignProperties['usesPi']}") 
	public boolean usesPi;
	
	@Value("#{esignProperties['usesPa']}") 
	public boolean usesPa;
	
	@Value("#{esignProperties['usesPfa']}") 
	public boolean usesPfa;
	
	@Value("#{esignProperties['usesPin']}") 
	public boolean usesPin;
	
	@Value("#{esignProperties['usesOtp']}") 
	public boolean usesOtp;
	
	@Value("#{esignProperties['usesBio']}") 
	public boolean usesBio;
	
	@Value("#{esignProperties['usesBioFMR']}") 
	public boolean usesBioFMR;
	
	 @Value("#{esignProperties['usesBioFIR']}") 
	 public boolean usesBioFIR;
	 
	@Value("#{esignProperties['usesBioIIR']}") 
	public boolean usesBioIIR;
	
	@Value("#{esignProperties['signatureAlias']}") 
	public String signatureAlias;
	
	@Value("#{esignProperties['signaturePassword']}") 
	public String signaturePassword;
	
	@Value("#{esignProperties['udc']}") 
	public String udc;
	
	@Value("#{esignProperties['fdc']}") 
	public String fdc;
	
	@Value("#{esignProperties['idc']}") 
	public String idc;
	
	@Value("#{esignProperties['pincode']}") 
	public String pincode;
	
	@Value("#{esignProperties['lot']}") 
	public String lot;
	
	@Value("#{esignProperties['lov']}") 
	public String lov;
	
	@Value("#{esignProperties['publicIP']}") 
	public String publicIP;
	
	@Value("#{esignProperties['useSSK']}") 
	public String useSSK;
	
	@Value("#{esignProperties['pidType']}") 
	public String pidType;
	
	@Value("#{esignProperties['logPath']}") 
	public String logPath;
	
	@Value("#{esignProperties['PROXY_IP']}") 
	public String proxyIP;
	
	@Value("#{esignProperties['PROXY_HOST']}") 
	public String proxyHost;
	
	@Value("#{esignProperties['PROXY_PORT']}") 
	public String proxyPort;
	
	@Value("#{esignProperties['PROXY_PORT_NUM']}") 
	public String proxyPortNum;

	@Value("#{esignProperties['asaUrl']}") 
	public String asaUrl;  
	
	@Value("#{esignProperties['licenseFilePath']}") 
	public String licenseFilePath;	
	
	@Value("#{esignProperties['licenseUrl']}") 
	public String licenseUrl;
	 
	  
	 @Value("#{esignProperties['useToken']}") 
	 public  boolean useToken;
	 
	 @Value("#{esignProperties['printAlias']}") 
	 public boolean printAlias;
	 
	 @Value("#{esignProperties['tokenConfig']}") 
	 public String tokenConfig;
	 
	 @Value("#{esignProperties['tokenPassword']}") 
	 public String tokenPassword;
	 
	 @Value("#{esignProperties['tokenPrivateKeyAlias']}") 
	 public String tokenPrivateKeyAlias;
	 
	 @Value("#{esignProperties['tokenPublickeyAlias']}") 
	 public String tokenPublickeyAlias;
	  
	 @Value("#{esignProperties['protocol']}") 
	 public String protocol;
	 
	 @Value("#{esignProperties['useJava']}") 
	 public String useJava;
	
	 
	
	 
	 
	 
	 
	

}