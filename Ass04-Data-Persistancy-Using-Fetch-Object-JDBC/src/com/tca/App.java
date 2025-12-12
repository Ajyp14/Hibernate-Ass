package com.tca;


import java.util.ArrayList;
import java.util.List;

import com.tca.dao.StudentDaoImpl;
import com.tca.dao.StudenyDao;
import com.tca.entities.Student;

public class App {

	public static void main(String[] args) {
		
		StudenyDao sd = new StudentDaoImpl(); 	
		
		List<Student> ls=sd.getAllStudent();
		
		if(ls==null)
		{
			System.out.println("no Records found");
		}
		else
		{
			for(Student s : ls)
			{
				System.out.println(s);
			}
		}
		
//		List<String> ls = null;//new ArrayList<>();
//		
//		System.out.println(ls.hashCode());
		
	}

}
