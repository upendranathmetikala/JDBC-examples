package com.StudentAPI;

import java.sql.Connection;
import java.util.List;

public interface StudentRepository {
	public Connection getConnection();
	public String saveStudent(Student s);
	public String updateStudentById(Student s);
	public String deleteStudentById(Student s);
	public Student getStudentId(Student s);
	public List<Student> getStudentDetails();
}
