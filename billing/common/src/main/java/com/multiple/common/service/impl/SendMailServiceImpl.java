package com.multiple.common.service.impl;

import java.util.Iterator;
import java.util.Map;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSendException;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.multiple.common.model.mail.EmailData;
import com.multiple.common.service.SendMailService;

@Service
public class SendMailServiceImpl implements SendMailService {
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@Autowired
	private VelocityEngine velocityEngine;
	
	private final Log logger = LogFactory.getLog(getClass());
	
	@Async
	public void sendMail(final EmailData emailData) {
		 try{
			logger.info("Send Mail ");
		MimeMessagePreparator preparator = new MimeMessagePreparator() {
            public void prepare(MimeMessage mimeMessage) throws Exception {
               MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
               logger.info("To Mail : "+ emailData.getTo());
              
               if(emailData.getTo() != null && emailData.getTo().indexOf(",")>0)
               {
            	   String[] emailIds = emailData.getTo().split(",");
            	   for(int i=0;i<emailIds.length;i++)
            	   {
            		   logger.info("Emails Ids to : " + emailIds[i]);
            		   message.addTo(emailIds[i]);
            	   }
            	   
               }else{
            	   message.setTo(emailData.getTo());
               }
               
               if(emailData.getBcc() != null)
               {
            	   if(emailData.getBcc() != null && emailData.getBcc().indexOf(",")>0)
            	   {
            		   String[] emailIds =emailData.getBcc().split(",");
            		   for(int i=0;i<emailIds.length;i++)
            		   {
            			   logger.info("Emails Ids BCC: " + emailIds[i]);
            			   message.addBcc(emailIds[i]);
            		   }

            	   }else{
            		   message.setBcc(emailData.getBcc());
            	   }
               }
               
               if(emailData.getCc()!= null){
            	   if(emailData.getCc() != null && emailData.getCc().indexOf(",")>0)
            	   {
            		   String[] emailIds = emailData.getCc().split(",");
            		   for(int i=0;i<emailIds.length;i++)
            		   {
            			   logger.info("Emails Ids CC : " + emailIds[i]);
            			   message.addCc(emailIds[i]);
            		   }

            	   }else{
            		   message.setCc(emailData.getTo());
            	   }
               }
               
               if(emailData.getSubject() != null )
                    message.setSubject(emailData.getSubject());
               
        
               message.setFrom(emailData.getFrom()!= null?emailData.getFrom():mailSender.getUsername()); 
               logger.info("To Mail : "+emailData.getTo());
               logger.info("Send Mail template : "+ emailData.getMailTemplate());
               String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, emailData.getMailTemplate(), "UTF-8",emailData.getModel());
               message.setText(text, true);
            }
         };
         
		 mailSender.send(preparator);		
		}catch (Exception exp) {
			// TODO: handle exception
			Address[] validUnsent=null;
			Address[] invalid =null;
			StringBuffer bcc= new StringBuffer("");
			StringBuffer messagetext = new StringBuffer("There are Invalid Mailids in ZTS.Please Correct them <br><br>");
			exp.printStackTrace();
			if(exp instanceof MailSendException) {
				MailSendException mex = (MailSendException) exp;				
				Map mapex = mex.getFailedMessages();
				Iterator exitr = mapex.keySet().iterator() ;
				int count = 0;
				while(exitr.hasNext())
				{		
					++count;
					Exception ex = (Exception) mapex.get(exitr.next());	
					  do {
						 if (ex instanceof SendFailedException) {
							 System.out.println("Exception Is of Type SendFailedException");
					          SendFailedException sfex = (SendFailedException) ex;
					          invalid = sfex.getInvalidAddresses();
					          if (invalid != null) {
					            System.out.println("    ** Invalid Addresses");		          
					              for (int i = 0; i < invalid.length; i++)
					              {
					                System.out.println("         " + invalid[i]);
					                messagetext.append(invalid[i]+"<br>");
					              }
					          }
					          validUnsent = sfex.getValidUnsentAddresses();
					          if (validUnsent != null) {
					            System.out.println("    ** ValidUnsent Addresses");		           
					              for (int i = 0; i < validUnsent.length; i++)
					              {
					                System.out.println("         " + validUnsent[i]);
					                bcc.append(validUnsent[i]+",");				                
					              }
					          }
					          Address[] validSent = sfex.getValidSentAddresses();
					          if (validSent != null) {
					            System.out.println("    ** ValidSent Addresses");		            
					              for (int i = 0; i < validSent.length; i++)					              
					                System.out.println("         " + validSent[i]);		            
					          }				      
						 }		
							if (validUnsent != null) {
								System.out.println("Sending Mail Again .........");
								  this.sendMail(emailData);
							}	
							if(count>3){
								ex = null;
							}
					 System.out.println();	
				 	 if (ex instanceof MessagingException)
				          ex = ((MessagingException) ex).getNextException();
				        else
				          ex = null;
				      } while (ex != null);
				    
				}    //End of while 		        
			} // End of if
		
		}
		
	}
	
}
