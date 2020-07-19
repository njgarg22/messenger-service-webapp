package com.neeraj.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.neeraj.messenger.database.DatabaseClass;
import com.neeraj.messenger.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();

	public ProfileService() {
	}
	
	public List<Profile> getAllProfiles(){
		// Passing the collection directly to the ArrayList constructor to initialize the list with those elements 
		return new ArrayList<>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
