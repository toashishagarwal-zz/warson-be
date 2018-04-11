package com.warson.warsonbe.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warson.warsonbe.models.User;
import com.warson.warsonbe.repositories.UserRepository;

@Service
public class UserService {

	@Autowired private UserRepository userRepo;
	
	public String getUsers() {
		List<String> users = new ArrayList<String>();
		users.add("Adil");
		users.add("Reva");
		users.add("Champa");
		users.add("Chameli");
		users.add("Kareena");
		users.add("Buddha");
		
		int randomIndex = ThreadLocalRandom.current().nextInt(0, users.size());
		return users.get(randomIndex);
	}

	public void createUser(User u) {
		userRepo.save(u);
	}

}
