package com.revature.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddItems {
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/vlits";
	String username="root";
	String password="sainadh";
	public void addItems(){	
	
	try {
		
		Class.forName(driver);
		
		Connection conn=DriverManager.getConnection(url, username, password);
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Add  Items");
		System.out.print("Enter product name:");
				String product=sc.nextLine();
				System.out.print("Enter price: ");
				int price=sc.nextInt();
				System.out.print("Enter Stock : ");
				int stock=sc.nextInt();
		
		String sql=("Insert into producttable(product_name,price,stock) values(?,?,?)");
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,product);
		pstmt.setInt(2,price);
		pstmt.setInt(3,stock);
		
		
		int norec=pstmt.executeUpdate();
		if(norec>0) {
			System.out.println("UPDATION SUCESSFUL");
		}
		else {
			System.out.println("SOMETHING WENT WRONG");
		}
		
			
		
		
		
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	}
}



