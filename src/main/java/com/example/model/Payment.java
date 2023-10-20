package com.example.model;

import java.util.List;

public class Payment {
	
	private Double totalAmount;
	private List<History> entries;
	public Double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public List<History> getEntries() {
		return entries;
	}
	public void setEntries(List<History> entries) {
		this.entries = entries;
	}

}
