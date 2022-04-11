package com.example.demo;

public class orderBean {
	
	private String date;
	private String region;
	private String firstName;
	private String surName;
	private String item;
	private String units;
	private String unitCost;
	private String totalCost;
	
	
	
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public String getUnits() {
		return units;
	}

	public void setUnits(String units) {
		this.units = units;
	}

	public String getUnitCost() {
		return unitCost;
	}

	public void setUnitCost(String unitCost) {
		this.unitCost = unitCost;
	}

	public String getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(String totalCost) {
		this.totalCost = totalCost;
	}


	public  String toJsonString() {
		String pattern = "{ \"Date\": \"%s\", \"Region\": \"%s\", \"First Name\": \"%s\", \"Sur Name\": \"%s\", \"Item\": \"%s\", \"Units\": \"%s\", \"Unit Cost\": \"%s\", \"Total Cost\": \"%s\" }";

		String out = String.format(pattern,
				this.date,
				this.region,
				this.firstName,
				this.surName,
				this.item,
				this.units,
				this.unitCost,
				this.totalCost
				);

		return out;
	}

}
