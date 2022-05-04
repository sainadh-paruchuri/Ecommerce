package com.revature.beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.x.SyncFlushDeflaterOutputStream;

public class DeleteItems {
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/vlits";
	String username="root";
	String password="sainadh";
	public void DeleteItems(){	
	
	try {
		
		Class.forName(driver);
		
		Connection conn=DriverManager.getConnection(url, username, password);
		Scanner sc =new Scanner(System.in);
		
		System.out.println("Enter Product Name you Want To Delete : ");
		String name=sc.next();
		
		String sql=("delete from producttable where product_name=? ");
		
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setString(1,name);
		
		
		int norec=pstmt.executeUpdate();
		if(norec>0) {
			System.out.println("DELETION SUCESSFUL");
		}
		else {
			System.out.println("DELETION FAILED");
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
