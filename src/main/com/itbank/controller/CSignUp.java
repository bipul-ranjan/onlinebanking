package main.com.itbank.controller;
import main.com.itbank.model.*;
import main.com.itbank.object.*;

public class CSignUp {
	public void createCustomer(objSignUp signup)
	{
	
		MDatabase mdata = new MDatabase();
		System.out.println("Calling data base for insert");
		mdata.createCustomer(signup);
		System.out.println("Data Inserted");
	}
	
	public int getUserid (String user_name)
	{
		int user_id=0; 
		MDatabase mdata = new MDatabase();
		Authentication authen ;
		authen = mdata.getAuthentication(user_name);
		if ( authen != null)
		{
			System.out.println(authen.user_id+":"+authen.user_name+":"+authen.password+":"+authen.Role);
			user_id = authen.user_id;	
		}
		else
		{
			user_id = -1;
			System.out.println("Userid not found");
		}
			
		return user_id;
	}
	

}
