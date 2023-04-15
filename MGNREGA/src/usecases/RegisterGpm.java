package usecases;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import com.masai.dao.BDOdao;
import com.masai.dao.BDOdaoImpl;
import com.masai.dto.GpmImpl;
import com.masai.exception.somethingwentwrongException;

public class RegisterGpm {
Scanner sc=new Scanner(System.in);
	public static void RGpm(Scanner sc) throws SQLException, somethingwentwrongException {
		// TODO Auto-generated method stub
		    System.out.println("Enter aadhar number");
			String adhar=sc.next();
			
			System.out.println("Enter name: ");
			String name=sc.next();
			
			System.out.println("Enter date of birth: ");
			LocalDate dob= LocalDate.parse(sc.next());
			
			System.out.println("Enter gender:");
			String gender= sc.next();
			
			System.out.println("Enter panchayat_name:");
			String panchayat= sc.next();
		
			System.out.println("Enter district:");
			String district= sc.next();
			
			System.out.println("Enter state:");
			String state= sc.next();
		
		GpmImpl g=new GpmImpl(adhar,name,dob,gender,panchayat,district,state);
		
		BDOdao bd=new BDOdaoImpl();
		
			bd.creategpm(g);
			System.out.println("gpm registered successfully");
		}
	}



