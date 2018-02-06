package com.menu.model;

import java.util.List;

//Our modelVO for taking input from user and displaying data to user
public class OrderModelVO {
	
	private String order;
	private List<String> addon;
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public List<String> getAddon() {
		return addon;
	}
	public void setAddon(List<String> addon) {
		this.addon = addon;
	}
	
	

}
