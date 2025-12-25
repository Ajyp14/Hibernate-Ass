package com.tca;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;

import com.tca.entities.Student;
import com.tca.entities.Teacher;

public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration=null;
        SessionFactory sf=null;
        Session session=null;
        Transaction tr=null;
     //------------------------------------------------------------------------------   
        Configuration pg_configuration=null;
        SessionFactory pg_sf=null;
        Session pg_session=null;
        Transaction pg_tr=null;
        
        try {
        	configuration=new Configuration();
        	configuration.configure("mysql.cfg.xml");
//------------------------------------------------------------------------------   

        	pg_configuration=new Configuration();
        	pg_configuration.configure("pg.cfg.xml");
//------------------------------------------------------------------------------   
    	
        	sf=configuration.buildSessionFactory();
        	session=sf.openSession();
        	tr=session.beginTransaction();
//------------------------------------------------------------------------------   

        	pg_sf=pg_configuration.buildSessionFactory();
        	pg_session=pg_sf.openSession();
           	pg_tr=pg_session.beginTransaction();
//------------------------------------------------------------------------------   
	
        	Student ob=new Student();
        	ob.setRno(111);
        	ob.setName("AAA");
        	ob.setPer(60.00);
        	
        	session.persist(ob);
        	pg_session.persist(ob);
        	
//        	int trno = (int) session.save(ob);
//        	System.out.println(trno);
        	
        	Teacher tob=new Teacher();
        	tob.setSal(5000.0);
        	tob.setTname("XXX");
        	tob.setTno(201);
        	
        	session.persist(tob);
        	pg_session.persist(tob);
        	
        	
        	
        	tr.commit();
        	pg_tr.commit();
        }catch (Exception e) {
        	tr.rollback();
        	pg_tr.rollback();
			e.printStackTrace();
		}
        finally {
        	
        	session.close();
        	sf.close();
        	
        	pg_session.close();
        	pg_sf.close();
			
		}
        
    }
}
