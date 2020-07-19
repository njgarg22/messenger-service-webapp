package com.neeraj.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.neeraj.messenger.model.Message;
import com.neeraj.messenger.model.Profile;

public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap<>();

	private static Map<Long, Profile> profiles = new HashMap<>();
	
	static {
		messages.put(1L, new Message(1, "Hello World!", "Neeraj"));
		messages.put(2L, new Message(2, "Hello Jersey", "Neeraj"));
	}
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<Long, Profile> getProfiles(){
		return profiles;
	}	
}
