package com.revature.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.ResultSet;

public class BuyItems {
	ViewItems view=new ViewItems();
	Scanner sc=new Scanner(System.in);
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/vlits";
	String username="root";
	String password="sainadh";
	
	public void buyItem() throws SQLException, ClassNotFoundException{
		Class.forName(driver);
		
		Connection conn=DriverManager.getConnection(url, username, password);
		view.viewItems();
		
		Scanner sc=new Scanner(System.in);
		System.out.print("ENTER YOUR NAME: ");
		String name=sc.next();
		
		System.out.print("ENTER PRODUCT ID : ");
		int pid=sc.nextInt();
		
	/*	String sql2="select exists(select * from producttable where product_id=?)";
		PreparedStatement pstmt3=conn.prepareStatement(sql2);
		pstmt3.setInt(1, pid);
		ResultSet value=pstmt3.executeQuery();
		System.out.println(value.next());*/
		
		
		
		
		System.out.println("ENTER QUANTITY : ");
		int quantity=sc.nextInt();
		
		String sql="select * from producttable where product_id=?";
		
		
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, pid);
		
		ResultSet rs= pstmt.executeQuery();
				if(rs.next()) {
				int product_id=rs.getInt("product_id");
				String product_name=rs.getString("product_name");
				int price=rs.getInt("price");
				int stock=rs.getInt("stock");
				double cost=price*quantity;
	
		String sql1="insert into salestable(name,product_id,product_name,price,quantity,total_cost) values(?,?,?,?,?,?)";	
			
		PreparedStatement pstmt1=conn.prepareStatement(sql1);
		pstmt1.setString(1,name);
		pstmt1.setInt(2,pid);
		pstmt1.setString(3,product_name);
		pstmt1.setInt(4,price);
		pstmt1.setInt(5,quantity);
		pstmt1.setDouble(6,cost);
		if(pstmt1.executeUpdate()>0) {
			System.out.println("THANK YOU FOR BUYING ");
		
		
		
		if(quantity>0) {
			int remainingstock=stock-quantity;
			PreparedStatement pstmt2=conn.prepareStatement("update producttable set stock=? where product_id=?");
			pstmt2.setInt(1,remainingstock);
			pstmt2.setInt(2,pid);
			if(pstmt2.executeUpdate()>0) {
				System.out.println("sucessful");
			}
			else {
				System.out.println("THANK YOU FOR COMING");
			}
		}
		
		}
		conn.close();
		rs.close();
			
		}
		
		
	} 
	}


