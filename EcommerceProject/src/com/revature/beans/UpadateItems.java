package com.revature.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpadateItems {
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/vlits";
	String username="root";
	String password="sainadh";
	public void update() {
		try {
			
			Class.forName(driver);
			
			Connection conn=DriverManager.getConnection(url, username, password);
			Scanner sc =new Scanner(System.in);
			
			
			System.out.println("1.PRICE");
			System.out.println("2.STOCK");
			System.out.println("ENTER YOUR CHOICE TO UPDATE : ");
			int choice=sc.nextInt();
			switch(choice) {
			case 1:
				String sql=("UPDATE PRODUCTTABLE SET price=? where product_name=?");
				System.out.print("Enter name of your product that you want to change price :");
				String name=sc.next();
				System.out.print("ENTER UPDATED PRICE : ");
				int price=sc.nextInt();
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1,price);
				pstmt.setString(2,name);
				int norec=pstmt.executeUpdate();
				if(norec>0) {
					System.out.println("UPDATION SUCESSFUL");
				}
				else {
					System.out.println("UPDATION FAILED");
				}
				break;
			case 2:
				String sql1=("UPDATE PRODUCTTABLE SET stock=? where product_name=?");
				System.out.print("Enter name of your product that you want to change stock:");
				String nameProduct=sc.next();
				
				System.out.print("Enter UPDATED STOCK : ");
				int stockProduct=sc.nextInt();
				PreparedStatement pstmt1=conn.prepareStatement(sql1);
				pstmt1.setInt(1,stockProduct);
				pstmt1.setString(2,nameProduct);
				int norecords=pstmt1.executeUpdate();
				if(norecords>0) {
					System.out.println("UPDATION SUCESSFUL");
				}
				else {
					System.out.println("UPDATION FAILED");
				}
				break;
			case 3:
			default:
				System.out.println("INVALID CHOICE ");
				break;
				
				
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
