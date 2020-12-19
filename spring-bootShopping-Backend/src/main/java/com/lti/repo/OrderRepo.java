package com.lti.repo;

import java.util.List;

import javax.persistence.criteria.Order;

import com.lti.entity.Orders;


public interface OrderRepo {

	 void save(Orders order,int userid,int productid);
		
	 Orders fetch(int orderid);
	 

}
