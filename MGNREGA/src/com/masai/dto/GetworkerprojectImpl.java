package com.masai.dto;

public class GetworkerprojectImpl implements getWorkerProject_Dto{
	private String name;
	   private int days;
	   private double wages;
	public GetworkerprojectImpl(String name, int days) {
		super();
		this.name = name;
		this.days = days;
	}

	public GetworkerprojectImpl(String name, double wages) {
		super();
		this.name = name;
		this.wages = wages;
	}

	public GetworkerprojectImpl() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	@Override
	public String toString() {
		return "name=" + name + ", days=" + days + "\n";
	}

	public double getWages() {
		return wages;
	}

	public void setWages(double wages) {
		this.wages = wages;
	}
}
