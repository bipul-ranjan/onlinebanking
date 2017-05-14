package com.itbank.object;
import java.util.*;
import java.text.SimpleDateFormat;

public class objServiceRequest {
	
	public int requestid;
	public int userid;
	public int acctnum;
	public String description;
	public Date date;
	
	public int getRequestid()
	{
		return requestid;
	}
	public int getAcctnum()
	{
		return acctnum;
	}
	public String getDescription()
	{
		return description;
	}
		
	public String getdate()
	{
		String NEW_FORMAT = "dd-MMM-YYYY";
		SimpleDateFormat sm = new SimpleDateFormat(NEW_FORMAT);

		return sm.format(date);
	}
}
