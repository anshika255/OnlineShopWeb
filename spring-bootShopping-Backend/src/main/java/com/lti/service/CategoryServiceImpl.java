package com.lti.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.lti.entity.Category;
import com.lti.repo.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService{

	@Autowired
	private CategoryRepo repo;

	@Transactional(value=TxType.REQUIRED)
	public void save(Category category) {
		repo.save(category);
		
	}

	@Override
	public Category fetch(int categoryid) {
		return repo.fetch(categoryid);
	}

	@Override
	public List<Category> fetchAll() {
		return repo.fetchAll();
	}

	@Transactional(value=TxType.REQUIRED)
	public void delete(int categoryid) {
		repo.delete(categoryid);
		
	}

	@Transactional(value=TxType.REQUIRED)
	public void update(Category ctgry) {
		repo.update(ctgry);
		
	}
	
	
	

	
}
