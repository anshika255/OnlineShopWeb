package com.lti.repo;

import java.util.List;

import com.lti.entity.Retailer;
import com.lti.entity.User;
import com.lti.pojo.Login;
import com.lti.pojo.RetailerLoginDto;
import com.lti.entity.Category;
import com.lti.entity.Product;

public interface RetailerRepo {

    void save(Retailer retailer);
	
	Retailer fetch(int retailerid);
	
	List<Retailer> fetchAll();
	
	void delete(int retailerid);
	
	void update(Retailer rtlr);
	
	//Retailer login(String email, String password);
	
	Retailer authenticate(RetailerLoginDto login);

	List<Category> fetchCategory();
	
	List<Product> forParticularRetailer(int retailerId);
	
}
