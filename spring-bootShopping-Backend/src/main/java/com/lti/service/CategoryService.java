package com.lti.service;

import java.util.List;

import com.lti.entity.Category;

public interface CategoryService {

	 void save(Category category);
		
	 Category fetch(int categoryid);
		
		List<Category> fetchAll();
		
		void delete(int categoryid);
		
		void update(Category ctgry);
}
