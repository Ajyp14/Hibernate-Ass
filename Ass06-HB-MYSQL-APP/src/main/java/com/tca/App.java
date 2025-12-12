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
        Configuration configuration= new Configuration();
        configuration.configure("hibernate.cfg.xml");     //load & parse XML files 
        
        SessionFactory sessionFactory =configuration.buildSessionFactory();
        
        Session session = sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        
        
        
        Student st=new Student();
        st.setRno(102);
        st.setName("vjay");
        st.setPer(75);
        
        session.save(st);
        
        transaction.commit();
        session.close();
        sessionFactory.close();
        System.out.println("data saved successfully");
    }
}

//new Configuration().configure().buildSessionFactory().openSession().beginTransaction();