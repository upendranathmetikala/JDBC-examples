package com.DynamiccrudOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class TestDelete {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jdbc";
			String user="root";
			String password="tiger";
			Connection con = DriverManager.getConnection(url,user,password);
			String query = "DELETE FROM student WHERE name=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "sukumar");
			int res = ps.executeUpdate();
			System.out.println(res);
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
