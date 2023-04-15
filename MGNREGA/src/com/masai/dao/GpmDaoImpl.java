package com.masai.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.GetworkerprojectImpl;
import com.masai.dto.Gpm;
import com.masai.dto.GpmImpl;
import com.masai.dto.Worker;
import com.masai.dto.WorkerImpl;
import com.masai.dto.getWorkerProject_Dto;
import com.masai.exception.NORecordFoundException;
import com.masai.exception.somethingwentwrongException;

public class GpmDaoImpl implements GpmDao{
	
	
	@Override
	public void logout() {
		System.out.println("logged out successfully.....");
	}

	@Override
	public String registerworker(String aadhar_no,String name, LocalDate dob, String gender, String panchayat_name,String district,String state) throws ClassNotFoundException {
		
         String message = "Not Inserted..";
	
		try(Connection conn= DButils.getConnectiontodatabase()) {
			
			PreparedStatement ps= conn.prepareStatement
					("insert into worker(aadhar_number,name,dob,gender,panchayat_name,distric,state) values(?,?,?,?,?,?,?)");
			
			
			ps.setString(1, aadhar_no);
			ps.setString(2, name);
		    ps.setDate(3, Date.valueOf(dob));
			ps.setString(4, gender);
			ps.setString(5, panchayat_name);
			ps.setString(6, district);
			ps.setString(7, state);
			
		int x= ps.executeUpdate();
			
			if(x > 0)
				message = "Worker Registered Sucessfully !";
		
		} catch (SQLException e) {
			message = e.getMessage();
	}
			return message;
	}

