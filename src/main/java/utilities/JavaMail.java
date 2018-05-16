package utilities;

import java.io.IOException;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.HtmlEmail;

public class JavaMail {

	@SuppressWarnings("static-access")
	public static void mail() throws IOException {
		//public static void main(String args[]) {
		//GraphGenerator ob= new GraphGenerator("Databuddy Automation", "Test Summary");
		HtmlEmail email = new HtmlEmail();
		
		email.setHostName("smtp.office365.com");
		email.setSmtpPort(587);
		email.setAuthenticator(new DefaultAuthenticator("vaibhav.singh@u2opiamobile.com", "!mailst0rm"));
		email.setStartTLSEnabled(true);
		try {
			email.setFrom("vaibhav.singh@u2opiamobile.com");
			email.setSubject("Automation Report");
			email.setDebug(true);
			EmailStringBuilder m = new EmailStringBuilder();
			m.getEmailString();
			//email.setMsg(m.email.toString(), "text/html");
			email.setHtmlMsg(m.email.toString());
			email.addTo("vaibhav.singh@u2opiamobile.com");
			//email.addTo("ankur.singh@u2opiamobile.com");
			email.send();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
}
