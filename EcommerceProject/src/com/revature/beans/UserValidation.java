package com.revature.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserValidation {
	public void validate() {
		Admin admin=new Admin();
		Customer customer=new Customer();
		String driver="com.mysql.cj.jdbc.Driver";
		String url="jdbc:mysql://localhost:3306/vlits";
		String username="root";
		String password="sainadh";
		
		try {
			
			Class.forName(driver);
			
			Connection conn=DriverManager.getConnection(url, username, password);
			System.out.println("=============================WELCOME=================================");
			System.out.print("\n");
			
			String sql=("SELECT ROLE FROM user WHERE username=? and password=?");
			PreparedStatement pstmt=conn.prepareStatement(sql);
			
			Scanner sc=new Scanner(System.in);
			System.out.print("USERNAME : ");
			String username1=sc.next();
			System.out.print("PASSWORD : ");
			String password1=sc.next();
			pstmt.setString(1,username1);
			pstmt.setString(2, password1);
			System.out.print("\n");
			

			ResultSet rs= pstmt.executeQuery();
			
			if(rs.next()) {
				//String password2=rs.getString("password");
				String role=rs.getString("role");
				if(role.equals("admin")) {
					admin.adminMenu();
					
					
				}
				else if(role.equals("customer")) {
					customer.customerMenu();
				}
					
				else {
					System.out.println("INVALID ROLE");
					validate();
				}
			}
			else {
				System.out.println("USER NOT VALID");
				validate();
			}
			conn.close();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
