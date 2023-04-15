package com.masai.dto;

import java.time.LocalDate;
import java.util.Objects;

public class GpmImpl implements Gpm{
private String aadhar_number;
private String name;
private LocalDate dob;
private String gender;
private String panchayat_name;
private String district;
private String state;
public GpmImpl(String aadhar_number, String name, LocalDate dob, String gender, String panchayat_name, String district,
		String state) {
	super();
	this.aadhar_number = aadhar_number;
	this.name = name;
	this.dob = dob;
	this.gender = gender;
	this.panchayat_name = panchayat_name;
	this.district = district;
	this.state = state;
}
@Override
public String getAadhar_number() {
	return aadhar_number;
}
public void setAadhar_number(String aadhar_number) {
	this.aadhar_number = aadhar_number;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public LocalDate getDob() {
	return dob;
}
public void setDob(LocalDate dob) {
	this.dob = dob;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getPanchayat_name() {
	return panchayat_name;
}
public void setPanchayat_name(String panchayat_name) {
	this.panchayat_name = panchayat_name;
}
public String getDistrict() {
	return district;
}
public void setDistrict(String district) {
	this.district = district;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}

}
