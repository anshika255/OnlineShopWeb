package com.lti.repo;

import java.util.List;

import com.lti.entity.Orders;
import com.lti.entity.User;
import com.lti.pojo.Login;
import com.lti.entity.Product;


public interface UserRepo {
	
    void save(User user);
	
	User fetch(int userid);
	
	User update(User user);
	
	User authenticate(Login login);
	
	void save(Orders order,int userid,int productid);
	
	List<Orders> displayOrderForUser(int userid);
	
    List<Product> forParticularCart(int userId);
    
    List<Product> forParticularWishlist(int userId);
}
