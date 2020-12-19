package com.lti.repo;

import java.util.List;

import com.lti.entity.Category;

public interface CategoryRepo {

	 void save(Category category);
		
	 Category fetch(int categoryid);
		
		List<Category> fetchAll();
		
		void delete(int categoryid);
		
		void update(Category ctgry);
}
