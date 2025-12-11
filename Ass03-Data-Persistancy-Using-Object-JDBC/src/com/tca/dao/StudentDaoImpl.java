package com.tca.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

}
