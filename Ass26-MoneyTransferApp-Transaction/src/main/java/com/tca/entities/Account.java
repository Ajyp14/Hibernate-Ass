package com.tca.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="account")
public class Account 
{
	@Id
	private Integer acc_no;
	private String acc_holdername;
	private String acc_type;
	private Double balance;
	
	
	public Integer getAcc_no() {
		return acc_no;
	}
	public void setAcc_no(Integer acc_no) {
		this.acc_no = acc_no;
	}
	public String getAcc_holdername() {
		return acc_holdername;
	}
	public void setAcc_holdername(String acc_holdername) {
		this.acc_holdername = acc_holdername;
	}
	public String getAcc_type() {
		return acc_type;
	}
	public void setAcc_type(String acc_type) {
		this.acc_type = acc_type;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	

}
