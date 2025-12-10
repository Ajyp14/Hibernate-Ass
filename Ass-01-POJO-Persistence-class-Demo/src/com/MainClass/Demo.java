package com.MainClass;

import com.Persistence.demo.Student;

public class Demo {

	public static void main(String[] args) {
		Student s1= new Student(1,"Ajay",75);
		
		System.out.println(s1);
		
		Student s2 = new  Student();
		s2.setRno(101);
		s2.setName("rksg");
		s2.setPer(75.8);
		
		System.out.println(s2);
	}

}
