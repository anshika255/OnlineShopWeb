package com.lti.service;

import java.util.List;

import com.lti.entity.Cart;
import com.lti.entity.Category;
import com.lti.entity.Product;
import com.lti.entity.User;
import com.lti.entity.Wishlist;

public interface ProductService {
	
	
    void addProduct(Product product, int retailerid,int categoryid);
	
	Product findProduct(int productid);
	
	// User fetchuser(int userid);
	
	void addingProducttocart(Cart cart,int userid,int productid);
	
	void addingProducttoWishlist(Wishlist wishlist,int userid,int productid);
	
	List<Product> fetchAllProducts();
	
	void removeProduct(int productid);
	
	void removeProductfromCart(int productid,int userid);
	
	void removeProductfromWishlist(int productid,int userid);
	
	void updateProduct(Product product);
	
	List<Product>fetchAllBrands();
	
	List<Product>fetchUsingBrand(String brnd);
	
	List<Product>fetchUsingCategory(String ctgry);
	
	List<Product>fetchUsingName(String name);
	
	// void saveProductToCart(Cart cart);

}
