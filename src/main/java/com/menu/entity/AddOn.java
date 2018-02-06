package com.menu.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
// Our Add on entity which has many to one relationship with order entity
@Entity
@Table(name="addon")
public class AddOn implements Serializable{
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name= "addon_id", unique=true, nullable=false)
	private Integer addon_id;
	
	@Column(name="addon_item")
	private String addon_item;
	
	@ManyToOne(fetch= FetchType.LAZY, optional = false)
	@JoinColumn(name="order_id", nullable=false)
	private OrderEntity order;
	
	public Integer getAddon_id() {
		return addon_id;
	}
	public void setAddon_id(Integer addon_id) {
		this.addon_id = addon_id;
	}
	public String getAddon_item() {
		return addon_item;
	}
	public void setAddon_item(String addon_item) {
		this.addon_item = addon_item;
	}
	public OrderEntity getOrder() {
		return order;
	}
	public void setOrder(OrderEntity order) {
		this.order = order;
	}

	
	
}
