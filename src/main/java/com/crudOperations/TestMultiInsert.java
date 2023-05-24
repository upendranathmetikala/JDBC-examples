package com.crudOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestMultiInsert {
    
	public static void main (String [] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jdbc";
			String user="root";
			String password="tiger";
			Connection con = DriverManager.getConnection(url,user,password);
			Statement state = con.createStatement();
			state.addBatch("INSERT INTO student(id,name,email) VALUES(4,'sujith','sui@gmail.com')");
			state.addBatch("INSERT INTO student(id,name,email) VALUES(5,'sunny','sunny@gmail.com')");
			state.addBatch("INSERT INTO student(id,name,email) VALUES(6,'praveen','praveenchandu@gmail.com')");
			int[] res = state.executeBatch();
			state.clearBatch();
			System.out.println(res.length);
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
