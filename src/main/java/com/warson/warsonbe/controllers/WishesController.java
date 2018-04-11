package com.warson.warsonbe.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.warson.warsonbe.models.Wish;
import com.warson.warsonbe.services.WishesService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:3000")
public class WishesController {
	@Autowired private WishesService service;

	@GetMapping("/wishes/{statusId}")
	public List<Wish> getWishes(@PathVariable Integer statusId) {
		return service.getWishesByStatus(statusId);
	}

	@PostMapping("/wishes/{userId}/add")
	public void createWish(@RequestBody Wish w, @PathVariable Long userId) {
		service.createWish(w, userId);
	}
}
