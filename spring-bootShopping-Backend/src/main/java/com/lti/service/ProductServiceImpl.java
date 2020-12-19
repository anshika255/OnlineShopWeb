package com.lti.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.lti.entity.Cart;
import com.lti.entity.Category;
import com.lti.entity.Product;
import com.lti.entity.Retailer;
import com.lti.entity.User;
import com.lti.entity.Wishlist;
import com.lti.repo.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService{

	
	@Autowired
	private ProductRepo repo;

	@Transactional(value=TxType.REQUIRED)
	public void addProduct(Product product, int retailerid, int categoryid) {
		repo.save(product, retailerid, categoryid);
		
	}

	
	public Product findProduct(int productid) {
		return repo.fetch(productid);
	}

	@Transactional(value=TxType.REQUIRED)
	public void addingProducttocart(Cart cart, int userid, int productid) {
		repo.addProducttocart(cart, userid, productid);
		
	}

	@Transactional(value=TxType.REQUIRED)
	public void addingProducttoWishlist(Wishlist wishlist, int userid, int productid) {
		repo.addProducttoWishlist(wishlist, userid, productid);
		
	}

	
	public List<Product> fetchAllProducts() {
		return repo.fetchAll();
	}

	@Transactional(value=TxType.REQUIRED)
	public void removeProduct(int productid) {
		repo.delete(productid);
		
	}
	
	@Transactional(value=TxType.REQUIRED)
	public void removeProductfromCart(int productid,int userid) {
	     repo.deletefromCart(productid,userid);
		
	}
	
	@Transactional(value=TxType.REQUIRED)
	public void removeProductfromWishlist(int productid,int userid) {
	     repo.deletefromWishlist(productid,userid);
		
	}
	

	@Transactional(value=TxType.REQUIRED)
	public void updateProduct(Product product) {
		repo.update(product);
		
	}

	
	public List<Product> fetchAllBrands() {
		return repo.fetchAllBrands();
	}

	
	public List<Product> fetchUsingBrand(String brnd) {
		return repo.fetchByBrand(brnd);
	}

	
	public List<Product> fetchUsingCategory(String ctgry) {
		return repo.fetchByCategory(ctgry);
	}

	
	public List<Product> fetchUsingName(String name) {
		return repo.fetchByName(name);
	}


	
	
	
	

	

	
	
	

	

}
