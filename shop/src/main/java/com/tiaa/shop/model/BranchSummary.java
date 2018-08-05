package com.tiaa.shop.model;

import org.simpleframework.xml.Element;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"location", "totalcollection","sumoforder", "locationid"})
public class BranchSummary extends FoodChainBranch {

	@JsonProperty("sumoforder")
	private Double sumOfOrder;
	

	public Double getSumOfOrder() {
		return sumOfOrder;
	}

	public void setSumOfOrder(Double sumOfOrder) {
		this.sumOfOrder = sumOfOrder;
	}

	@JsonIgnore
	public boolean isTotalMatch() {
		return getTotalCollection().doubleValue() == getSumOfOrder().doubleValue() ? Boolean.TRUE : Boolean.FALSE;
	}
	
	


}
