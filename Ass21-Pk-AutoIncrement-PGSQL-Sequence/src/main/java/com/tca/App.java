package com.tca;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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
         Transaction tx=null;
         
         
         try {
         	configuration=new Configuration();
         	configuration.configure();
         	
         	factory=configuration.buildSessionFactory();
         	session=factory.openSession();
         	tx= session.beginTransaction();
         	
         	Student st=new Student();
         	st.setName("EEEE");
         	st.setPer(50.45);
         	
         	session.persist(st);
         	
         	int trno=(int) session.getIdentifier(st);
         	
         	System.out.println("Trno : "+trno);
         	
         	tx.commit();
         	
         }catch (Exception e) {
         	tx.rollback();
         	e.printStackTrace();
 			
 		}finally {
 			session.close();
 			factory.close();
 		}
     }
}
