package com.tiaa.shop.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName("cmfoodchain")
public class FoodChainSummary {

	private List<BranchSummary> branch;

	public List<BranchSummary> getBranch() {
		return branch;
	}

	public void setBranch(List<BranchSummary> branch) {
		this.branch = branch;
	}
	
	@JsonIgnore
	public void addBranchSummary(BranchSummary summary) {
		if(this.branch == null) {
			this.branch = new ArrayList<>();
		}
		
		this.branch.add(summary);
	}
	
	@JsonIgnore
	public int getTotalBranchSummary() {
		return branch == null ?0 : branch.size();
	}

}
