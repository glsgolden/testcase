package com.tiaa.shop.model;

import org.simpleframework.xml.Element;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

@Element(name="orderdetail")
public class Order {

	@Element(name="orderid")
	private int orderId;

	@Element(name="billamount")
	private Double billAmount;

	public int getOrderId() {
		return orderId;
	}

	@JsonProperty("orderid")
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Double getBillAmount() {
		return billAmount;
	}

	@JsonProperty("billamount")
	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}

}
