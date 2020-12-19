package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.lti.entity.Category;
import com.lti.entity.Product;
import com.lti.entity.Retailer;
import com.lti.entity.User;
import com.lti.pojo.RetailerLoginDto;


@Repository
public class RetailerRepoImpl implements RetailerRepo{

	@PersistenceContext
	private EntityManager em;
	
	@Transactional(value=TxType.REQUIRED)
	public void save(Retailer retailer) {
		em.persist(retailer);
		
	}

	public Retailer fetch(int retailerid) {
		Retailer rtlr = em.find(Retailer.class, retailerid);
		return rtlr;
	}

	
	@Transactional(value=TxType.REQUIRED)
	public void delete(int retailerid) {
		em.remove(em.find(Retailer.class, retailerid));
	}

	
	@Transactional(value=TxType.REQUIRED)
	public void update(Retailer rtlr) {
		em.merge(rtlr);
		
	}

	public List<Retailer> fetchAll() {
	return em.createQuery("from Retailer").getResultList();
		
	}

	public List find(Class<Retailer> class1, int i) {
		return em.createQuery("from Retailer").getResultList();
	}

//	@Override
//	public Retailer login(String email, String password) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public Retailer authenticate(RetailerLoginDto login) {
		Query query = em.createNamedQuery("loginRetailer");
		query.setParameter("eml", login.getEmail());
		query.setParameter("pwd", login.getPassword());
		return (Retailer) query.getSingleResult();
	}

	@Override
	public List<Category> fetchCategory() {
		return em.createQuery("select DISTINCT(c.categoryname) from Category c").getResultList();
	}

	@Override
	public List<Product> forParticularRetailer(int retailerId) {
		return (List<Product>)em
				.createQuery("from Product p where p.retailer.retailerid = :rId")
				.setParameter("rId", retailerId)
				.getResultList();
	}

}
