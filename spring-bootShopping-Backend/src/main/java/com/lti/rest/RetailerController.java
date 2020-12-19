package com.lti.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.lti.entity.Retailer;
import com.lti.pojo.ProductDto;
import com.lti.pojo.RetailerLoginDto;
import com.lti.service.RetailerService;
import com.lti.entity.Category;
import com.lti.entity.Product;

@CrossOrigin
@RestController
public class RetailerController {
	
	@Autowired
	private MailSender mailSender;
	
	@Autowired
	private RetailerService service;
	
	@PostMapping(value="/addretailer",consumes="application/json")
	public String addRetailer(@RequestBody Retailer rtlr) {
		service.addRetailer(rtlr);
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("aryaanshika51@gmail.com");
		message.setTo(rtlr.getEmail());
		message.setSubject("Thank You for registration");
		message.setText("Thank you "+rtlr.getRetailername()+" for registering on Zephyr.com Keep Adding for more products");
		mailSender.send(message);
		return "Retailer added successfully";
	}
	
	@GetMapping(value="/list",produces="application/json")
	public List<Retailer> listRetailer() {
		return service.fetchAllRetailer();
	}
	
	@GetMapping(value = "/fetch/{id}", produces = "application/json")
	public Retailer fetchRetailer(@PathVariable int id) {
		return service.find(id);
	}
	
	@PutMapping(value = "/updateretailer", consumes = "application/json")
	public String editRetailer(@RequestBody Retailer rtlr) {
		service.updateRetailer(rtlr);
		return "Retailer updated successfully";
	}
	
	@DeleteMapping("/delretailer/{retailerid}")
	public String delRetailer(@PathVariable int retailerid) {
		service.removeRetailer(retailerid);
		return "Retailer deleted successfully";
	}
	
	@GetMapping(value = "/loginRetailer", produces = "application/json")
	public Retailer login(@RequestParam("email") String email,
			@RequestParam("password") String password) {
		
		RetailerLoginDto login = new RetailerLoginDto(email, password);
		Retailer rtlr = service.validate(login);
		System.out.println(rtlr.getRetailername() + "\t" + rtlr.getPassword());
		return rtlr;
	}
	

	@GetMapping("/fetchCategory")
	public List<Category> fetchCategory(){
		return service.fetchAllCategories();
	}
	
	@GetMapping("/viewProducts/{retailerid}")
	public List<ProductDto> viewAllitems(@PathVariable("retailerid") int retailerid){
		List<Product> products = service.RetailersProducts(retailerid);
		List<ProductDto> rs = new ArrayList<>();
		for(Product p: products) {
			ProductDto pd= new ProductDto();
			pd.setProductId(p.getProductid());
			pd.setName(p.getName());
		    pd.setPrice(p.getPrice());
		    pd.setImageid(p.getImageid());
		    pd.setBrandName(p.getBrand());
		    pd.setCategoryId(p.getCategory().getCategoryid());
		    pd.setCategoryName(p.getCategory().getCategoryname());
		    pd.setDescription(p.getDescription());
		    pd.setQuantity(p.getQuantity());
			rs.add(pd);
		}
		return rs;
	}
	
}
