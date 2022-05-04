package com.revature.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ViewItems {
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/vlits";
	String username="root";
	String password="sainadh";
	public void viewItems(){
	try {
		Class.forName(driver);
		
		Connection conn=DriverManager.getConnection(url, username, password);
		
		String sql=("SELECT * FROM PRODUCTTABLE");
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
			ResultSet rs= pstmt.executeQuery();
			System.out.printf("%-10s %-20s %-15s %-10s\n", "product_id", "product_name", "price", "stock");
			while(rs.next()) {
				int product_id=rs.getInt("product_id");
				String product_name=rs.getString("product_name");
				int price=rs.getInt("price");
				int stock=rs.getInt("stock");
				
//				System.out.println(product_id+" "+product_name+" "+price+" "+stock);
				System.out.printf("%-10d %-20s %-15d %-10d\n", product_id, product_name, price, stock);
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

