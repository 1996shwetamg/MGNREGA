package usecases;


import java.util.List;
import java.util.function.Consumer;

import com.masai.dao.BDOdao;
import com.masai.dao.BDOdaoImpl;
import com.masai.dto.Project;
import com.masai.dto.ProjectImpl;
import com.masai.exception.NORecordFoundException;
import com.masai.exception.somethingwentwrongException;

public class Viewproject {

public static void viewAllproject() throws somethingwentwrongException, NORecordFoundException, ClassNotFoundException {
	
	 BDOdao bd=new BDOdaoImpl();
		
		try {
			List<ProjectImpl> projectlist=bd.getAllProject();
			Consumer<Project> con=pro->System.out.println(" project name: "+pro.getProject_name()+"\n"+" start_date: "+pro.getStart_date()+"\n"+" end_date: "+pro.getEnd_date()+"\n"+" workers_number: "+pro.getWorkers_number()+"\n"+" per_day_wages: "+pro.getPer_day_wages()+"\n"+"=================================");
			projectlist.forEach(con);
			
		} catch (somethingwentwrongException  | NORecordFoundException e) {
			System.out.println(e.getMessage());
		}
}
}

