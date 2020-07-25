package com.neeraj.messenger.database;

import java.util.HashMap;
import java.util.Map;

import com.neeraj.messenger.model.Message;
import com.neeraj.messenger.model.Profile;

public class DatabaseClass {
	
	private static Map<Long, Message> messages = new HashMap<>();

	private static Map<String, Profile> profiles = new HashMap<>();
	
	static {
		messages.put(1L, new Message(1, "Hello World!", "njgarg22"));
		messages.put(2L, new Message(2, "Hello Jersey", "njgarg22"));
		
		profiles.put("njgarg22", new Profile(1L, "njgarg22", "Neeraj", "Garg"));
	}
	
	public static Map<Long, Message> getMessages(){
		return messages;
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}	
}
