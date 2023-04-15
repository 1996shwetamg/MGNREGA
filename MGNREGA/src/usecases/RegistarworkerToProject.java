package usecases;

import java.util.Scanner;

import com.masai.dao.GpmDao;
import com.masai.dao.GpmDaoImpl;

public class RegistarworkerToProject {

	public static void workertoPro() {
Scanner sc= new Scanner(System.in);
		
		System.out.println("Enter the ProjectID");
		int pid= sc.nextInt();

		System.out.println("Enter the workerID");
		int wid= sc.nextInt();
		
		 GpmDao dao=new GpmDaoImpl();
		
		try {
		String result = dao.registerWorkerToProject(pid, wid);
		
		System.out.println(result);
		}catch(Exception e) {
			
			System.out.println(e.getMessage());
			
		}
		
	}

}
