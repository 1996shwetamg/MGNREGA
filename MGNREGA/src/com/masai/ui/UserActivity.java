package com.masai.ui;


import java.sql.SQLException;
import java.util.Scanner;

import com.masai.dao.GpmDao;
import com.masai.dao.GpmDaoImpl;
import com.masai.exception.NORecordFoundException;
import com.masai.exception.somethingwentwrongException;

import usecases.AssignProjecttoGPM;
import usecases.Createproject;
import usecases.Deleteworker;
import usecases.GetAllGpm;
import usecases.GetAllWorker;
import usecases.RegisterGpm;
import usecases.Viewproject;
import usecases.getEmpByPname;
import usecases.GetWorkers;
import usecases.LoginGpm;
import usecases.RegistarworkerToProject;
import usecases.RegisterWorker;
import usecases.Totalwagepaid;


public class UserActivity {
	public static void selectUser() throws somethingwentwrongException, ClassNotFoundException, SQLException, NORecordFoundException {

		Scanner sc = new Scanner(System.in);

		System.out.println();
		System.out
				.println("Choose an options - \n" + "1. BDO Login\n" + "2. GPM Login\n");

		System.out.println();
		System.out.println("Enter your choice");

		int choice = 0;
		choice = sc.nextInt();

		switch (choice) {
		case 1:
			System.out.println("Enter bdo username");
			String username=sc.next();
			System.out.println("Enter bdo password");
			String password=sc.next();
			if(username.equals("Admin") && password.equals("Admin")) {
				System.out.println("BDO login successful");
				UserActivity.bdo();
			}else {
				System.out.println("Username or password are wrong try again");
				UserActivity.selectUser();
			}
			
			break;
			
		case 2:
			
			UserActivity.gpm();
			break;
		default:
			System.out.println("Invalid choice!");
			System.out.println();

			System.out.println("Try again...");
			UserActivity.selectUser();
		}
	}

	
	public static void bdo() throws somethingwentwrongException, ClassNotFoundException, SQLException, NORecordFoundException {
		Scanner sc=new Scanner(System.in);
		int c=0;
		System.out.println(""
				+ "         1. Create a project\r\n"
				+ "         2. View List Of Project.\r\n"
				+ "         3. Add new Gram Panchayat Member(GPM).\r\n"
				+ "         4. View all the GPM.\r\n"
				+ "         5. Allocate Project to GPM.\r\n"
				+ "         6. get AllWorker.\r\n"
				+ "         7. Go Back");
		
		System.out.println();
		System.out.println("Enter your choice");
		
		
		
		c=sc.nextInt();
		
		switch(c) {
		case 1:
		     Createproject.CProject(sc);
			break;
		case 2:
            Viewproject.viewAllproject();
			break;
		case 3:
			RegisterGpm.RGpm(sc);
			break;
		case 4:
		    GetAllGpm.GAllGpm();
			break;
		case 5:
			AssignProjecttoGPM.ProjecttoGpm();
			break;
		case 6: 
			GetWorkers.getworker();
			break;
	
		case 7:
			UserActivity.selectUser();
			break;
		}
		
		UserActivity.bdo();
			
	
		}
	
	public static void gpm() throws somethingwentwrongException, ClassNotFoundException, SQLException, NORecordFoundException {
		Scanner sc=new Scanner(System.in);
		System.out.println(""
				+ "        1. Login to Grampanchayt please Enter your username and password \r\n"
				+ "        2. Add Worker\r\n"
				+ "        3. See Worker details using aadhar_number\r\n"
				+ "        4. Assign Worker to a Project.\r\n"
				+ "        5. View worker and their total number of days worked in a particular project\r\n"
				+ "        6. View worker and their total wage of worker\r\n"
				+ "        7. Delete worker\r\n"
				+ "        8. Logout\r\n"
				+ "        9. Go back");
		
		System.out.println();
		System.out.println("Enter your choice");
		int c=0;
		
		c=sc.nextInt();
		
		switch(c) {
		case 1:
			LoginGpm.LGpm();
			
			break;
		case 2:
			RegisterWorker.REWorker();
		
			break;
	
			
		case 3:
			GetAllWorker.GWorker();
			break;
		
		
		case 4:
			RegistarworkerToProject.workertoPro();
			break;
		
	    case 5:
	    	
			getEmpByPname.getEmplPname();
		break;
	    case 6:
	    	Totalwagepaid.totalwage();
	    	break;
	    	
	    case 7:
	    	Deleteworker.deleteworker();
	    	break;
	    case 8:
	    	GpmDao dao=new GpmDaoImpl();
	    	dao.logout();
	    	break;
	    case 9:
			UserActivity.selectUser();;
			break;
	}
		
		UserActivity.gpm();
		sc.close();
	}
	
}
