package com.menu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.menu.dao.OrderDao;
import com.menu.model.OrderModelVO;

@Service
public class OrderService {
	@Autowired
	private OrderDao dao;
	
	//Service method for adding orders
	//@param - OrderModelVO we are getting from user
	//@return - Return a boolean value whether the operation was successful or not
	public boolean addOrder(OrderModelVO order) {
		return dao.addOrder(order);
	}
	
	//Service method for fetching orders
	//@return  - A List of OrderModelVO 
	public List<OrderModelVO> getOrders(){
		return dao.getOrders();
	}

}
