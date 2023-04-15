package com.masai.dao;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.masai.dto.BDOImpl;
import com.masai.dto.GpmImpl;
import com.masai.dto.Project;
import com.masai.dto.ProjectImpl;
import com.masai.dto.WorkerImpl;
import com.masai.exception.NORecordFoundException;
import com.masai.exception.somethingwentwrongException;

public class BDOdaoImpl implements BDOdao{

	@Override
	public void createproject(Project c) throws SQLException, somethingwentwrongException {
		Connection conn=null;
		try {
			conn=DButils.getConnectiontodatabase();
			
			String query="insert into project(project_name,start_date,end_date,workers_number,per_day_wages) values(?,?,?,?,?)";
					
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			ps.setString(1, c.getProject_name());
			ps.setDate(2, Date.valueOf(c.getStart_date()));
			ps.setDate(3, Date.valueOf(c.getEnd_date()));
			ps.setInt(4, c.getWorkers_number());
			ps.setFloat(5, c.getPer_day_wages());
			
			ps.executeUpdate();
			
		}catch(ClassNotFoundException e) {
			throw new somethingwentwrongException("unable to insert project");
		}finally {
			try {
				DButils.closeConnection(conn);
			}catch(SQLException e) {
				System.out.println(e);
			}
		}
	}
	
	@Override
	public  List<ProjectImpl> getAllProject()throws somethingwentwrongException, NORecordFoundException, ClassNotFoundException{
		Connection connection = null;
		List<ProjectImpl> list = new ArrayList<>();
		try {
			
			connection = DButils.getConnectiontodatabase();
			
			String SELECT_QUERY = "SELECT project_name,start_date,end_date,workers_number,per_day_wages FROM project";
			
			
			PreparedStatement ps = connection.prepareStatement(SELECT_QUERY);
		
		
			ResultSet rs = ps.executeQuery();
			
			
			if(DButils.isResultSetEmpty(rs)) {
				throw new NORecordFoundException("No project Found");
			}
			while(rs.next()) {
				list.add(new ProjectImpl(rs.getString(1),rs.getDate(2).toLocalDate(),rs.getDate(3).toLocalDate(),rs.getInt(4),rs.getFloat(5)));	
			}
			
		}catch(ClassNotFoundException |SQLException sqlEx) {
			throw new somethingwentwrongException("unable to fetch project");
		}finally {
			try {
				
				DButils.closeConnection(connection);				
			}catch(SQLException sqlEX) {
				
			}
		}return list;
			
	
	}
	@Override
	public void creategpm(GpmImpl c) throws SQLException, somethingwentwrongException {
		Connection conn=null;
		try {
			conn=DButils.getConnectiontodatabase();
			
			String query="insert into gpm(aadhar_number,name,dob,gender,panchayat_name,distric,state) values(?,?,?,?,?,?,?)";
					
			
			PreparedStatement ps=conn.prepareStatement(query);
			
			ps.setString(1, c.getAadhar_number());
			ps.setString(2, c.getName());
			ps.setDate(3, Date.valueOf(c.getDob()));
			ps.setString(4, c.getGender());
			ps.setString(5, c.getPanchayat_name());
			ps.setString(6, c.getDistrict());
			ps.setString(7, c.getState());
			
			ps.executeUpdate();
			
		}catch(ClassNotFoundException e) {
			throw new somethingwentwrongException("unable to insert gpm");
		}finally {
			try {
				DButils.closeConnection(conn);
			}catch(SQLException e) {
				System.out.println(e);
			}
		}
	}
	@Override
	public List<GpmImpl> getAllGPM()throws somethingwentwrongException, NORecordFoundException{
		
				Connection conn=null;
				List<GpmImpl> list=new ArrayList<>();
				try {
					conn=DButils.getConnectiontodatabase();
					String query="SELECT aadhar_number,name,dob,gender,panchayat_name,distric,state FROM gpm";
					PreparedStatement ps=conn.prepareStatement(query);
					
					
					ResultSet rs=ps.executeQuery();
					
					if(DButils.isResultSetEmpty(rs)) {
						throw new NORecordFoundException("No gpm found");
					}
					
					while(rs.next()) {
						list.add(new GpmImpl(rs.getString(1),rs.getString(2),rs.getDate(3).toLocalDate(),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7)));	
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
	public List<WorkerImpl> getAllWorker()throws somethingwentwrongException, NORecordFoundException{
		
				Connection conn=null;
				List<WorkerImpl> list=new ArrayList<>();
				try {
					conn=DButils.getConnectiontodatabase();
					String query="SELECT aadhar_number,name,dob,gender,panchayat_name,distric,state FROM worker";
					PreparedStatement ps=conn.prepareStatement(query);
					
					
					ResultSet rs=ps.executeQuery();
					
					if(DButils.isResultSetEmpty(rs)) {
						throw new NORecordFoundException("No gpm found");
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
		public String AssignProjectToGPM(int pid, int gid) throws somethingwentwrongException, NORecordFoundException, ClassNotFoundException{ {
			String massage="Not allocated";
			

		try(Connection conn= DButils.getConnectiontodatabase()) {
				
			 	PreparedStatement ps= conn.prepareStatement("select * from project where project_id =?");
				
			 	ps.setInt(1, pid);
			 	
			 	ResultSet rs= ps.executeQuery();
				
			 	if(rs.next()) {
			 		
			 		PreparedStatement ps2= conn.prepareStatement("select * from gpm where gpm_id=?");
			 		
			 		ps2.setInt(1, gid);

			 		ResultSet rs2= ps2.executeQuery();
			 		
			 		if(rs2.next()) {
			 	
			 			PreparedStatement ps3= conn.prepareStatement("insert into gpm_project values(?,?)");
			 		
			 			ps3.setInt(1, pid);
			 			ps3.setInt(2, gid);
			 			
			 			int x= ps3.executeUpdate();
			 			
			 			if(x > 0)
			 				massage = "Project registered inside the Gpm Sucessfully.. ";
			 			else
			 				throw new somethingwentwrongException("Techical error..");
					
			 		}
			 		else
			 			throw new somethingwentwrongException("Invalid project id and  gpmid...");
			
			 	}else
			 		throw new somethingwentwrongException("Invalid gpm id...");
			
			} catch (SQLException e) {
				throw new  somethingwentwrongException(e.getMessage());
			}

			return massage;
		}
	}
	
}
