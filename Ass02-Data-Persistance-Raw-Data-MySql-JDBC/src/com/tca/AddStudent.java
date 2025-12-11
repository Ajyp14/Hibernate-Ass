package com.tca;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddStudent {

	
	public static void main(String[] args) {
		
		Connection con=null;
		PreparedStatement ps=null;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		try {
			//1,Load Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2 form the connection
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hfb02","root","ajy8805");
			
			System.out.print("entere rno : ");
			int rno=Integer.parseInt(br.readLine());
			
			System.out.print("entere name : ");
			String name=br.readLine();
			
			System.out.print("entere per : ");
			double per=Double.parseDouble(br.readLine());
			
			
			//3. prepare Sql
			ps=con.prepareStatement("insert into student values(?,?,?)");
			ps.setInt(1, rno);
			ps.setString(2, name);
			ps.setDouble(3, per);
			
			//4.Fire Sql
			int i = ps.executeUpdate();
			
			if(i==0)
			{
				System.out.println("failed");
			}
			else
			{
				System.out.println("record save successfully");
			}
			  
			
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		finally {
			
			//5.close connection
			try {
				System.out.println("Connection close 1");
				
				br.close();
				con.close();
				
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		System.out.println("After finnaly");
		

	}

}
