package usecases;

import java.time.LocalDate;
import java.util.Scanner;

import com.masai.dao.GpmDao;
import com.masai.dao.GpmDaoImpl;
import com.masai.dto.Worker;
import com.masai.dto.WorkerImpl;

public class RegisterWorker {

	public static void REWorker() throws ClassNotFoundException {
		
		     Scanner sc= new Scanner(System.in);
		 
				
				System.out.println("Enter worker aadhar number:");
				String aadhar_no= sc.next();
				
				System.out.println("Enter worker name:");
				String name= sc.next();
				
				System.out.println("Enter worker date_of_birth:");
			    LocalDate dob= LocalDate.parse(sc.next());
				
			    System.out.println("Enter worker gender:");
				String gender= sc.next();
				
				System.out.println("Enter worker panchayat_name:");
				String panchayat_name= sc.next();
				
				System.out.println("Enter worker district:");
				String district= sc.next();
				
				System.out.println("Enter worker state:");
				String state= sc.next();
				
				
				GpmDao dao=new GpmDaoImpl();
				
				
				
				Worker w= new WorkerImpl();
				
				
				w.setAadhar_number(aadhar_no);
				w.setName(name);
				w.setDob(dob);
				w.setGender(gender);
				w.setPanchayat_name(panchayat_name);
				w.setDistrict(district);
				w.setState(state);
			
			

				String result= dao.registerworker(aadhar_no,name,dob,gender,panchayat_name,district,state);
				
				System.out.println(result);
		}
	}


