package com.neeraj.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.neeraj.messenger.database.DatabaseClass;
import com.neeraj.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Message> getAllMessages(){
		// Passing the collection directly to the ArrayList constructor to initialize the list with those elements 
		return new ArrayList<>(messages.values());
	}
	
	public Message getMessage(long id) {
		return messages.get(id);
	}
	
	public Message addMessage(Message message) {
		message.setId(messages.size() + 1);
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message updateMessage(Message message) {
		if(message.getId() <= 0) {
			return null;
		}
		messages.put(message.getId(), message);
		return message;
	}
	
	public Message removeMessage(long id) {
		return messages.remove(id);
	}
}
