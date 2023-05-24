package com.DynamiccrudOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSelect1 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jdbc";
			String user="root";
			String password="tiger";
			Connection con = DriverManager.getConnection(url,user,password);
			String query = "SELECT * FROM student WHERE id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, 6);
			ResultSet res = ps.executeQuery();
			System.out.println(res);
			while(res.next()) {
				System.out.print(res.getInt(1)+" ");
				System.out.print(res.getString(2)+" ");
				System.out.print(res.getString(3)+" ");
				System.out.println();
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
