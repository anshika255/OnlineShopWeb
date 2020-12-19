package com.lti.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.lti.entity.Wishlist;


@Repository
public class WishlistRepoImpl implements WishlistRepo{
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional(value=TxType.REQUIRED)
	public void save(Wishlist wslst) {
		em.persist(wslst);

	}
	

	public Wishlist fetch(int wishlistid) {
		Wishlist wslst = em.find(Wishlist.class, wishlistid);
		return wslst;
	}


	@Transactional(value=TxType.REQUIRED)
	public Wishlist update(Wishlist wslst) {
		em.merge(wslst);
		return null;
	}

}
