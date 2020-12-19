package com.lti.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Category;
import com.lti.entity.Retailer;
import com.lti.service.CategoryService;

@CrossOrigin
@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService service;
	
	@PostMapping(value="/addCategory",consumes="application/json")
	public String addCategory(@RequestBody Category ctgry) {
		service.save(ctgry);
		return "Category added successfully";
	}
	
	@PutMapping(value = "/updateCategory", consumes = "application/json")
	public String editCategory(@RequestBody Category ctgry) {
		service.update(ctgry);
		return "Category updated successfully";
	}
	
	@GetMapping(value="/listCategory",produces="application/json")
	public List<Category> listCategory() {
		return service.fetchAll();
	}

}
