package com.lti.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.lti.entity.Category;
import com.lti.entity.Product;
import com.lti.entity.Retailer;
import com.lti.entity.User;
import com.lti.pojo.RetailerLoginDto;
import com.lti.repo.RetailerRepo;


@Service
public class RetailerServiceImpl implements RetailerService{

	@Autowired
	private RetailerRepo repo;

	@Transactional(value=TxType.REQUIRED)
	public void addRetailer(Retailer retailer) {
		repo.save(retailer);
		
	}

	
	public Retailer find(int retailerid) {
		return repo.fetch(retailerid);
	}

	
	public List<Retailer> fetchAllRetailer() {
		return repo.fetchAll();
	}

	@Transactional(value=TxType.REQUIRED)
	public void removeRetailer(int retailerid) {
		repo.delete(retailerid);
		
	}

	@Transactional(value=TxType.REQUIRED)
	public void updateRetailer(Retailer rtlr) {
		repo.update(rtlr);
		
	}

	
	public Retailer validate(RetailerLoginDto login) {
		return repo.authenticate(login);
	}

	
	public List<Category> fetchAllCategories() {
		return repo.fetchCategory();
	}

	
	public List<Product> RetailersProducts(int retailerId) {
		return repo.forParticularRetailer(retailerId);
	}
	
	
	

}
