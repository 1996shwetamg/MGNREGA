package com.masai.dto;

import java.time.LocalDate;
import java.util.Objects;

public class ProjectImpl implements Project{
private String project_name;
private LocalDate start_date;
private LocalDate end_date;
private int workers_number;
private float per_day_wages;
public ProjectImpl(String project_name, LocalDate start_date, LocalDate end_date, int workers_number, float per_day_wages) {
	super();
	this.project_name = project_name;
	this.start_date = start_date;
	this.end_date = end_date;
	this.workers_number = workers_number;
	this.per_day_wages = per_day_wages;
}
public ProjectImpl() {
	// TODO Auto-generated constructor stub
}
public String getProject_name() {
	return project_name;
}
public void setProject_name(String project_name) {
	this.project_name = project_name;
}
public LocalDate getStart_date() {
	return start_date;
}
public void setStart_date(LocalDate start_date) {
	this.start_date = start_date;
}
public LocalDate getEnd_date() {
	return end_date;
}
public void setEnd_date(LocalDate end_date) {
	this.end_date = end_date;
}
public int getWorkers_number() {
	return workers_number;
}
public void setWorkers_number(int workers_number) {
	this.workers_number = workers_number;
}
public float getPer_day_wages() {
	return per_day_wages;
}
public void setPer_day_wages(float per_day_wages) {
	this.per_day_wages = per_day_wages;
}


}
