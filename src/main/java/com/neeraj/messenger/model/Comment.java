package com.neeraj.messenger.model;

import java.util.Date;

public class Comment {
	private long id;
	private String content;
	private Date created;
	private String author;
	
	public Comment() {
		
	}
	
	public Comment(long id, String content, String author) {
		this.id = id;
		this.content = content;
		this.created = new Date();
		this.author = author;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
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
