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
    	Transaction tr=null;
    	
    	try {
    		configuration=new Configuration();
    		configuration.configure();
    		configuration.addAnnotatedClass(Student.class);
    		
    		factory=configuration.buildSessionFactory();
    		session=factory.openSession();
    		tr=session.beginTransaction();
    		
    		Student st= new Student();
    		st.setName("Ajay Pawar");
    		st.setPer(78.88);
    		
    		session.persist(st);
    		int trno =(int) session.getIdentifier(st);
    		
    		System.out.println("Trno : "+trno);
    		tr.commit();
    		
    	}catch (Exception e) {
    		tr.rollback();
    		e.printStackTrace();
			
		}finally {
			session.close();
			factory.close();
		}
        
    }
}
