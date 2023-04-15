package com.masai.ui;

import java.sql.SQLException;

import com.masai.exception.NORecordFoundException;
import com.masai.exception.somethingwentwrongException;

public class Main {
public static void main(String[] args) throws somethingwentwrongException, ClassNotFoundException, SQLException, NORecordFoundException {
	System.out.println("------------------------------------");
	System.out.println("        MGNREGA System              ");
	System.out.println("------------------------------------");
	
	UserActivity.selectUser();
}
}
