package com.lti.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Orders;
import com.lti.entity.Retailer;
import com.lti.repo.OrderRepo;

@RestController
public class OrderController {

	@Autowired
	private OrderRepo repo;
	
//	@PostMapping(value="/addOrder/{userid}/{productid}",consumes="application/json")
//	public String addOrder(@RequestBody Orders ordr ,@PathVariable int userid,@PathVariable int productid) {
//		repo.save(ordr,userid,productid);
//		return "Order added successfully";
//	}
	
	
	@GetMapping(value = "/fetchOrder/{id}", produces = "application/json")
	public Orders fetchOrders(@PathVariable int id) {
		return repo.fetch(id);
	}
}
