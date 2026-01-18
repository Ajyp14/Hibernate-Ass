package com.tca.ASS14_Transient_Demo;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.tca.entities.Student;

/**
 * Hello world!
 *
 */
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
        	st.setRno(222);
        	st.setName("Anjhg");
        	st.setPer(77.77);
        	//st.setEmail("ajajaja@1234");

        	
        	session.save(st);
        	
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
