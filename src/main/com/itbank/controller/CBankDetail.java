package main.com.itbank.controller;
import javax.servlet.http.Cookie;

import main.com.itbank.model.*;
import main.com.itbank.object.*;

public class CBankDetail {
	
		
  public AccountDetails[] getAccountDetails(int user_id)
  {
	  MDatabase mdata = new MDatabase();
	  System.out.println("Entering CBankDetail..."+user_id);
	  AccountDetails[] acctdetail = mdata.getAccountDetails(user_id);
	  System.out.println(acctdetail.length);
	  return acctdetail;
  }
	
  public objTransaction[] getTransactionDetails(int user_id)
  {
	  MDatabase mdata = new MDatabase();
	  System.out.println("Entering CBankDetail..."+user_id);
	  
	  objTransaction [] transaction = mdata.getTransactionDetails(user_id);
	  System.out.println(transaction.length);
	  return transaction;
  }
  
  public void createServReq(objServiceRequest servreq)
  {
	  MDatabase mdata = new MDatabase();	  
	  mdata.createServReq(servreq);
  }
  
  public  objServiceRequest [] getServReq(int userid)
  {
	  MDatabase mdata = new MDatabase();
	  objServiceRequest [] servreq = mdata.getServReq(userid);
	  return servreq;
  }
  
  public String getCookieVal(Cookie cookies [],String strName)
	{
		String strValue=new String("default");
		Cookie cookie = null;
		
		if( cookies != null )
		{
	         for (int i = 0; i < cookies.length; i++)
	         {
	            cookie = cookies[i];
	            if (cookie.getName( ).matches(strName))
	            {
	            	strValue = cookie.getValue( );
	            }
	         }
		}

		return strValue;
	}
	
	public void doFundTransfer (int userid, String fromAcctNum, String toAcctNum, String amount)
	{
		AccountDetails[] acctdetail = getAccountDetails(userid);
		AccountDetails updateacctdetails = new AccountDetails();
		objTransaction transaction = new objTransaction();
		double accountbalance =0;
		MDatabase mdata = new MDatabase();
		
		//update from account number
		accountbalance = getAcctBalance(acctdetail,Integer.parseInt(fromAcctNum));
		updateacctdetails.user_id=userid;
		updateacctdetails.accountnumber = Integer.parseInt(fromAcctNum);
		updateacctdetails.balance = accountbalance - Double.parseDouble(amount);
		transaction.acctnum = Integer.parseInt(fromAcctNum);
		transaction.amt = Double.parseDouble(amount);
		transaction.method = "Fund Transfer";
		transaction.type = "Dr";
		mdata.updateAccount(updateacctdetails);
		mdata.setTransaction(transaction, userid);
		
		//update To account number
		updateacctdetails = new AccountDetails();
		transaction = new objTransaction();
		accountbalance = getAcctBalance(acctdetail,Integer.parseInt(toAcctNum));
		updateacctdetails.user_id=userid;
		updateacctdetails.accountnumber = Integer.parseInt(toAcctNum);
		updateacctdetails.balance = accountbalance + Double.parseDouble(amount);
		transaction.acctnum = Integer.parseInt(toAcctNum);
		transaction.amt = Double.parseDouble(amount);
		transaction.method = "Fund Transfer";
		transaction.type = "Cr";
		mdata.updateAccount(updateacctdetails);
		mdata.setTransaction(transaction, userid);
		
	}
	public  boolean isNumeric(String str)  
	{  
	  try  
	  {  
	    Double.parseDouble(str);  
	  }  
	  catch(NumberFormatException nfe)  
	  {  
	    return false;  
	  }  
	  return true;  
	} 
	public double getAcctBalance(AccountDetails[] acctdetails,int acctnumber)
	{
		double balance=0;
		int iCount =0;
		System.out.println("length of account in cBank: "+acctdetails.length);
		
		for(iCount=0;iCount<acctdetails.length;iCount++)
		{
			System.out.println("Inside Loop aacount numbers: "+acctdetails[iCount].accountnumber);
			if (acctdetails[iCount].accountnumber==acctnumber)
			{
				balance=acctdetails[iCount].balance;
				System.out.println("Inside Loop");
			}
		}
		System.out.println("Balance for acctnum"+acctnumber+" is: "+balance);
		return balance;
	}
}
