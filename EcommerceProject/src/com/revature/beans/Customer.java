package com.revature.beans;

import java.sql.SQLException;
import java.util.Scanner;

public class Customer {
	UserValidation validation=new UserValidation();
	ViewItems view=new ViewItems();
	BuyItems buyItems=new BuyItems();
	SalesTable sales=new SalesTable();
	
	Scanner sc=new Scanner(System.in);
	public void customerMenu() throws ClassNotFoundException, SQLException {
		System.out.println("1.VIEW ITEMS");
		System.out.println("2.BUy ITEMS");
		System.out.println("3.DISPLAY BUY ITEMS");
		System.out.println("4.EXIT");
		System.out.println("Select Your option : ");
		int customerOption=sc.nextInt();
		switch (customerOption) {
		case 1:
			view.viewItems();
			goBack();
			break;
		case 2:
			buyItems.buyItem();
			goBack();
			break;
			
			
		case 3:
			sales.salesTable();
			goBack();
			break;
		case 4: 
		   validation.validate();
			
			 break;

		default:
			System.out.println("choose correct option ");
			break;
		}
		
		
	
	}
	
	public void goBack() throws ClassNotFoundException, SQLException {
		System.out.println("1.Customer Menu");
		System.out.println("2.Logout");
		System.out.print("choose Your Option : ");
		int n=sc.nextInt();
		switch(n) {
		case 1:
			customerMenu();
		case 2:
			validation.validate();
			break;
		default:
			System.out.println("INVALID CHOICE");
			goBack();
			break;
			
		}
		
	}


}
