package com.tca.Ass09;

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
			configuration=new Configuration();
			configuration.configure();
			
			sessionFactory= configuration.buildSessionFactory();
			session=sessionFactory.openSession();
			
//			tr=session.beginTransaction();
			
//			Student s= new Student();
//			s.setRno(333);
//			s.setName("ccc");
//			s.setPer(75);
//			
			//session.update(s);
			//session.saveOrUpdate(s);
			//session.delete(s);
			
			
			//reflection
			//Class c=Student.class;
			//c.
			

//Student s1=(Student) session.get(Student.class, 111);
			
			Student s1=(Student) session.load(Student.class, 111);

			System.out.println("roll num : "+s1.getRno());
			System.out.println("Name: "+s1.getName());
			//System.out.println(" per : "+s1.getPer());
			
			
			//Student s2=(Student) session.get(Student.class, 111);

			
			
			
			
//			tr.commit();
		} catch (HibernateException e) {
//			tr.rollback();
			e.printStackTrace();
		}
        finally {
        	session.close();
			sessionFactory.close();
		}
        
        
        
        
    }
}
