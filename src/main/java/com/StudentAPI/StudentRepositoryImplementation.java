package com.StudentAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepositoryImplementation implements StudentRepository {

	@Override
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/jdbc";
			String user="root";
			String password="tiger";
			Connection con = DriverManager.getConnection(url,user,password);
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public String saveStudent(Student s) {
		Connection con = getConnection();
		try {
			String query="INSERT INTO student (id,name,email) VALUES (?,?,?)";
 			PreparedStatement ps = con.prepareStatement(query);
 			ps.setInt(1, s.getId());
 			ps.setString(2, s.getName());
 			ps.setString(3, s.getEmail());
 			int res = ps.executeUpdate();
 			con.close();
 			return "no.of rows added = "+res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String updateStudentById(Student s) {
		Connection con = getConnection();
		try {
			String query="UPDATE student SET name=?,email=? WHERE id=?";
 			PreparedStatement ps = con.prepareStatement(query);
 			ps.setString(1,s.getName() );
 			ps.setString(2,s.getEmail() );
 			ps.setInt(3,s.getId());
 			int res = ps.executeUpdate();
 			con.close();
 			return "no of rows updated "+res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String deleteStudentById(Student s) {
		Connection con = getConnection();
		try {
			String query="DELETE FROM student WHERE id=?";
 			PreparedStatement ps = con.prepareStatement(query);
 			ps.setInt(1, s.getId());
 			int res = ps.executeUpdate();
 			con.close();
 			return "no of rows updated "+res;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Student getStudentId(Student s) {
		Connection con = getConnection();
		try {
			Student s1 = new Student();
			String query="SELECT * FROM student WHERE id=?";
 			PreparedStatement ps = con.prepareStatement(query);
 			ps.setInt(1, s.getId());
 			ResultSet rs = ps.executeQuery();
 			while(rs.next()) {
 				s1.setId(rs.getInt(1));
 				s1.setName(rs.getString(2));
 				s1.setEmail(rs.getString(3));
 			}
 			con.close();
 			return s1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Student> getStudentDetails() {
		List<Student> li = new ArrayList<>();
		Connection con = getConnection();
		try {
			Student s1 = new Student();
			String query="SELECT * FROM student";
 			PreparedStatement ps = con.prepareStatement(query);
 			ResultSet rs = ps.executeQuery();
 			while(rs.next()) {
 				s1.setId(rs.getInt(1));
 				s1.setName(rs.getString(2));
 				s1.setEmail(rs.getString(3));
 				li.add(s1);
 			}
 			con.close();
 			return li;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
