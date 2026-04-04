package com.tca.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.TableGenerator;

@Entity

public class Student {
	
	@Id
	@TableGenerator(name="tg",table = "mytab",pkColumnName = "myid",pkColumnValue = "200" ,valueColumnName = "next_hi",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.TABLE,generator = "tg")
	private Integer rno;

	private String name;

	private Double per;

	public Integer getRno() {
		return rno;
	}

	public void setRno(Integer rno) {
		this.rno = rno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPer() {
		return per;
	}

	public void setPer(Double per) {
		this.per = per;
	}

	

}
