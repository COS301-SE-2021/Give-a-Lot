package com.GiveaLot.givealot;

import com.GiveaLot.givealot.Notification.dataclass.Mail;
import com.GiveaLot.givealot.Notification.service.SendMailServiceImpl;
import com.GiveaLot.givealot.Organisation.model.Organisations;
import com.GiveaLot.givealot.Organisation.service.OrganisationServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;
import java.io.IOException;

@SpringBootApplication
public class GivealotApplication implements CommandLineRunner{


	@Autowired
	private SendMailServiceImpl sendMailService;

	public static void main(String[] args) {
		SpringApplication.run(GivealotApplication.class, args);
	}

	@Override
	public void run(String... args) {

		System.out.println("Sending Email...");

		Mail mail = new Mail("futuremoroke@gmail.com","testing","test");
		sendMailService.sendMail(mail);
	;
		System.out.println("Done");

	}




}
