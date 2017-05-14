package com.itbank.controller;
import com.itbank.model.*;
import com.itbank.object.*;

public class CLogin {
	
	public int matchPassword (String user_name, String pass)
	{
		int user_id=0; 
		MDatabase mdata = new MDatabase();
		Authentication authen ;
		authen = mdata.getAuthentication(user_name);
		if (authen != null)
		{
			System.out.println(authen.user_id+":"+authen.user_name+":"+authen.password+":"+authen.Role);
			if (pass.matches(authen.password))
			{
				user_id = authen.user_id;
			}
		}
		else
		{
			user_id = -1;
		}
		
		return user_id;
	}
	
  public AccountDetails[] getAccountDetails(int user_id)
  {
	  MDatabase mdata = new MDatabase();
	  System.out.println("Entering CLogin..."+user_id);
	  AccountDetails[] acctdetail = mdata.getAccountDetails(user_id);
	  System.out.println(acctdetail.length);
	  return acctdetail;
  }
	

}
