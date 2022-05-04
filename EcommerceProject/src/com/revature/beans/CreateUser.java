package com.revature.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class CreateUser {
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/vlits";
	String username="root";
	String password="sainadh";
	public void createUser(){	
	
	try {
		
		Class.forName(driver);
		
		Connection conn=DriverManager.getConnection(url, username, password);
		Scanner sc =new Scanner(System.in);
		System.out.print("ENTER USERNAME : ");
		String user=sc.next();
		System.out.print("ENTER PASSWORD : ");
		String pass=sc.next();
		System.out.print("ENTER ROLE : ");
		String rol=sc.next();
		
		
		String sql=("Insert into user values(?,?,?)");
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,user);
		pstmt.setString(2,pass);
		pstmt.setString(3,rol);
		
		
		int norec=pstmt.executeUpdate();
		if(norec>0) {
			System.out.println("USER CREATED SUCESSFUL");
		}
		else {
			System.out.println("USER CREATION FAILEDs");
		}
		
			
		
		conn.close();
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	}

}
