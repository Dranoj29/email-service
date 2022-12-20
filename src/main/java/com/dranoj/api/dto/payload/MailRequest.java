package com.dranoj.api.dto.payload;

import java.util.List;

import javax.validation.constraints.NotEmpty;

public class MailRequest {
 
	@NotEmpty(message = "param 'To' cannot be empty")
	private List<String> to;
	private List<String> cc;
	private List<String> bcc;
	private String subject;
	private String body;
	/**
	 * @return the to
	 */
	public List<String> getTo() {
		return to;
	}
	/**
	 * @param to the to to set
	 */
	public void setTo(List<String> to) {
		this.to = to;
	}
	/**
	 * @return the cc
	 */
	public List<String> getCc() {
		return cc;
	}
	/**
	 * @param cc the cc to set
	 */
	public void setCc(List<String> cc) {
		this.cc = cc;
	}
	/**
	 * @return the bcc
	 */
	public List<String> getBcc() {
		return bcc;
	}
	/**
	 * @param bcc the bcc to set
	 */
	public void setBcc(List<String> bcc) {
		this.bcc = bcc;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the body
	 */
	public String getBody() {
		return body;
	}
	/**
	 * @param body the body to set
	 */
	public void setBody(String body) {
		this.body = body;
	}
	
	
}
