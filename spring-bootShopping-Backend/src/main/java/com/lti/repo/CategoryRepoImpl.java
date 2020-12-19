package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.lti.entity.Category;

@Repository
public class CategoryRepoImpl implements CategoryRepo{

	@PersistenceContext
	private EntityManager em;
	
	@Transactional(value=TxType.REQUIRED)
	public void save(Category category) {
		em.persist(category);
		
	}
	
	public Category fetch(int categoryid) {
		Category ctgry = em.find(Category .class, categoryid);
		return ctgry;
	}
	
	public List<Category> fetchAll() {
		return em.createQuery("from Category").getResultList();
	}
	
	@Transactional(value=TxType.REQUIRED)
	public void delete(int categoryid) {
		em.remove(em.find(Category.class, categoryid));
	}
	
	@Transactional(value=TxType.REQUIRED)
	public void update(Category ctgry) {
		em.merge(ctgry);
		
	}

	
}
