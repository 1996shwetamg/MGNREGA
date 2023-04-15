package usecases;

import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;

import com.masai.dao.GpmDao;
import com.masai.dao.GpmDaoImpl;
import com.masai.dto.WorkerImpl;
import com.masai.dto.getWorkerProject_Dto;
import com.masai.exception.NORecordFoundException;
import com.masai.exception.somethingwentwrongException;

public class getEmpByPname {

	public static void getEmplPname() throws somethingwentwrongException, ClassNotFoundException, NORecordFoundException {


	GpmDao bd = new GpmDaoImpl();
	List<getWorkerProject_Dto>p=bd.getWorkerProjects();
	p.forEach(s -> {
		System.out.println(
				"<=====================================================================>");
		System.out.println("  |  Worker Name : " + s.getName() + " | Total Days : " + s.getDays()+" | ");
		System.out.println(
				"<=====================================================================>");
	});
}
}
