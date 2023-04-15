package usecases;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import com.masai.dao.GpmDao;
import com.masai.dao.GpmDaoImpl;
import com.masai.dto.Worker;
import com.masai.dto.WorkerImpl;
import com.masai.exception.NORecordFoundException;
import com.masai.exception.somethingwentwrongException;

public class GetAllWorker {

	public static void GWorker() throws ClassNotFoundException, NORecordFoundException {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter aadhar_no");
		String aadhar_no=sc.next();
GpmDao dao = new GpmDaoImpl();
		try {
		List<WorkerImpl> listwor= dao.getAllworker(aadhar_no);
		Consumer<Worker> con=prod->System.out.println(" aadhar-number: "+prod.getAadhar_number()+"\n"+" name: "+prod.getName()+"\n"+ " date-of-birth: "+prod.getDob()+"\n"+" gender: "+prod.getGender()+" panchayat_name: "+prod.getPanchayat_name()+"\n"+" district: "+prod.getDistrict()+"\n"+" state: "+prod.getState()+"\n"+"===========================");
		listwor.forEach(con);
			
		}catch(somethingwentwrongException | NORecordFoundException ex) {
			System.out.println(ex);
		}
		
	}

}
