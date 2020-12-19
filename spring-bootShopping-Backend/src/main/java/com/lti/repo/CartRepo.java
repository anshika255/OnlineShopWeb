package com.lti.repo;
import java.util.List;

import com.lti.entity.Cart;
import com.lti.entity.Product;
import com.lti.entity.Retailer;
import com.lti.entity.User;

public interface CartRepo {

	
//	Product add(int productid);
	
	
    void save(Cart cart,int userid,int productid);
	
	Cart fetch(int cartid);
	
	Cart update(Cart cart);	
	
//	List<Product> fetchAllProducts(int productid);
}
