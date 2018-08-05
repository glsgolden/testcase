package com.tiaa.shop.mapper;

import com.tiaa.shop.model.BranchSummary;
import com.tiaa.shop.model.FoodChainBranch;

public final class BranchMapper {
	
	private BranchMapper() {
		
	}
	
	public static BranchSummary from(FoodChainBranch branch)
	{
		BranchSummary summary = new BranchSummary();
		summary.setLocation(branch.getLocation());
		summary.setLocationId(branch.getLocationId());
		summary.setTotalCollection(branch.getTotalCollection());
		return summary;
	}
	

}
