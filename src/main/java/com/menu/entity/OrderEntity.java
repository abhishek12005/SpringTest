package com.menu.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
// Our main entity order which will store the orders
@Entity
@Table(name="orderentity")
public class OrderEntity implements Serializable {

	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name="order_id", unique=true, nullable=false)
	private Integer order_id;

	// Our main primary OrderItem 
	@Column(name="order_item", nullable=false)
	private String order_item;
	
	//Add ons will be stored as a separate table with one to many relationship with 
	//order and add ons
	@OneToMany(fetch= FetchType.LAZY, mappedBy="order", cascade = CascadeType.ALL)
	private Set<AddOn> addonItems;

	public Integer getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Integer order_id) {
		this.order_id = order_id;
	}

	public String getOrder_item() {
		return order_item;
	}

	public void setOrder_item(String order_item) {
		this.order_item = order_item;
	}

	public Set<AddOn> getAddonItems() {
		return addonItems;
	}

	public void setAddonItems(Set<AddOn> addonItems) {
		this.addonItems = addonItems;
	}
	
	
}

