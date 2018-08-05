package com.tiaa.shop.service;

import com.tiaa.shop.mapper.BranchMapper;
import com.tiaa.shop.model.BranchSummary;
import com.tiaa.shop.model.FoodChain;
import com.tiaa.shop.model.Order;

public class TotalCollectionChecker {

	public BranchSummary getBranchSummary(FoodChain chain)
	{
		Double sum = chain.getOrderList().stream().filter(order -> order.getBillAmount() > 0).mapToDouble(Order::getBillAmount).sum();
		BranchSummary summary = BranchMapper.from(chain.getBranch());
		summary.setSumOfOrder(sum);
		return summary;
	}
	
}
