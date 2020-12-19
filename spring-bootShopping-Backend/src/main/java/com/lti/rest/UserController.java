package com.lti.rest;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Orders;
import com.lti.entity.Product;
import com.lti.entity.User;
import com.lti.pojo.Login;
import com.lti.service.UserService;
import com.lti.pojo.Order;
import com.lti.pojo.ProductDto;

@CrossOrigin
@RestController
public class UserController {

	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private UserService service;
	
	@PersistenceContext
	private EntityManager em;
	
	
	@PostMapping(value="/addUser",consumes="application/json")
	public String addUser(@RequestBody User usr) {
		service.addUser(usr);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("aryaanshika51@gmail.com");
		message.setTo(usr.getEmail());
		message.setSubject("Thank You for registration");
		message.setText("Thank you "+usr.getUsername()+" for registering on Zephyr.com Keep Exploring for more products");
		mailSender.send(message);
		return "User added successfully";
	}

	@GetMapping(value = "/fetchuser/{id}", produces = "application/json")
	public User fetchUser(@PathVariable int id) {
		return service.findUser(id);
	}
	
	@PutMapping(value = "/updateuser", consumes = "application/json")
	public String editUser(@RequestBody User usr) {
		service.updateUser(usr);
		return "User updated successfully";
	}
	
	@GetMapping(value = "/login", produces = "application/json")
	public User login(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		
		Login login = new Login(username, password);
		User user = service.validate(login);
		System.out.println(user.getUsername() + "\t" + user.getPassword());
		return user;
	}
	
	
	@PostMapping(value="/addOrder/{userid}/{productid}",consumes="application/json")
	public String addOrder(@RequestBody Orders ordr ,@PathVariable int userid,@PathVariable int productid) {
		service.save(ordr,userid,productid);
		
		User usr=em.find(User.class, userid);
		Product prdct=em.find(Product.class, productid);
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("aryaanshika51@gmail.com");
		message.setTo(usr.getEmail());
		System.out.println(usr.getEmail());
		message.setSubject("Thank You for Placing Order");
		message.setText("Thank you "+usr.getUsername()+" for Placing Order for Product "+prdct.getName()+" on Zephyr.com Keep Exploring for more products");
		mailSender.send(message);
		
		SimpleMailMessage message1 = new SimpleMailMessage();
		message1.setFrom("aryaanshika51@gmail.com");
		message1.setTo(prdct.getRetailer().getEmail());
		System.out.println(prdct.getRetailer().getEmail());
		message1.setSubject("Congratulations On getting new order");
		message1.setText("Congratualtions! "+prdct.getRetailer().getRetailername()+" on getting a new order for Product "+prdct.getName()+" having ProductID "+prdct.getProductid()+" on Zephyr.com. Keep Adding new products");
		mailSender.send(message1);
		
		
		
		return "Order Placed successfully";
	}
	
	@GetMapping("/viewOrders/{userid}")
	public List<Order> viewAllOrders(@PathVariable("userid") int userid){
		List<Orders> orders = service.displayOrderOfUser(userid);
		List<Order> rs = new ArrayList<>();
		for(Orders o: orders) {
			Order od= new Order();
			od.setId(o.getOrderid());
			od.setProductid(o.getProduct());	
			rs.add(od);
		}
		return rs;
	}
	
	@GetMapping("/viewCart/{userid}")
	public List<ProductDto> viewAllitemsinCart(@PathVariable("userid") int userid){
		List<Product> products = service.fetchCart(userid);
		List<ProductDto> rs = new ArrayList<>();
		for(Product p: products) {
			ProductDto pd= new ProductDto();
			pd.setName(p.getName());
		    pd.setPrice(p.getPrice());
		    pd.setProductId(p.getProductid());
		    pd.setImageid(p.getImageid());
			rs.add(pd);
		}
		return rs;
	}
	
	@GetMapping("/viewWishlist/{userid}")
	public List<ProductDto> viewAllitemsinWishlist(@PathVariable("userid") int userid){
		List<Product> products = service.fetchWishlist(userid);
		List<ProductDto> rs = new ArrayList<>();
		for(Product p: products) {
			ProductDto pd= new ProductDto();
			pd.setName(p.getName());
		    pd.setPrice(p.getPrice());
		    pd.setProductId(p.getProductid());
		    pd.setImageid(p.getImageid());
			rs.add(pd);
		}
		return rs;
	}

}
