package com.revature.beans;
import java.util.Scanner;
import com.revature.beans.ViewItems;



public class Admin {
	UserValidation validation=new UserValidation();
	ViewItems view=new ViewItems();
	AddItems items=new AddItems();
	UpadateItems update=new UpadateItems();
	DeleteItems delete=new DeleteItems();
	CreateUser create=new CreateUser();
	
	Scanner sc=new Scanner(System.in);
	public void adminMenu() {
		System.out.println("");
		System.out.println("ADMIN MENU");
		System.out.println("\n");
		System.out.println("1.VIEW ITEMS");
		System.out.println("2.ADD ITEMS");
		System.out.println("3.UPDATE ITEMS");
		System.out.println("4.DELETE ITEMS");
		System.out.println("5.CREATE USER");
		System.out.println("\n");
		System.out.print("Select your Option : ");
		int adminOption=sc.nextInt();
		switch(adminOption) {
		case 1:
			    System.out.println("\n");
				view.viewItems();
				System.out.println("\n");
				goBack();
				break;
		case 2:
			System.out.print("\n");
			items.addItems();
			System.out.print("\n");
			goBack();
			break;
		case 3:
			System.out.print("\n");
			update.update();
			System.out.print("\n");
			goBack();
			break;
		case 4:
			System.out.print("\n");
			delete.DeleteItems();
			System.out.print("\n");
			goBack();
			break;
		case 5:
			System.out.print("\n");
			create.createUser();
			System.out.print("\n");
			goBack();
			break;
		default:
			System.out.println("INVALID CHOICE");
			adminMenu();
			
			
		}
		
	}
	
	public void goBack() {
		System.out.println("1.Admin Menu");
		System.out.println("2.Logout");
		System.out.println("\n");
		System.out.print("choose Your Option : ");
		int n=sc.nextInt();
		switch(n) {
		case 1:
			adminMenu();
			break;
		case 2:
			validation.validate();
			break;
		default:
			System.out.println("INVALID CHOICE");
			goBack();
			System.out.println("\n");
			break;
			
		}
		
	}

	
	
}