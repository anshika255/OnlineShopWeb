package com.lti.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Cart;
import com.lti.repo.CartRepo;

@RestController
public class CartController {
	
	@Autowired
	private CartRepo repo;
	
	@PostMapping(value="/addcart",consumes="application/json")
	public String addCart(@RequestBody Cart crt) {
		repo.save(crt,51001,4005);
		return "Items added successfully";
	}
	
	@PutMapping(value = "/updatecart", consumes = "application/json")
	public String editCart(@RequestBody Cart crt) {
		repo.update(crt);
		return "Cart updated successfully";
	}
	
	@GetMapping("/fetchcart/{cartid}")
	public String fetchCart(@PathVariable int cartid) {
		repo.fetch(cartid);
		return "Cart Fetched successfully";
	}

}
