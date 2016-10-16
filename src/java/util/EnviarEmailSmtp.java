/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import Classes.Email;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author alexsandro
 */
public class EnviarEmailSmtp {
    
    
    public static void generateAndSendEmail(Email email) throws AddressException, MessagingException {
    
                final String username = email.getEmail();
		final String password = "doc@56bC862";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
                        @Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("<"+email.getEmail()+">"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("vital_junior_@hotmail.com"));
			message.setSubject("Redefinição de senha");
                        
                        String emailBody = "<p>Olá Audimec,</p>"
                                + "<br>\n";
                                
//                                "<p>Olá!<br>\n"
//                + "<br>\n"
//                + "Uma solicitação de nova senha foi recebida.<br>\n"
//                + "<br>\n"
//                + "Para a sua segurança, é importante confirmar este pedido antes de receber a nova senha.<br>\n"
//                + "<br>\n";
//                + "Para confirmar o envio de uma nova senha, clique aqui: <br><br>\n"
     
               
//                + "<span style=\"line-height:1.6em\">http://www.doctoralliance.com.br/DoctorAlliance/recuperarsenhacodigo?token=" + codigotoken + "<br><br></span>"                
//                + "<br>\n"
//                + "</p>"
//                + "<p>Sempre que precisar de ajuda, entre em contato com nosso suporte através do email sac@doctoralliance.com.br.<br>\n"
//                + "<br><br>\n"
//                + "Atenciosamente<br><br>\n"
//                + "Doctor Alliance.&nbsp;<br><br>\n"
//                + "<a href=\"http://www.doctoralliance.com.br\" target=\"_blank\"><u>www.doctoralliance.com.br</u></a></p>";
                        
			
                        message.setContent(emailBody, "text/html");
                        

			Transport.send(message);

			//System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
    
    
    
    }
    
    
    		
}
