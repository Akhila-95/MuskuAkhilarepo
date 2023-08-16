package com.providio.testcases;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Arrays;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.testng.TestNG;
import org.testng.annotations.Test;

public class newTest {
  @Test
  public static void main(String[] args) {
      // Monitor network availability and send notification if it is not available
      boolean isNetworkAvailable = checkNetworkAvailability();
      if (!isNetworkAvailable) {
          sendNotification("Network is not available. Test execution is delayed.");
      }

      // Wait for network availability
      while (!isNetworkAvailable) {
          try {
              Thread.sleep(5000); // Wait for 5 seconds before checking again
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          isNetworkAvailable = checkNetworkAvailability();
      }

      // Network is available, run the test suite
      TestNG testNG = new TestNG();
      testNG.setTestSuites(Arrays.asList("Excutingalltestcases.xml"));
      testNG.run();
  }

  private static boolean checkNetworkAvailability() {
      // Implement network availability check using a library or custom logic
      // Return true if network is available, false otherwise
	  
	  try {
          InetAddress.getByName("www.google.com").isReachable(1000); // Ping Google's server
          return true; // Network is available
      } catch (IOException e) {
          return false; // Network is not available
      }
  }

  private static void sendNotification(String message) {
      // Configure email settings
	   final String username = "upendrareddy1212@gmail.com";
       final String password = "hqpolukazazrvlbi";
       String smtpHost = "smtp.gmail.com";
       int smtpPort = 587;

      // Set properties for email server connection
       Properties props = new Properties();
       props.put("mail.smtp.auth", "true");
       props.put("mail.smtp.starttls.enable", "true");
       props.put("mail.smtp.host", smtpHost);
       props.put("mail.smtp.port", smtpPort);
       props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
       props.put("mail.smtp.debug", "true");

      // Create session and authenticate with email server
      Session session = Session.getInstance(props, new Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
              return new PasswordAuthentication(username, password);
          }
      });

      try {
          // Create email message
          Message emailMessage = new MimeMessage(session);
          emailMessage.setFrom(new InternetAddress(username));
          emailMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse("upendrareddy1212@gmail.com"));
          emailMessage.setSubject("Network Status Notification");
          emailMessage.setText(message);

          // Send email
          Transport.send(emailMessage);
          System.out.println("Notification email sent.");
      } catch (MessagingException e) {
          e.printStackTrace();
      }
  }
}
