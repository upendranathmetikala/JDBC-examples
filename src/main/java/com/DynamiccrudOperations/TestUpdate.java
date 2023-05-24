package com.DynamiccrudOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestUpdate {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jdbc";
			String user="root";
			String password="tiger";
			Connection con = DriverManager.getConnection(url,user,password);
			String query = "UPDATE student SET email=? WHERE name=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "rajeshkumar@gmail.com");
			ps.setString(2, "rajesh");
			int res = ps.executeUpdate();
			System.out.println(res);
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
