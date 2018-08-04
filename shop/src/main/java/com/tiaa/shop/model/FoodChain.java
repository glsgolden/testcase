package com.tiaa.shop.model;

import java.util.List;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.ElementList;
import org.simpleframework.xml.Root;

@Root(name="cmfoodchain")
public class FoodChain {

	@Element(name="branch")
	private FoodChainBranch branch;

	@ElementList(name="orders")
	private List<Order> orders;

	public FoodChainBranch getBranch() {
		return branch;
	}

	public void setBranch(FoodChainBranch branch) {
		this.branch = branch;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
