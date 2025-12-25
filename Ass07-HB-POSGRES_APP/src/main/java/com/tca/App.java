package com.tca;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.tca.entities.Student;


public class App 
{
    public static void main( String[] args )
    {
    	 Configuration configuration=null;
         SessionFactory sf=null;
         Session session=null;
         Transaction txn=null;
         
         
         try {

 			configuration=new Configuration();
 			configuration.configure();
 			sf=configuration.buildSessionFactory();
 			session=sf.openSession();
 			
 			txn=session.beginTransaction();
 			
 			Student ob=new Student();
 			
// 			ob.setRno(2);
// 			ob.setName("poonam");
// 			ob.setPer(80.00);
 			
 			session.save(ob);
 			
 			txn.commit();
 			System.out.println("Data is saved successfully");
 		} catch (Exception e) {
 			txn.rollback();
 			e.printStackTrace();
 		}
         finally {
 			session.close();
 			sf.close();
 		}

    }
}
