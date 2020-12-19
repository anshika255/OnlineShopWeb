package com.lti.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.lti.entity.Cart;
import com.lti.entity.Category;
import com.lti.entity.Product;
import com.lti.entity.Retailer;
import com.lti.entity.User;
import com.lti.entity.Wishlist;

@Repository
public class ProductRepoImpl implements ProductRepo{

	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional(value=TxType.REQUIRED)
	public void save(Product product,int retailerid,int categoryid) {
		Retailer r= em.find(Retailer.class, retailerid);
		Category c=em.find(Category.class, categoryid);
		product.setCategory(c);
		product.setRetailer(r);
		em.persist(product);
		
	}
	
	@Transactional(value=TxType.REQUIRED)
	public void addProducttocart(Cart cart,int userid, int productid) {
		User usr= em.find(User.class, userid);
		Product prd=em.find(Product.class, productid);
		cart.setProduct(prd);
		cart.setCartid(cart.getCartid());
		cart.setQuantity(cart.getQuantity());
		cart.setUser(usr);
		em.persist(cart);
	}
	
	@Override
	@Transactional(value=TxType.REQUIRED)
	public void addProducttoWishlist(Wishlist wishlist, int userid, int productid) {
		User usr= em.find(User.class, userid);
		Product prd=em.find(Product.class, productid);
		wishlist.setProduct(prd);
		wishlist.setWishlistid(wishlist.getWishlistid());
		wishlist.setQuantity(wishlist.getQuantity());
		wishlist.setUser(usr);
		em.persist(wishlist);
		
	}
	
	


	public Product fetch(int productid) {
		Product product = em.find(Product.class, productid);
		return product;
	}

	public List<Product> fetchAll() {
		return em.createQuery("from Product").getResultList();
	}
	
	public List<Retailer> fetchByID() {
		return em.createQuery("from Retailer").getResultList();
	}

	@Transactional(value=TxType.REQUIRED)
	public void delete(int productid) {
		em.remove(em.find(Product.class, productid));
		
	}
	
	@Transactional(value=TxType.REQUIRED)
	public void deletefromCart(int productid, int userid) {
   int rowsDeleted  = em.createQuery("DELETE FROM Cart c WHERE c.user.userid=:uid AND c.product.productid=:pid ")
				 .setParameter("uid", userid).setParameter("pid", productid).executeUpdate();
	      System.out.println("entities deleted: " + rowsDeleted); 
	}
	
	@Transactional(value=TxType.REQUIRED)
	public void deletefromWishlist(int productid, int userid) {
   int rowsDeleted  = em.createQuery("DELETE FROM Wishlist c WHERE c.user.userid=:uid AND c.product.productid=:pid ")
				 .setParameter("uid", userid).setParameter("pid", productid).executeUpdate();
	      System.out.println("entities deleted: " + rowsDeleted); 
	}


	@Transactional(value=TxType.REQUIRED)
	public void update(Product product) {
			em.merge(product);
	}

	public List<Product> fetchAllBrands() {
		return em.createQuery("Select distinct(p.brand) from Product p").getResultList();
	}
	
	public List<Product> fetchByBrand(String brnd) {
		return em.createQuery("Select p from Product p where UPPER(p.brand) LIKE UPPER(:pb)")
				.setParameter("pb", "%"+brnd+"%")
				.getResultList();
	}

	@Override
	public List<Product> fetchByName(String nme) {
		return em.createQuery("Select p from Product p where UPPER(p.name) LIKE UPPER(:pb)")
				.setParameter("pb", "%"+nme+"%")
				.getResultList();
	}

	@Override
	public List<Product> fetchByCategory(String ctgry) {
		return em.createQuery("Select p from Product p where UPPER(p.category.categoryname) LIKE UPPER(:pb)")
				.setParameter("pb", "%"+ctgry+"%")
				.getResultList();
	}

	

	@Override
	public User fetchuser(int userid) {
		User usr = em.find(User.class, userid);
		return usr;
	}

	@Transactional(value=TxType.REQUIRED)
	public void saveProductToCart(Cart cart) {
		em.merge(cart);
	}

	

	

	
	
	

	

}
