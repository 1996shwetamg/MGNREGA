package com.masai.dto;

import java.time.LocalDate;
import java.util.Objects;

public class project {
private String project_name;
private LocalDate start_date;
private LocalDate end_date;
private int workers_number;
private float per_day_wages;
public project(String project_name, LocalDate start_date, LocalDate end_date, int workers_number, float per_day_wages) {
	super();
	this.project_name = project_name;
	this.start_date = start_date;
	this.end_date = end_date;
	this.workers_number = workers_number;
	this.per_day_wages = per_day_wages;
}
public project() {
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
@Override
public int hashCode() {
	return Objects.hash(end_date, per_day_wages, project_name, start_date, workers_number);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	project other = (project) obj;
	return Objects.equals(end_date, other.end_date)
			&& Float.floatToIntBits(per_day_wages) == Float.floatToIntBits(other.per_day_wages)
			&& Objects.equals(project_name, other.project_name) && Objects.equals(start_date, other.start_date)
			&& workers_number == other.workers_number;
}
@Override
public String toString() {
	return "project [project_name=" + project_name + ", start_date=" + start_date + ", end_date=" + end_date
			+ ", workers_number=" + workers_number + ", per_day_wages=" + per_day_wages + "]";
}

}
