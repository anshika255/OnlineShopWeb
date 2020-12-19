package com.lti.service;

import java.util.List;

import com.lti.entity.Orders;
import com.lti.entity.User;
import com.lti.pojo.Login;
import com.lti.entity.Product;


public interface UserService {
	
    void addUser(User user);
	
	User findUser(int userid);
	
	User updateUser(User user);
	
	User validate(Login login);
	
	void save(Orders order,int userid,int productid);
	
	List<Orders> displayOrderOfUser(int userid);
	
    List<Product> fetchCart(int userId);
    
    List<Product> fetchWishlist(int userId);
}
