package com.dranoj.api.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;

import com.dranoj.api.dto.payload.MailRequest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Email", description = "Endpoint that will be use for sending email")
public interface IEmailController {

	@Operation(summary = "Send Simple Email")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200",
				description = "OK",
				content = {@Content(examples = {@ExampleObject(value = "{\"message\":\"Email Sent\"}")})}),
			@ApiResponse(responseCode = "500",
				description = "Error",
				content = {@Content(examples = {@ExampleObject(value = "{\"Error\":\"Error message\"}")})})
	})
	public ResponseEntity<Map<String, String>> sendSimpleEmail(
			@RequestBody(content = 
				@Content(examples = 
					@ExampleObject(value = "{\"to\":[\"baysajonnard@gmail.com\"], \"cc\":[], \"bcc\":[], \"subject\":\"subject\", \"body\":\"body\"}"))) 
			MailRequest mail);
}
