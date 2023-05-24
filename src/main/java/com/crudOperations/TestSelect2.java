package com.crudOperations;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TestSelect2 {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			FileInputStream f = new FileInputStream("mydbinfo.properties");
			Properties p = new Properties();
			p.load(f);
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc","root","tiger");
			System.out.println("connected");
			Statement state = con.createStatement();
			String s="SELECT * FROM student"+" WHERE name='suresh'";
			ResultSet rs = state.executeQuery(s);
			System.out.println(rs);
			while(rs.next()) {
				System.out.print(rs.getInt(1)+" ");
				System.out.print(rs.getString(2)+" ");
				System.out.print(rs.getString(3)+" ");
				System.out.println();
			}
			con.close();
		} catch (ClassNotFoundException | SQLException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
