package com.tca.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.tca.entities.Account;

public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration=new Configuration();
        configuration.configure();

        SessionFactory factory=configuration.buildSessionFactory();
        
        Session session=null;
        Transaction tr=null;
        
        Integer senderAccNo=101;
        Integer receiverAccNo=102;

        Double amount=5000.0;
        
        
        try {
        	
        	session=factory.openSession();
//        	tr=session.beginTransaction();
        	
        	Account sender=session.get(Account.class,senderAccNo);
        	
        	if(sender==null)
        	{
        		System.out.println("Invalid sender Account number : "+senderAccNo);
        		return;
        	}
        	if(sender.getBalance() < amount)
        	{
        		System.out.println("insufficient balance ");
        		return;
        	}
        	sender.setBalance(sender.getBalance() - amount);
//        	session.update(sender);
        	
//        	double ans=22/0;         //Exception   
        	
        	Account reciver=session.get(Account.class,receiverAccNo);
        	
        	if(reciver==null)
        	{
        		System.out.println("Invalid reciver Account number : "+receiverAccNo);
        		return;
        	}
            reciver.setBalance(reciver.getBalance() + amount);
        
            

            
        	try {
        		 tr=session.beginTransaction();
             	
                 session.update(sender);
                 double ans=22/0;
             	 session.update(reciver);    
             	
				tr.commit();
			} catch (Exception e) {
				
	        	tr.rollback();
	        	System.out.println("Rool back catch");
			}
//            double ans=22/0;

        	
        	System.out.println("Money transfer successfull");
        	
        }catch (Exception e) {
//        	tr.rollback();
			e.printStackTrace();
        	System.out.println("Money transfer failed");

		}finally {
			session.close();
			factory.close();
		}
    
        
    }
}
