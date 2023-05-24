package com.DynamiccrudOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class MultiInsert {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jdbc";
			String user="root";
			String password="tiger";
			Connection con = DriverManager.getConnection(url,user,password);
			Statement state = con.createStatement();
			String query=("INSERT INTO student(id,name,email) VALUES(?,?,?)");
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, 7);
			ps.setString(2, "pavan");
			ps.setString(3, "pavan@gmail.com");
			ps.addBatch();
			ps.setInt(1, 8);
			ps.setString(2, "satish");
			ps.setString(3, "sathish@gmail.com");
			ps.addBatch();
			ps.setInt(1, 9);
			ps.setString(2, "sukumar");
			ps.setString(3, "sukku@gmail.com");
			ps.addBatch();
			int[] res = ps.executeBatch();
			System.out.println(res.length);
			ps.clearBatch();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
