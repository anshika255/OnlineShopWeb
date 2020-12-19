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

import com.lti.entity.Orders;
import com.lti.entity.User;
import com.lti.pojo.Login;
import com.lti.repo.UserRepo;
import com.lti.entity.Product;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepo repo;


	@Transactional(value = TxType.REQUIRED)
	public void addUser(User user) {
		repo.save(user);
		
	}

	
	public User findUser(int userid) {
		return repo.fetch(userid);
	}

	@Transactional(value = TxType.REQUIRED)
	public User updateUser(User user) {
		return repo.update(user);
	}

	
	public User validate(Login login) {
		return repo.authenticate(login);
	}
	
	


	public List<Orders> displayOrderOfUser(int userid) {
		return repo.displayOrderForUser(userid);
	}

	
	public List<Product> fetchCart(int userId) {
		return repo.forParticularCart(userId);
	}

	
	public List<Product> fetchWishlist(int userId) {
		return repo.forParticularWishlist(userId);
		
	}


	@Transactional(value = TxType.REQUIRED)
	public void save(Orders order, int userid, int productid) {
		repo.save(order, userid, productid);
		
	}
	
	

}
