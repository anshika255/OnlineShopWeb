package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Repository;

import com.lti.entity.Orders;
import com.lti.entity.User;
import com.lti.pojo.Login;
import com.lti.entity.Product;

@Repository
public class UserRepoImpl implements UserRepo{

	@PersistenceContext
	private EntityManager em;
	
	@Transactional(value=TxType.REQUIRED)
	public void save(User user) {
		em.persist(user);

	}
	

	public User fetch(int userid) {
		User usr = em.find(User.class, userid);
		return usr;
	}


	@Transactional(value=TxType.REQUIRED)
	public User update(User user) {
		em.merge(user);
		return null;
	}


	@Override
	public User authenticate(Login login) {
		Query query = em.createNamedQuery("login");
		query.setParameter("uname", login.getUsername());
		query.setParameter("pwd", login.getPassword());
		return (User) query.getSingleResult();
	}
	


	@Override
	public List<Orders> displayOrderForUser(int userid) {
		String sql= "select o from Orders o where o.user.userid =:usrid";
		  Query query = em.createQuery(sql);
		query.setParameter("usrid", userid);
		List<Orders> orders = query.getResultList();
		return orders;
	}
	
	public List<Product> forParticularCart(int userId) {
		return (List<Product>)em
				.createQuery("select c.product from Cart c where c.user.userid = :uId")
				.setParameter("uId", userId)
				.getResultList();
	}


	@Override
	public List<Product> forParticularWishlist(int userId) {
		return (List<Product>)em
				.createQuery("select c.product from Wishlist c where c.user.userid = :uId")
				.setParameter("uId", userId)
				.getResultList();
	}
	
	@Transactional(value=TxType.REQUIRED)
	public void save(Orders order,int userid,int productid) {
		User usr=em.find(User.class, userid);
		Product prdct=em.find(Product.class, productid);
		order.setProduct(prdct);
		order.setRetailer(prdct.getRetailer());
		order.setUser(usr);
		em.persist(order);
		
	}

}
