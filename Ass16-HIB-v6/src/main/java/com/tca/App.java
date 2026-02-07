package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;


public class App 
{
	 public static void main( String[] args )
	    {
	        Configuration configuration=null;
	        SessionFactory factory=null;
	        Session session=null;
	        Transaction transaction=null;
	        
	        
	        try {
	        	
	        	configuration=new Configuration();
	        	configuration.configure();
	        	
	        	configuration.addAnnotatedClass(Student.class);
	        	
	        	factory=configuration.buildSessionFactory();
	        	session=factory.openSession();
	        	transaction=session.beginTransaction();
	        	
	        	Student st =new Student();
	        	st.setRno(888);
	        	st.setName("prathamesh");
	        	st.setPer(77.77);

//	        	Depricated now
//	        	int trno =(int) session.save(st); 
//	        	System.out.println("Saved --> "+trno);
	        	
	        	session.persist(st);
	        	int trno=(int) session.getIdentifier(st);
	        	System.out.println("Persist --> "+trno);

	        	
	        	
	        	
	        	transaction.commit();
	        	
	        }catch (Exception e) {
	        	transaction.rollback();
				e.printStackTrace();
			}finally {
				session.close();
				factory.close();
			}
	        
	        
	    }

}
