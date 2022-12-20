package com.dranoj.api.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.dranoj.api.dto.payload.MailRequest;
import com.dranoj.api.service.IEmailService;

@Service
public class EmailServiceImpl implements IEmailService{
	
	@Autowired
	private MailSender mailSender;
	
	@Value("{spring.mail.username}")
	private String from;


	@Override
	public Map<String, String> sendSimpleEmail(MailRequest mail){
		
		Map<String, String> response = new HashMap<>();
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(this.from);
		message.setTo(mail.getTo().toArray(new String[mail.getTo().size()]));
		if(!mail.getCc().isEmpty())
			message.setCc(mail.getCc().toArray(new String[mail.getCc().size()]));
		if(!mail.getBcc().isEmpty())
			message.setBcc(mail.getBcc().toArray(new String[mail.getBcc().size()]));
		message.setSubject(mail.getSubject());
		message.setText(mail.getBody());
		
		try {
            this.mailSender.send(message);
            response.put("message", "Email Sent");
        }catch (MailException e) {
            System.err.println(e.getMessage());
            response.put("error", e.getMessage());
        }
		
		return response;
	}
}
