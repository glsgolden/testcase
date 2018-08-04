package com.tiaa.shop.service;

import com.tiaa.shop.model.FoodChain;
import com.tiaa.shop.model.Order;

public class TotalCollectionChecker {

	public boolean checkTotalCollection(FoodChain chain)
	{
		Double totalCollection = chain.getBranch().getTotalCollection();
		
		Double sum = chain.getOrders().stream().filter(order -> order.getBillAmount() > 0).mapToDouble(Order::getBillAmount).sum();
		
		return totalCollection.doubleValue() == sum.doubleValue() ? Boolean.TRUE : Boolean.FALSE;
	}
	
}
