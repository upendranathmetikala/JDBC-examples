package com.metaresultset;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MetaResultSet {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/rev_db","root","tiger");
			System.out.println("write the query");
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			Statement statement = con.createStatement();
			boolean res = statement.execute(br.readLine());
			if(res) {
				ResultSet set = statement.getResultSet();
				ResultSetMetaData metaData = set.getMetaData();
				int count = metaData.getColumnCount();
				String name = metaData.getColumnName(count);
				System.out.println("column count "+count);
				while(set.next()) {
					for(int i=1; i<=count;i++) {
						System.out.println(metaData.getColumnName(i)+" of the employee is "+set.getObject(i));
	//					System.out.println(set.getObject(2));
	//					System.out.println(set.getObject(3));
	//					System.out.println(set.getObject(4));
					}
				}
			}
			System.out.println("db operation successfull");
			con.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
