package com.warson.warsonbe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.warson.warsonbe.models.User;
import com.warson.warsonbe.models.Wish;
import com.warson.warsonbe.repositories.UserRepository;
import com.warson.warsonbe.repositories.WishesRepository;

@Service
public class WishesService {

	@Autowired private WishesRepository wishesRepo;
	@Autowired private UserRepository userRepo;
	
	public List<Wish> getWishesByStatus(Integer statusId) {
		return wishesRepo.findByStatusId(statusId);
	}

	public void createWish(Wish w, Long userId) {
		User user = userRepo.findByUserId(userId);
		w.setUser(user);
		wishesRepo.save(w);
	}
}
