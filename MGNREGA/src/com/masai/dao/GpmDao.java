package com.masai.dao;

import java.time.LocalDate;
import java.util.List;

import com.masai.dto.WorkerImpl;
import com.masai.dto.getWorkerProject_Dto;
import com.masai.exception.NORecordFoundException;
import com.masai.exception.somethingwentwrongException;

public interface GpmDao {
	
	public String registerworker(String aadhar_no,String name, LocalDate dob, String gender, String panchayat_name,String district,String state) throws ClassNotFoundException;
	public List<WorkerImpl> getAllworker(String aadhar_number) throws  NORecordFoundException, ClassNotFoundException, somethingwentwrongException;
	public List<WorkerImpl> getAllworkerbypname(String pname) throws  NORecordFoundException, ClassNotFoundException, somethingwentwrongException;
	public String registerWorkerToProject(int pid, int eid)throws somethingwentwrongException, ClassNotFoundException;
	//public List<getWorkerProject_Dto> getworkerandwage() throws  NORecordFoundException, ClassNotFoundException, somethingwentwrongException;
	public void deleteworker(int worker_id) throws somethingwentwrongException, ClassNotFoundException;
	void logout();
	public List<getWorkerProject_Dto> getWorkerProjects() throws NORecordFoundException, ClassNotFoundException, somethingwentwrongException;
	public List<getWorkerProject_Dto> getWorkerandwage() throws NORecordFoundException, ClassNotFoundException, somethingwentwrongException ;
}
