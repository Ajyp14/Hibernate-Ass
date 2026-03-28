package com.tca.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity

public class Student {
	
	@Id
	@SequenceGenerator(name = "sg",sequenceName = "tcaseq",allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sg")
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
