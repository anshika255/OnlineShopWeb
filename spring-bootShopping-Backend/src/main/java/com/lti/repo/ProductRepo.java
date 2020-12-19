package com.lti.repo;

import java.util.List;

import com.lti.entity.Cart;
import com.lti.entity.Category;
import com.lti.entity.Product;
import com.lti.entity.User;
import com.lti.entity.Wishlist;

public interface ProductRepo {
	
	
    void save(Product product, int retailerid,int categoryid);
	
	Product fetch(int productid);
	
	 User fetchuser(int userid);
	
	void addProducttocart(Cart cart,int userid,int productid);
	
	void addProducttoWishlist(Wishlist wishlist,int userid,int productid);
	
	List<Product> fetchAll();
	
	void delete(int productid);
	
	void deletefromCart(int productid,int userid);
	
	void deletefromWishlist(int productid,int userid);
	
	void update(Product product);
	
	List<Product>fetchAllBrands();
	
	List<Product>fetchByBrand(String brnd);
	
	List<Product>fetchByCategory(String ctgry);
	
	List<Product>fetchByName(String name);
	
	 void saveProductToCart(Cart cart);

}
