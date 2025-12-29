package com.tca.Ass10;


import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
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

 			configuration=new Configuration(); //
 			
// 			if property file name is different
// 			FileInputStream  fis=new FileInputStream("src/main/resources/tca.properties");
// 		    Properties prop =new Properties();
// 			prop.load(fis);
// 			configuration.setProperties(prop);
 			
 			
 			configuration.addResource("student.cfg.xml");
 			
 			sf=configuration.buildSessionFactory();
 			session=sf.openSession();
 			
 			txn=session.beginTransaction();
 			
 			Student ob=new Student();
 			ob.setRno(2);
 			ob.setName("poonam");
 			ob.setPer(80);
 			
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
