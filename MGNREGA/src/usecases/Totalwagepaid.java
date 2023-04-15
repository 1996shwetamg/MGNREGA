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

public class Totalwagepaid {
	public static void totalwage() throws ClassNotFoundException, NORecordFoundException, somethingwentwrongException {
		GpmDao bd = new GpmDaoImpl();
		try {
			List<getWorkerProject_Dto>p=bd.getWorkerandwage();
			p.forEach(s -> {
				System.out.println(
						"<=====================================================================>");
				System.out.println("  |  Worker Name : " + s.getName() + " | Total wage : " + s.getWages()+" | ");
				System.out.println(
						"<=====================================================================>");
			});
		} catch (somethingwentwrongException e) {
			System.out.println(e);
			throw new somethingwentwrongException("Something Went Wrong!");
		}
	}
}
