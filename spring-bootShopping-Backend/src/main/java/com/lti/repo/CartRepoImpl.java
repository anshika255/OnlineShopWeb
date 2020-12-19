package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.lti.entity.Cart;
import com.lti.entity.Category;
import com.lti.entity.Orders;
import com.lti.entity.Product;
import com.lti.entity.Retailer;
import com.lti.entity.User;


@Repository
public class CartRepoImpl implements CartRepo{
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional(value=TxType.REQUIRED)
	public void save(Cart cart,int userid,int productid) {
		User usr=em.find(User.class, userid);
		Product prdct=em.find(Product.class, productid);
		cart.setUser(usr);
		cart.setProduct(prdct);
		cart.setQuantity(1);
		em.persist(cart);

	}


	@Transactional(value=TxType.REQUIRED)
	public Cart update(Cart cart) {
		em.merge(cart);
		return null;
	}
	
	
	public List<Cart> fetchAll() {
		return em.createQuery("from Cart").getResultList();
			
		}


	public Cart fetch(int cartid) {
		Cart cart=em.find(Cart.class, cartid);
		return cart;
	}


	
	
	
	

	
}
