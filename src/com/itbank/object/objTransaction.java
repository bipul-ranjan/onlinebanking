package com.itbank.object;
import java.util.*;
import java.text.SimpleDateFormat;

public class objTransaction {
	
	public int transid;
	public int acctnum;
	public double amt;
	public String type;
	public String method;
	public Date date;
	
	public int getTransId()
	{
		return transid;
	}
	public int getAcctnum()
	{
		return acctnum;
	}
	public double getAmt()
	{
		return amt;
	}
	
	public String getType()
	{
		return type;
	}
	public String getMethod()
	{
		return method;
	}
	
	public String getdate()
	{
		String NEW_FORMAT = "dd-MMM-YYYY";
		SimpleDateFormat sm = new SimpleDateFormat(NEW_FORMAT);

		return sm.format(date);
	}
}
