package com.tiaa.shop.model;

import org.simpleframework.xml.Element;

@Element(name="orderdetail")
public class Order {

	@Element(name="orderid")
	private int orderId;

	@Element(name="billamount")
	private Double billAmount;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public Double getBillAmount() {
		return billAmount;
	}

	public void setBillAmount(Double billAmount) {
		this.billAmount = billAmount;
	}

}
