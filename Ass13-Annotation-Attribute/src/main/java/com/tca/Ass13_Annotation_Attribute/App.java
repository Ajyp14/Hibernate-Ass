package com.tca.Ass13_Annotation_Attribute;

import javax.naming.directory.InvalidAttributesException;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.tca.entities.Student;

public class App 
{
	//in case of "Validate"
	public static Student addData(Integer rno,String name,Double per,String email) throws InvalidAttributesException
	{
		if(per<0 || per>100)
		{
			throw new InvalidAttributesException("Percentage should be between 0 and 100");
		}
		
		Student st=new Student();
		st.setRno(rno);
		st.setName(name);
		st.setPer(per);
		st.setEmail(email);
		
		return st;
	}
    public static void main( String[] args ) throws InvalidAttributesException
    {
         Configuration configuration=null;
        SessionFactory factory=null;
        Session session=null;
        Transaction trn=null;
        
        try {
			configuration=new Configuration();
			

			configuration.configure();
			

			configuration.addAnnotatedClass(Student.class);
			
			factory=configuration.buildSessionFactory();

			session=factory.openSession();

			trn=session.beginTransaction();
			
//			Student st=new Student();
//			st.setRno(1);
//			st.setName("AXAX");
//			st.setPer(101.22);
//			st.setEmail("abc@1234");
			
			Student st=App.addData(1, "AXAX", 101.22, "abc@1234");
			
			session.save(st);
			
			trn.commit();
			session.close();
			factory.close();
		} catch (HibernateException e) {
			//trn.rollback();
			e.printStackTrace();
		}
        
        
    }
}

//create table tca_student(rno int primary key,tca_name varchar(50) not null,tca_per float,email varchar(30) unique);
