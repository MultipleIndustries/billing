package com.multiple.common.util;

public abstract class SMSService {
	public abstract boolean send(long mobile, String message) throws Exception ;
}
