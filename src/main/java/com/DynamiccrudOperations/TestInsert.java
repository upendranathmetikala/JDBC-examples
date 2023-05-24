package com.DynamiccrudOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestInsert {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jdbc";
			String user="root";
			String password="tiger";
			Connection con = DriverManager.getConnection(url,user,password);
			String query = "INSERT INTO student VALUES (?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1,7);
			ps.setString(2,"rajesh");
			ps.setString(3,"rajesh@gmail.com");
			int res = ps.executeUpdate();
			System.out.println(res);
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
