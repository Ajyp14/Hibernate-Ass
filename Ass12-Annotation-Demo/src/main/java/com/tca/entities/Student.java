package com.tca.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
//@Table(name="student")
@Table
public class Student {
	@Id
//	@Column(name="s_rno")
	private Integer rno;
	
	@Column(name="s_name",nullable=false)   //not null
	private String name;
	
//	@Column(name="s_per")
	private Double per;
	
//	@Column(name = "s_age")
	private Integer age;
	
	public Student() {
		super();
	}

	public int getRno() {
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

	public double getPer() {
		return per;
	}

	public void setPer(double per) {
		this.per = per;
	}


}
