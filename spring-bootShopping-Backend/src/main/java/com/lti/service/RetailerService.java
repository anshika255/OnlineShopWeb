package com.lti.service;

import java.util.List;

import com.lti.entity.Retailer;
import com.lti.entity.User;
import com.lti.pojo.Login;
import com.lti.pojo.RetailerLoginDto;
import com.lti.entity.Category;
import com.lti.entity.Product;

public interface RetailerService {

    void addRetailer(Retailer retailer);
	
	Retailer find(int retailerid);
	
	List<Retailer> fetchAllRetailer();
	
	void removeRetailer(int retailerid);
	
	void updateRetailer(Retailer rtlr);
	
	
	Retailer validate(RetailerLoginDto login);

	List<Category> fetchAllCategories();
	
	List<Product> RetailersProducts(int retailerId);
	
}
