package com.dranoj.api.service;

import java.util.Map;

import com.dranoj.api.dto.payload.MailRequest;

public interface IEmailService {

	Map<String, String> sendSimpleEmail(MailRequest mail);
	
}
