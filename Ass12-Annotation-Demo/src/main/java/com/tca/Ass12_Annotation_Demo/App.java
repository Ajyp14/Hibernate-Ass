package com.tca.Ass12_Annotation_Demo;

import org.hibernate.HibernateException;
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
        SessionFactory sessionFactory=null;
        Session session=null;
        Transaction tr=null;
        
        
        try {
        	System.out.println("a1");
			configuration=new Configuration();
        	System.out.println("a2");

        	configuration.configure("hibernate.cfg.xml");
        	System.out.println("a3");

			configuration.addAnnotatedClass(Student.class);
        	System.out.println("a4");

			
			sessionFactory=configuration.buildSessionFactory();
        	System.out.println("a5");

			session=sessionFactory.openSession();
        	System.out.println("a6");

			tr=session.beginTransaction();
        	System.out.println("a7");

					
			Student s1=new Student();
			s1.setRno(101);
//			s1.setName("AJAJ");
			s1.setPer(85.45);

			session.save(s1);
			
			tr.commit();
		} catch (HibernateException e) {
			tr.rollback();
			e.printStackTrace();
		}
        finally {
			session.close();
			sessionFactory.close();
		}
    }
}
