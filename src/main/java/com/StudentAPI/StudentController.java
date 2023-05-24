package com.StudentAPI;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class StudentController {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		StudentRepositoryImplementation r = new StudentRepositoryImplementation();
		Connection con = r.getConnection();
		if(con!=null) {
			System.out.println("working");
		}
		else {
			System.out.println("something went wrong");
		}
		
		Student s = new Student();
		s.setId(9);
		//s.setName("anjan");
		//s.setEmail("anjan@gmail.com");
		List<Student> res = r.getStudentDetails();		
	}

}
