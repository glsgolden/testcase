package com.tiaa.shop.model;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.annotation.JsonSetter;

public class FoodChain {

	@Element(name = "branch")
	private FoodChainBranch branch;

	@ElementList(name = "orders")
	private List<Order> ordersList;

	private OrderHolder orders;

	public FoodChainBranch getBranch() {
		return branch;
	}

	public void setBranch(FoodChainBranch branch) {
		this.branch = branch;
	}

	public List<Order> getOrderList() {
		return ordersList;
	}

	public void setOrderList(List<Order> ordersList) {
		this.ordersList = ordersList;
	}
	
	
	public OrderHolder getOrders() {
		return orders;
	}

	public void setOrders(OrderHolder orders) {
		this.orders = orders;
	}

}
