package com.crudOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class TestDelete {

	public static void main(String[] args) {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","tiger");
			System.out.println("connected");
			Statement state = con.createStatement();
			String s="DELETE from student "+"WHERE name='sujeeth'";
			int res = state.executeUpdate(s);
			System.out.println(res);
			con.close();
			
		} catch (SQLException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
