package com.example.model;

import java.time.LocalDateTime;
import java.util.Date;

public class Client {
 
		private String clName;
		private String clMobile;
		private String clAmount;
		private LocalDateTime date;
		private String user;
		private String clAddress;
		
	
		public String getClAddress() {
			return clAddress;
		}
		public void setClAddress(String clAddress) {
			this.clAddress = clAddress;
		}
		public String getClName() {
			return clName;
		}
		public void setClName(String clName) {
			this.clName = clName;
		}
		public String getClMobile() {
			return clMobile;
		}
		public void setClMobile(String clMobile) {
			this.clMobile = clMobile;
		}
		public String getClAmount() {
			return clAmount;
		}
		public void setClAmount(String clAmount) {
			this.clAmount = clAmount;
		}
		public LocalDateTime getDate() {
			return date;
		}
		public void setDate(LocalDateTime date) {
			this.date = date;
		}
		public String getUser() {
			return user;
		}
		public void setUser(String user) {
			this.user = user;
		}
		@Override
		public String toString() {
			return "Client [clName=" + clName + ", clMobile=" + clMobile + ", clAmount=" + clAmount + ", date=" + date
					+ ", user=" + user + "]";
		}
		
		
}
