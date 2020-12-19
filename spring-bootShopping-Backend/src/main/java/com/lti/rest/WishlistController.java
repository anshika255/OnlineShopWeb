package com.lti.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Wishlist;
import com.lti.repo.WishlistRepo;

@RestController
public class WishlistController {
	
	@Autowired
	private WishlistRepo repo;
	
	@PostMapping(value="/addwishlist",consumes="application/json")
	public String addWishlist(@RequestBody Wishlist wslst) {
		repo.save(wslst);
		return "Items added successfully";
	}
	
	@PutMapping(value = "/updatewishlist", consumes = "application/json")
	public String editWishlist(@RequestBody Wishlist wslst) {
		repo.update(wslst);
		return "Wishlist updated successfully";
	}
	
	@GetMapping("/fetchwishlist/{wishlistid}")
	public String fetchWishlist(@PathVariable int wishlistid) {
		repo.fetch(wishlistid);
		return "Wishlist Fetched successfully";
	}
	

}
