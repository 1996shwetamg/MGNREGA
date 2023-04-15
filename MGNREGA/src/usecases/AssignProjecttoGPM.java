package usecases;

import java.util.Scanner;

import com.masai.dao.BDOdao;
import com.masai.dao.BDOdaoImpl;

public class AssignProjecttoGPM {
	public static void ProjecttoGpm() {
		
		Scanner sc= new Scanner(System.in);
			
			System.out.println("Enter the project id ");
			int eid= sc.nextInt();

			System.out.println("Enter the  Gpm id ");
			int pid= sc.nextInt();
			
			 BDOdao dao=new BDOdaoImpl();
			
			try {
			String result = dao.AssignProjectToGPM(eid, pid);
			
			System.out.println(result);
			}catch(Exception e) {
				
				System.out.println(e.getMessage());
				
			}
}
}