	@Override
	public List<WorkerImpl> getAllworker(String aadhar_number) throws  NORecordFoundException, ClassNotFoundException, somethingwentwrongException{
	
		Connection conn=null;
		List<WorkerImpl> list=new ArrayList<>();
		try {
			conn=DButils.getConnectiontodatabase();
			String query="SELECT aadhar_number,name,dob,gender,panchayat_name,distric,state FROM worker where aadhar_number=?";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, aadhar_number);
			
			ResultSet rs=ps.executeQuery();
			
			if(DButils.isResultSetEmpty(rs)) {
				throw new NORecordFoundException("No worker found");
			}
			
			while(rs.next()) {
				list.add(new WorkerImpl(rs.getString(1),rs.getString(2),rs.getDate(3).toLocalDate(),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));	
				
			}
			 
		}catch(ClassNotFoundException | SQLException e){
			throw new somethingwentwrongException("unable to fetch gpm");
		}finally {
			try {
				DButils.closeConnection(conn);
			}catch(SQLException ex) {
				//System.out.println(ex);
			}
		}
		return list;
		
	}

	@Override
	public String registerWorkerToProject(int pid, int eid) throws ClassNotFoundException, somethingwentwrongException{
		
		String message ="Not Resgistered";
		
		
		try(Connection conn= DButils.getConnectiontodatabase()) {
			
		 	PreparedStatement ps= conn.prepareStatement("select * from worker where worker_id =?");
			
		 	ps.setInt(1, eid);
		 	
		 	ResultSet rs= ps.executeQuery();
			
		 	if(rs.next()) {
		 		
		 		PreparedStatement ps2= conn.prepareStatement("select * from project where project_id=?");
		 		
		 		ps2.setInt(1, pid);

		 		ResultSet rs2= ps2.executeQuery();
		 		
		 		if(rs2.next()) {
		 	
		 			PreparedStatement ps3= conn.prepareStatement("insert into worker_project values(?,?)");
		 		
		 			ps3.setInt(1, pid);
		 			ps3.setInt(2, eid);
		 			
		 			int x= ps3.executeUpdate();
		 			
		 			if(x > 0)
		 				message = "Worker registered inside the Project Sucessfully.. ";
		 			else
		 				throw new somethingwentwrongException("Techical error..");
				
		 		}
		 		else
		 			throw new somethingwentwrongException("Invalid Project...");
		
		 	}else
		 		throw new somethingwentwrongException("Invalid Employee...");
		
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}

		return message;
	}

	@Override
	public List<WorkerImpl> getAllworkerbypname(String pname) throws  NORecordFoundException, ClassNotFoundException, somethingwentwrongException{
	
		Connection conn=null;
		List<WorkerImpl> list=new ArrayList<>();
		try {
			conn=DButils.getConnectiontodatabase();
			String query="SELECT w.name AS worker_name, SUM(DATEDIFF(p.end_date, p.start_date) + 1) AS total_days_worked FROM worker w JOIN worker_project wp ON w.worker_id = wp.worker_id JOIN project p ON wp.project_id = p.project_id WHERE w.is_delete = 0 AND p.is_delete = 0 GROUP BY w.worker_id; ";
			PreparedStatement ps=conn.prepareStatement(query);
			ps.setString(1, pname);
			
			ResultSet rs=ps.executeQuery();
			
			if(DButils.isResultSetEmpty(rs)) {
				throw new NORecordFoundException("No worker found");
			}
			
			while(rs.next()) {
				//list.add(new WorkerImpl(rs.getString(1),rs.getInt(2),rs.getDate(3).toLocalDate(),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));	
				System.out.println("Worker Name: "+rs.getString(1));
	    		System.out.println("total_no_of_days_worked on project: "+rs.getInt(2));
			System.out.println("=========================");
			}
			 
		}catch(ClassNotFoundException | SQLException e){
			throw new somethingwentwrongException("unable to fetch gpm");
		}finally {
			try {
				DButils.closeConnection(conn);
			}catch(SQLException ex) {
				//System.out.println(ex);
			}
		}
		return list;
		
		
		
		
		
	}
	
	@Override
	public List<getWorkerProject_Dto> getWorkerandwage() throws  NORecordFoundException, ClassNotFoundException, somethingwentwrongException{
	
		Connection conn = null;
		List<getWorkerProject_Dto> list = new ArrayList<>();
		try {
			conn = DButils.getConnectiontodatabase();
			String query = "SELECT w.name AS worker_name, SUM(DATEDIFF(p.end_date, p.start_date) + 1)*p.per_day_wages AS total_Wages "
					+ "FROM worker w JOIN worker_project wp ON w.worker_id = wp.worker_id JOIN project p ON wp.project_id = p.project_id  "
					+ "WHERE w.is_delete = 0 AND p.is_delete = 0 GROUP BY w.worker_id, p.per_day_wages;";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {
				throw new NORecordFoundException("Not Data Found for Worker projects ");

			} else {
				do {
						 String n = rs.getString(1);
						   Double d = rs.getDouble(2);
						    getWorkerProject_Dto dto = new GetworkerprojectImpl(n, d);
						    list.add(dto);

					
				}
				while (rs.next()) ;
			}
		} catch (SQLException e) {
			throw new somethingwentwrongException("Error occurred while trying to retrieve worker details.");
		} finally {
			try {
				DButils.closeConnection(conn);
			} catch (SQLException ex) {
				// ignore exception
			} finally {
				try {
					DButils.closeConnection(conn);
				} catch (SQLException ex) {

				}
			}
		}
		return list;
	}
		
	

	@Override
	public void deleteworker(int worker_id) throws somethingwentwrongException, ClassNotFoundException {
			

			Connection connection = null;
			try {
				//connect to database
				connection = DButils.getConnectiontodatabase();
				//prepare the query
				String DELETE_QUERY = "DELETE FROM worker WHERE worker_id = ?";
				
				//get the prepared statement object
				PreparedStatement ps = connection.prepareStatement(DELETE_QUERY);
				
				//stuff the data in the query
				ps.setInt(1, worker_id);
				
				//execute query
				ps.executeUpdate();
			}catch(SQLException sqlEx) {
				//code to log the error in the file
				throw new somethingwentwrongException("unable to delete worker");
			}finally {
				try {
					//close the exception
					DButils.closeConnection(connection);				
				}catch(SQLException sqlEX) {
					throw new somethingwentwrongException("");
				}
			}
		}

	@Override
	public List<getWorkerProject_Dto> getWorkerProjects() throws NORecordFoundException, ClassNotFoundException, somethingwentwrongException {
		Connection conn = null;
		List<getWorkerProject_Dto> list = new ArrayList<>();
		try {
			conn = DButils.getConnectiontodatabase();
			String query = "SELECT w.name AS worker_name, SUM(DATEDIFF(p.end_date, p.start_date) + 1) AS total_days_worked FROM worker w JOIN worker_project wp ON w.worker_id = wp.worker_id JOIN project p ON wp.project_id = p.project_id WHERE w.is_delete = 0 AND p.is_delete = 0 GROUP BY w.worker_id; ";
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();

			if (!rs.next()) {
				throw new NORecordFoundException("Not Data Found for Worker projects ");

			} else {
				do {
						 String n = rs.getString(1);
						    int d = rs.getInt(2);
						    getWorkerProject_Dto dto = new GetworkerprojectImpl(n, d);
						    list.add(dto);

					
				}
				while (rs.next()) ;
			}
		} catch (SQLException e) {
			throw new somethingwentwrongException("Error occurred while trying to retrieve worker details.");
		} finally {
			try {
				DButils.closeConnection(conn);
			} catch (SQLException ex) {
				// ignore exception
			} finally {
				try {
					DButils.closeConnection(conn);
				} catch (SQLException ex) {

				}
			}
		}
		return list;
	}

	
	}



