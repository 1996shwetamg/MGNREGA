package usecases;

import java.sql.SQLException;
import java.util.Scanner;

import com.masai.exception.NORecordFoundException;
import com.masai.exception.somethingwentwrongException;
import com.masai.ui.UserActivity;

public class LoginGpm {

	public static void LGpm() throws ClassNotFoundException, somethingwentwrongException, SQLException, NORecordFoundException {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter gpm username");
		String username=sc.next();
		System.out.println("Enter gpm password");
		String password=sc.next();
		if(username.equals("Admin") && password.equals("Admin")) {
			System.out.println("gpm login successful");
			UserActivity.gpm();
		}else {
			System.out.println("Username or password are wrong try again");
			UserActivity.selectUser();
		}
		
	}

}
