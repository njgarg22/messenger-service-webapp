package com.neeraj.messenger.service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import com.neeraj.messenger.database.DatabaseClass;
import com.neeraj.messenger.exception.DataNotFoundException;
import com.neeraj.messenger.model.Message;

public class MessageService {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	public List<Message> getAllMessages(){
		// Passing the collection directly to the ArrayList constructor to initialize the list with those elements 
		return new ArrayList<>(messages.values());
	}
	
	public List<Message> getAllMessagesForYear(int year){
		List<Message> messagesForYear = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		for(Message message: messages.values()) {
			cal.setTime(message.getCreated());
			if(cal.get(Calendar.YEAR) == year) {
				messagesForYear.add(message);
			}
		}
		return messagesForYear;
	}
	
	public List<Message> getAllMessagesPaginated(int start, int size){
		List<Message> list = new ArrayList<>(messages.values());
		if(start + size > list.size()) return new ArrayList<>();
		return list.subList(start, start + size);
	}
	
	public Message getMessage(long id) {
		Message msg = messages.get(id);
		if(msg == null) {
			throw new DataNotFoundException("Message with id " + id + " not found");
		}
		return msg;
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
