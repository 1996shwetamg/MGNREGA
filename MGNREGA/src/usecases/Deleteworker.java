package usecases;

import java.util.Scanner;

import com.masai.dao.GpmDao;
import com.masai.dao.GpmDaoImpl;
import com.masai.exception.NORecordFoundException;
import com.masai.exception.somethingwentwrongException;

public class Deleteworker {

	public static void deleteworker() throws somethingwentwrongException, NORecordFoundException, ClassNotFoundException {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter worker id ");
		int workerId = sc.nextInt();
		GpmDao dao=new GpmDaoImpl();
		dao.deleteworker(workerId);
		System.out.println("worker deleted successfully");
		
	}

}
