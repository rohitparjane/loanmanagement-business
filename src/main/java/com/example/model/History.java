package com.example.model;

import java.time.LocalDateTime;

public class History {
	
	private String clUser;
	private  Double hiAmount;
	private String hiInterest;
	private LocalDateTime hiDate;
	private int srNo;
	
	
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public String getClUser() {
		return clUser;
	}
	public void setClUser(String clUser) {
		this.clUser = clUser;
	}
	public Double getHiAmount() {
		return hiAmount;
	}
	public void setHiAmount(Double hiAmount) {
		this.hiAmount = hiAmount;
	}
	public String getHiInterest() {
		return hiInterest;
	}
	public void setHiInterest(String hiInterest) {
		this.hiInterest = hiInterest;
	}
	public LocalDateTime getHiDate() {
		return hiDate;
	}
	public void setHiDate(LocalDateTime hiDate) {
		this.hiDate = hiDate;
	}
	@Override
	public String toString() {
		return "History [clUser=" + clUser + ", hiAmount=" + hiAmount + ", hiInterest=" + hiInterest + ", hiDate="
				+ hiDate + "]";
	}
	
	

}
