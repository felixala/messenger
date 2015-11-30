package com.felixlaura.messenger.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.felixlaura.messenger.database.DatabaseClass;
import com.felixlaura.messenger.model.Profile;

public class ProfileService {
	
	private Map<String, Profile> profiles = DatabaseClass.getProfiles();
	
	public ProfileService() {
	
		profiles.put("gatocat", new Profile(1L, "gatocat", "Felix", "Laura"));
		profiles.put("marly", new Profile(2L, "marly", "Marly", "Chavez"));
		profiles.put("nico", new Profile(3L, "nico", "Nicolas", "Laura"));
		profiles.put("maca", new Profile(4L, "maca", "Macarena", "Laura"));
		
	}
	
	public List<Profile> getAllProfileByLastName(String lastName){
		List<Profile> profileByLastName = new ArrayList<>();
		for(Profile profile:profiles.values()){
			if(profile.getLastName().equals(lastName)){
				profileByLastName.add(profile);
			}
		}
		return profileByLastName;
	}

	public List<Profile> getAllProfile(){
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName){
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile){
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile updateProfile(Profile profile){
		if(profile.getProfileName().isEmpty()){
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName){
		return profiles.remove(profileName);
	}

}
