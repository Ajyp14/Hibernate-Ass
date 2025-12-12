package com.tca.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tca.entities.Student;

public class StudentDaoImpl implements StudenyDao {

	@Override
	public String save(Student ob) {
		
		Connection con = null;
		PreparedStatement ps=null;
		
		final String DB_URL="jdbc:mysql://localhost:3306/hfb02";
		final String DB_USER="root";
		final String DB_PWD="ajy8805";
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
			
			int rno=ob.getRno();
			String name=ob.getName();
			double per=ob.getPer();
			
			ps=con.prepareStatement("insert into student values(?,?,?)");
			ps.setInt(1, rno);
			ps.setString(2, name);
			ps.setDouble(3, per);
			
			
			int i = ps.executeUpdate();
			
			if(i==1)
			{
				return "success";

			}
			else
			{
				return "failed";
			}


		} catch (Exception e) {
			e.printStackTrace();
			return "failed";

		} finally {

			try {
				con.close();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
	}

	
	public List<Student> getAllStudent() {
		
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Student> ls=new ArrayList<>();
		
		final String DB_URL="jdbc:mysql://localhost:3306/hfb02";
		final String DB_USER="root";
		final String DB_PWD="ajy8805";
	
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(DB_URL, DB_USER, DB_PWD);
			
			ps=con.prepareStatement("select * from student");
			
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				//ls.add( new Student(rs.getInt("rno"),rs.getString("name"),rs.getDouble("peer"));
				
				int rno=rs.getInt("rno");
				String name=rs.getString("name");
				double per=rs.getDouble("per");
				
				Student student =new Student();
				
				student.setRno(rno);
				student.setName(name);
				student.setPer(per);
				
				ls.add(student);
			}
	      
			if(ls.isEmpty())
			{
				return null;
			}
			else 
			{
			 return ls;
			}
		
		
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
		finally {
			
			try {
				con.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

}
