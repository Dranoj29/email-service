package com.dranoj.api.controller.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dranoj.api.controller.IEmailController;
import com.dranoj.api.dto.payload.MailRequest;
import com.dranoj.api.service.IEmailService;

@RestController
public class EmailController implements IEmailController{
	
	@Autowired
	private IEmailService emailService;

	@PostMapping(value = "/send-simple-mail")
	public ResponseEntity<Map<String, String>> sendSimpleEmail(@RequestBody MailRequest mail){
		
		Map<String, String> response = this.emailService.sendSimpleEmail(mail);
		
		if(response.containsKey("message")) {
			return ResponseEntity.ok(response);
		}
		
		return ResponseEntity.status(500).body(response);
	}
}
