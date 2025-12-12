package com.tca.dao;

import java.util.List;

import com.tca.entities.Student;

public interface StudenyDao {
	
	//Interface ha only abstract methods
	
  public abstract String save(Student ob);
  
  public abstract List<Student> getAllStudent();

}
