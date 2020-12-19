package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Order;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.lti.entity.Orders;
import com.lti.entity.Product;
import com.lti.entity.Retailer;
import com.lti.entity.User;

@Repository
public class OrderRepoImpl implements OrderRepo {

	@PersistenceContext
	private EntityManager em;
	
	@Transactional(value=TxType.REQUIRED)
	public void save(Orders order,int userid,int productid) {
		User usr=em.find(User.class, userid);
		Product prdct=em.find(Product.class, productid);
		order.setProduct(prdct);
		order.setRetailer(prdct.getRetailer());
		order.setUser(usr);
		em.persist(order);
		
	}
	
	public Orders fetch(int orderid) {
		Orders ordr = em.find(Orders .class, orderid);
		return ordr;
	}
	
	
	

	
}
