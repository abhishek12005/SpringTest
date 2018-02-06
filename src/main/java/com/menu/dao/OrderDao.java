package com.menu.dao;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.menu.entity.AddOn;
import com.menu.entity.OrderEntity;
import com.menu.model.OrderModelVO;
import com.menu.util.HibernateUtil;

@Repository
public class OrderDao {

	@Autowired
	HibernateUtil hiber;
	
	//Dao Method for adding order in database
	//@param - OrderModelVO we are getting from user
	//@return - Return a boolean value whether the operation was successful or not
	public boolean addOrder(OrderModelVO orderentry) {
		StatelessSession session = hiber.getHiberSessionFactory().openStatelessSession();
		Transaction tx=null;
		if(orderentry != null && session != null)
		{
			try {
				tx=session.beginTransaction();
				OrderEntity order = new OrderEntity(); 
				order.setOrder_item(orderentry.getOrder());
				List<String> addon = orderentry.getAddon();
				
				if(addon.isEmpty()) {
					session.insert(order);
					tx.commit();
					return true;
				}
				else {
					List<AddOn> ad = new ArrayList<AddOn>();
					for(String a: addon) {
						AddOn addone = new AddOn();
						addone.setAddon_item(a);
						addone.setOrder(order);
						ad.add(addone);
					}
					Set<AddOn> io=new HashSet<AddOn>(ad);
					Iterator<AddOn> i=io.iterator();
					order.setAddonItems(io);
					session.insert(order);	
					while(i.hasNext())
					{
						session.insert(i.next());
					}
					
					tx.commit();
					return true;
				}
			}catch (Exception e) {
				if (tx != null)
					tx.rollback();
				throw e;
				// TODO: handle exception
			} finally {
				session.close();
			}
		}
		else
			{return false;}
	}
	
	//Dao method for displaying all orders
	//@return  - A List of OrderModelVO  
	public List<OrderModelVO> getOrders(){
		List<OrderEntity> orders = new ArrayList<>();
		List<OrderModelVO> ordervo = new ArrayList<>();
		try {
			Criteria crit = hiber.getHiberSessionFactory().openSession().createCriteria(OrderEntity.class);
			orders = (ArrayList<OrderEntity>) crit.list();
			for (OrderEntity o: orders)
			{
				OrderModelVO order = new OrderModelVO();
				order.setOrder(o.getOrder_item());
				List<String> addon_item=new ArrayList<>();
				for(AddOn a:o.getAddonItems()) {
						String s=a.getAddon_item();
						addon_item.add(s);
				}
				order.setAddon(addon_item);
				ordervo.add(order);
			}
			return ordervo;
		}catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
	}
}
