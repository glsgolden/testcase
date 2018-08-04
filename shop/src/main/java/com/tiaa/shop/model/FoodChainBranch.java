package com.tiaa.shop.model;

import org.simpleframework.xml.Element;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FoodChainBranch {

	@Element(name="location")
	@JsonProperty("location")
	private String location;

	@Element(name="totalcollection")
	@JsonProperty("totalcollection")
	private Double totalCollection;

	@Element(name="locationid")
	@JsonProperty("locationid")
	private String locationId;

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getTotalCollection() {
		return totalCollection;
	}

	public void setTotalCollection(Double totalCollection) {
		this.totalCollection = totalCollection;
	}

	public String getLocationId() {
		return locationId;
	}

	public void setLocationId(String locationId) {
		this.locationId = locationId;
	}

}
