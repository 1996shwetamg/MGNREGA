package usecases;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

import com.masai.dao.BDOdao;
import com.masai.dao.BDOdaoImpl;
import com.masai.dto.Project;
import com.masai.dto.ProjectImpl;
import com.masai.exception.somethingwentwrongException;

public class Createproject {
	
Scanner sc= new Scanner(System.in);
	public static void CProject(Scanner sc) throws SQLException, somethingwentwrongException{
		
		System.out.println("Enter Project name: ");
		String pname= sc.next();
			
			System.out.println("Enter start date: ");
			LocalDate startdate= LocalDate.parse(sc.next());
			
			System.out.println("Enter end_date: ");
			LocalDate enddate= LocalDate.parse(sc.next());
			
			System.out.println("Enter workers number:");
			int workersnumber= sc.nextInt();
			
			System.out.println("Enter per_day_wage:");
			Float per_day_wages= sc.nextFloat();
		
		
		
		Project p=new ProjectImpl(pname,startdate,enddate,workersnumber,per_day_wages);
		
		BDOdao bd=new BDOdaoImpl();
		
			bd.createproject(p);
			System.out.println("project created successfully");
		}
		
	
	
}