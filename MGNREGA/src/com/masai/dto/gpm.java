package com.masai.dto;

import java.time.LocalDate;
import java.util.Objects;

public class gpm {
private String aadhar_number;
private String name;
private LocalDate dob;
private String gender;
private String panchayat_name;
private String district;
private String state;
public gpm(String aadhar_number, String name, LocalDate dob, String gender, String panchayat_name, String district,
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
@Override
public int hashCode() {
	return Objects.hash(aadhar_number, district, dob, gender, name, panchayat_name, state);
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	gpm other = (gpm) obj;
	return Objects.equals(aadhar_number, other.aadhar_number) && Objects.equals(district, other.district)
			&& Objects.equals(dob, other.dob) && Objects.equals(gender, other.gender)
			&& Objects.equals(name, other.name) && Objects.equals(panchayat_name, other.panchayat_name)
			&& Objects.equals(state, other.state);
}
@Override
public String toString() {
	return "gpm [aadhar_number=" + aadhar_number + ", name=" + name + ", dob=" + dob + ", gender=" + gender
			+ ", panchayat_name=" + panchayat_name + ", district=" + district + ", state=" + state + "]";
}

}
