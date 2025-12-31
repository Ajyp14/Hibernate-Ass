package com.tca.Ass10;



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
         SessionFactory sf=null;
         Session session=null;
         Transaction txn=null;
         
         
         try {

 			configuration=new Configuration();
 			
 			configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
 			configuration.setProperty("hibernate.connection.url","jdbc:mysql://localhost:3306/hfb02");
 			configuration.setProperty("hibernate.connection.user", "root");
 			configuration.setProperty("hibernate.connection.password", "ajy8805");
 			configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
 			configuration.setProperty("hibernate.show_sql", "true");
 			configuration.setProperty("hibernate.hbm2ddl.auto", "create");
 			
 			
 			
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
