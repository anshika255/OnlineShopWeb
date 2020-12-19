package com.lti.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Cart;
import com.lti.entity.Category;
import com.lti.entity.Product;
import com.lti.service.ProductService;
import com.lti.entity.User;
import com.lti.entity.Wishlist;
import com.lti.pojo.CartDto;

@CrossOrigin
@RestController
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@PostMapping(value="/addProduct/{rid}/{cid}",consumes="application/json")
	public String addProduct(@RequestBody Product prdct , @PathVariable int rid,@PathVariable int cid) {
		service.addProduct(prdct, rid, cid);
		return "Product added successfully";
	}
	
	@PostMapping(value="/addProducttocart/{uid}/{pid}",consumes="application/json")
	public String addProducttoCart(@RequestBody Cart crt,@PathVariable int uid, @PathVariable int pid) {
		service.addingProducttocart(crt, uid, pid);
		return "Product added To Cart successfully";
	}
	
	@PostMapping(value="/addProducttowishlist/{uid}/{pid}",consumes="application/json")
	public String addProducttoWishlist(@RequestBody Wishlist wishlist ,@PathVariable int uid, @PathVariable int pid) {
		service.addingProducttoWishlist(wishlist, uid, pid);
		return "Product added To Wishlist successfully";
	}
	
	@GetMapping(value="/listProduct",produces="application/json")
	public List<Product> listProduct() {
		return service.fetchAllProducts();
	}
	
	
	@PutMapping(value = "/updateProduct", consumes = "application/json")
	public String editProduct(@RequestBody Product prdct) {
		service.updateProduct(prdct);
		return "Product updated successfully";
	}
	
	@DeleteMapping("/delProduct/{id}")
	public String delproduct(@PathVariable int id) {
		service.removeProduct(id);
		return "Product deleted successfully";
	}
	
	@DeleteMapping("/delProductfromCart/{pid}/{uid}")
	public String delproductfromCart(@PathVariable int pid,@PathVariable int uid) {
		service.removeProductfromCart(pid,uid);
		return "Product deleted from Cart successfully";
	}
	
	@DeleteMapping("/delProductfromWishlist/{pid}/{uid}")
	public String delproductfromWishlist(@PathVariable int pid,@PathVariable int uid) {
		service.removeProductfromWishlist(pid,uid);
		return "Product deleted from Wishlist successfully";
	}
	
	@GetMapping(value = "/fetchProduct/{id}", produces = "application/json")
	public Product fetchProductById(@PathVariable int id) {
		return service.findProduct(id);
	}
	
	@GetMapping(value = "/fetchProductBybrand/{brand}", produces = "application/json")
	public List<Product> listProductByBrands(@PathVariable String brand) {
		return service.fetchUsingBrand(brand);
	}
	
	@GetMapping(value = "/fetchProductByName/{name}", produces = "application/json")
	public List<Product> listProductByName(@PathVariable String name) {
		return service.fetchUsingName(name);
	}
	
	@GetMapping(value = "/fetchProductByCategory/{categoryname}", produces = "application/json")
	public List<Product> listProductByCategory(@PathVariable String categoryname) {
		return service.fetchUsingCategory(categoryname);
	}
	
	@GetMapping(value = "/fetchProductBrands", produces = "application/json")
	public List<Product> listProductBrands() {
		return service.fetchAllBrands();
	}
	
	
	
}
	
	
	


