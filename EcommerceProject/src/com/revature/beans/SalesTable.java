package com.revature.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SalesTable {
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/vlits";
	String username="root";
	String password="sainadh";
	public void salesTable(){
	try {
		Class.forName(driver);
		
		Connection conn=DriverManager.getConnection(url, username, password);
		
		String sql=("SELECT * FROM SALESTABLE");
		PreparedStatement pstmt=conn.prepareStatement(sql);
		
			ResultSet rs= pstmt.executeQuery();
			System.out.printf("%-10s %-20s %-15s %-10s %-15s %-10s %-15s\n", "cid", "name", "product_id", "product_name","price","quantity","total_cost");
			while(rs.next()) {
				int cid=rs.getInt("cid");
			    String name=rs.getString("name");
				int product_id=rs.getInt("product_id");
				String product_name=rs.getString("product_name");
				int price=rs.getInt("price");
				int quantity=rs.getInt("quantity");
				double total_cost=rs.getDouble("total_cost");
				
				System.out.printf("%-10d %-20s %-15d %-20s %-15d %-10d %-15f\n",cid,name, product_id, product_name, price, quantity,(float)total_cost);
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
