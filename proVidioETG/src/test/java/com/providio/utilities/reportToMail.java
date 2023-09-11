package com.providio.utilities;

import java.net.UnknownHostException;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.mail.EmailException;

public class reportToMail {
	
	public static void Reporttomail() throws EmailException, UnknownHostException {

	    System.out.println("Email is starting to send");
	    final String username = "akhireddy9642@gmail.com";
	    final String password = "cwsclswzktrlwiol";
	    String smtpHost = "smtp.gmail.com";
	    int smtpPort = 587;
	    
	    //normal mail
	    
	    //upendrareddy1212@gmail.com
	    //hqpolukazazrvlbi
	    //smtp.gmail.com
	    
	    //pro
	    //upendra.y@etg.digital
	    //Xog32763
	    //smtp.office365.com
	    
	    String reportFilePath = "C:\\Users\\user\\git\\RunGuestTestSuite\\proVidioETG\\Reports\\ProvidioTestReport.html";
        String subject1 = "Automation Test Report of Provido Project Report";
        String body1 = "Please find the attached Automation Test Report of Provido Project.";

	    String reportScreenshot = "C:\\Users\\user\\git\\RunGuestTestSuite\\proVidioETG\\Reports\\ReportsScreenshot.png";
	    String subject2 = "And Screenshot";
	    String body2 = "Please find the attached screenshot Automation Test Report of Provido Project";

	   //String[] recipients = { "etgdigital123@gmail.com", "upendrareddy1212@gmail.com","krishnarjun.c@etg.digital","shankar.challa@etg.digital", "akhila.v@etg.digital","pushpa.s@etg.digital","bhavya.a@etg.digital","bhaskarrao.s@etg.digital","niveditha.d@etg.digital","salma.s@etg.digital","f8eecde2.etggs.com@apac.teams.ms","akhila.m@etg.digital"};
	   String[] recipients = { "akhireddy9642@gmail.com","akhila.m@etg.digital"};
	    //

	    sendEmail(username, password, smtpHost, smtpPort, recipients,subject1, body1, reportFilePath, reportScreenshot, body2, subject2);

	    System.out.println("Email sent successfully.");
	}

	private static void sendEmail(final String username, final String password, String smtpHost, int smtpPort, String[] recipients,
            String subject1, String body1, String reportFilePath,String reportScreenshot, String body2,String subject2) {
		

	    Properties props = new Properties();
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.host", smtpHost);
	    props.put("mail.smtp.port", smtpPort);
	    props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	    props.put("mail.smtp.debug", "true");

	    Session session = Session.getInstance(props, new Authenticator() {
	        protected PasswordAuthentication getPasswordAuthentication() {
	            return new PasswordAuthentication(username, password);
	        }
	    });

	    try {
	        Message message = new MimeMessage(session);
	        message.setFrom(new InternetAddress(username));

	        InternetAddress[] recipientAddresses = new InternetAddress[recipients.length];
	        for (int i = 0; i < recipients.length; i++) {
	            recipientAddresses[i] = new InternetAddress(recipients[i]);
	        }
	        message.setRecipients(Message.RecipientType.TO, recipientAddresses);
	        
	        message.setSubject(subject1);
	        message.setSubject(subject2);
	        
	     // Create the message part for the body
            BodyPart messageBodyPart1 = new MimeBodyPart();
            messageBodyPart1.setText(body1);
            
	        BodyPart messageBodyPart2 = new MimeBodyPart();
	        messageBodyPart2.setText(body2);
            
         // Create the message part for the attachment
            MimeBodyPart attachmentPart1 = new MimeBodyPart();
            attachmentPart1.attachFile(reportFilePath);

	        MimeBodyPart attachmentPart2 = new MimeBodyPart();
	        attachmentPart2.attachFile(reportScreenshot);

	        // Create a multipart message and set its parts
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messageBodyPart1);
            multipart.addBodyPart(messageBodyPart2);
		    multipart.addBodyPart(attachmentPart1);
		    multipart.addBodyPart(attachmentPart2);

		    // Set the multipart message as the content of the email
		    message.setContent(multipart);
		    message.setSubject(subject1 + " and " + subject2);
		    // Send the email
		    Transport.send(message);

		    System.out.println("Extent report sent successfully.");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}


}

