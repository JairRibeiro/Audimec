/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servelts;

import Classes.Email;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author Camilo
 */
@WebServlet("/EnviarEmail")
public class EmailServlet extends HttpServlet{
    
   @Override
   public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
       
        response.sendRedirect("/Audimec/index.html");
   }
   
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
   {
       
       String nome =  request.getParameter("nome");
       String emailUsuario = request.getParameter("email");
       String mensagem = request.getParameter("mensagem");
       
       System.err.println(nome);
       
       Email email = new Email();
       email.setNome(nome);
       email.setEmail(emailUsuario);
       email.setMensagem(mensagem);

         final String username = "sac@doctoralliance.com.br";
		final String password = "doc@56bC862";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.doctoralliance.com.br");
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
			message.setFrom(new InternetAddress("SAC - Doctor Alliance <sac@doctoralliance.com.br>"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("vital_junior_@hotmail.com"));
			message.setSubject("Redefinição de senha");
                        
                        String emailBody = "<p>Olá!<br>\n"
                + "<br>\n"
                + "Uma solicitação de nova senha foi recebida.<br>\n"
                + "<br>\n"
                + "Para a sua segurança, é importante confirmar este pedido antes de receber a nova senha.<br>\n"
                + "<br>\n"
                + "Para confirmar o envio de uma nova senha, clique aqui: <br><br>\n"
                                //URL PARA USO NO PROJETO LOCALHOST
                //+ "<span style=\"line-height:1.6em\">http://localhost:8080/DoctorAlliance/recuperarsenhacodigo?token=" + codigotoken + "<br><br></span>"
                                //URL PARA USO NO PROJETO WEB
//                + "<span style=\"line-height:1.6em\">http://www.doctoralliance.com.br/DoctorAlliance/recuperarsenhacodigo?token=" + codigotoken + "<br><br></span>"                
                + "<br>\n"
                + "</p>"
                + "<p>Sempre que precisar de ajuda, entre em contato com nosso suporte através do email sac@doctoralliance.com.br.<br>\n"
                + "<br><br>\n"
                + "Atenciosamente<br><br>\n"
                + "Doctor Alliance.&nbsp;<br><br>\n"
                + "<a href=\"http://www.doctoralliance.com.br\" target=\"_blank\"><u>www.doctoralliance.com.br</u></a></p>";
                        
			
                        message.setContent(emailBody, "text/html");
                        

			Transport.send(message);

			//System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
    
       
   }
   
}
