package com.multiple.common.util;

import com.multiple.kernel.exception.ExceptionLog;
//import  com.astrika.kernel.exception.ExceptionLog;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class TwoWaySMS extends SMSService {
	
	@Override
	public boolean send(long mobile, String message) throws Exception {
		
		//http://59.162.167.52/api/MessageCompose?admin=dsouzaronald@gmail.com&user=info@apostoliccarmelbandra.com:V4V4H9V8D&senderID=ACHSJC&receipientno=9833306713&msgtxt=hello&state=4
		
		//Dear XXXX . Thank you for registering on XXXX Mobile App. Please enter password XXXX on the login screen
		//Dear Ronald You are registered on Carmel Mobile App. Enter password 947254 for login and save for future use.
		String methodMetadata = "TwoWaySMS.send";
		
		message = message.replace(" ", "%20");
		String admin = "dsouzaronald@gmail.com";
		String user = "binaifer@avmschools.ac.in:H3C7J8M4";
		String senderId = "AVMSCH";
		
		
		boolean isSent = false;
		Client client = null;

		try {
			String serviceUrl = "http://59.162.167.52/api/MessageCompose?admin="
			+admin
			+"&user="
			+user
			+"&senderID="
			+ senderId 
			+"&receipientno="
			+ mobile
			+"&msgtxt="
			+message
			+"&state=4";

			/* TODO - @jugalpanchal If Service Url has space then that must be replace. */
			// String encodedString = URLEncoder.encode(serviceUrl, "UTF-8");
			// URI uri = new URI(serviceUrl);
			System.out.println("Seding Message:******************************************************************************************");
				
			System.out.println(serviceUrl);
			
			client = Client.create();
			WebResource webResource = client.resource(serviceUrl);
			ClientResponse response = webResource.get(ClientResponse.class);
			System.out.println(response.getStatus());
			if (response.getStatus() != 200) {
				ExceptionLog.println(methodMetadata, response.getStatus());
			}
			else
			{
				isSent = true;
			}
		} catch (Exception ex) {
//			ExceptionLog.println(methodMetadata, ex);
			throw ex;
		} finally {
			/*
			 * TODO : @jugalpanchal - If client is open then destroy or
			 * close.
			 */
			// client.destroy();
		}
		return isSent;
	}

}