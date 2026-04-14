package com.tca.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Student;
import com.tca.entities.StudentCompositeKey;

public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = null;
        SessionFactory factory=null;
        Session session=null;
        Transaction tr=null;
        
        try {
        	configuration=new Configuration();
        	configuration.configure();
        	
        	factory=configuration.buildSessionFactory();
        	session=factory.openSession();
        	tr=session.beginTransaction();
        	
    	
        	StudentCompositeKey key=new StudentCompositeKey();
        	key.setFname("Sachin");
        	key.setLname("Tendulkar");
        	
        	Student st = session.load(Student.class,key);
        	
        	System.out.println("City name : "+st.getCity());
        	System.out.println(" Rec : "+st.getId().getFname());
        	
        	tr.commit();
        	
        }catch (Exception e) {
        	tr.rollback();
			e.printStackTrace();
		}finally {
			factory.close();
			session.close();
		}
        
        
        
        
    }
}
