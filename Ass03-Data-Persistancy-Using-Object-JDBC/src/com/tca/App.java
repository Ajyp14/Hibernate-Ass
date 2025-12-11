package com.tca;

import com.tca.dao.StudentDaoImpl;
import com.tca.dao.StudenyDao;
import com.tca.entities.Student;

public class App {

	public static void main(String[] args) {
		
		Student s1=new Student();
		s1.setRno(101);
		s1.setName("sapna");
		s1.setPer(90);
		
		StudenyDao sd= new StudentDaoImpl();
		
		String status = sd.save(s1);

		if(status.equalsIgnoreCase("success"))
		 System.out.println("Record is save successfully");
		else if(status.equalsIgnoreCase("failed")) 
		 System.out.println("Record is not saved!!!");
		
	}

}
