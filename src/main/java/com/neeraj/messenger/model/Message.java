package com.neeraj.messenger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

// The @XmlRootElement annotation maps a class to an XML element. 
// At least one element definition is needed for each top-level Java type used for unmarshalling and marshalling. 
// If there is no element definition, there is no starting location for XML content processing.
@XmlRootElement
public class Message {
	private long id;
	private String message;
	private Date created;
	private String author;
	
	public Message() {
		
	}
	
	public Message(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.created = new Date();
		this.author = author;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
}
