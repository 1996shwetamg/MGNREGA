package com.masai.dao;


import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import com.masai.dto.BDOImpl;
import com.masai.dto.GpmImpl;
import com.masai.dto.Project;
import com.masai.dto.ProjectImpl;
import com.masai.dto.WorkerImpl;
import com.masai.exception.NORecordFoundException;
import com.masai.exception.somethingwentwrongException;

public interface BDOdao{

	public void createproject(Project p) throws SQLException, somethingwentwrongException;	
	public  List<ProjectImpl> getAllProject()throws somethingwentwrongException, NORecordFoundException, ClassNotFoundException;
	public void creategpm(GpmImpl c) throws SQLException, somethingwentwrongException;	
    public List<GpmImpl> getAllGPM()throws somethingwentwrongException, NORecordFoundException;
    public List<WorkerImpl> getAllWorker()throws somethingwentwrongException, NORecordFoundException;
	public String AssignProjectToGPM(int pid, int gid)throws somethingwentwrongException, NORecordFoundException, ClassNotFoundException;
	
//		public List<worker> getAllWorkerByPname(String pname)throws somethingwentwrongException;

}
