/**
 * 
 */
package com.itbank.model;
import java.sql.*;


import com.itbank.object.*;

/**
 * @author bipulranjan_kumar
 *
 */
public class MDatabase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	// TODO Auto-generated method stub
		//MDatabase mdata = new MDatabase();
		/*objSignUp signup = new objSignUp();
		signup.user_name="Bipul";
		signup.password="Bipul";
		signup.firstname="first";
		signup.middlename="middle";
		signup.lastname="last";
		signup.email="email";
		signup.phonenum="Phone";
		signup.add="Address";
		signup.accttype="Saving";
		signup.role="Customer";
		mdata.createCustomer(signup);
		 objTransaction[] transaction=mdata.getTransactionDetails(1);
		 System.out.println("Number of rows in transactions"+transaction.length);*/
		
	}
	// JDBC driver name and database URL
	   static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
	   static final String DB_URL = "jdbc:mysql://bank-application.czv02bjwu53f.ap-south-1.rds.amazonaws.com:3306";
	//  Database credentials
	   static final String USER = "bankapplication";
	   static final String PASS = "bankapplication";
	   
	   
	   private Connection getConnection ()
	   {
		   Connection conn = null;
		   try
		   {
		   	//Register JDBC driver
		      Class.forName(JDBC_DRIVER);

		      //Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }		   
		   return conn;		   
	   }
	   
	   public Authentication getAuthentication(String user_name){
		   Authentication authen = new Authentication();
		   String sql = new String();
		   int iCount = 0;
		   Connection conn = null;
		   Statement stmt = null;
		   try
		   {
			   conn = getConnection();
			 //Execute a query
			   System.out.println("Creating statement...");
			   stmt = conn.createStatement();
			   sql ="SELECT * FROM itbank.authentication where user_name='"+user_name+"'";
			   System.out.println("Creating SQL...:"+sql);
			   ResultSet rs = stmt.executeQuery(sql);
			   iCount = getRowCount(rs);
			   if (iCount >0)
			   {
				   while(rs.next()){
					   authen.user_id = rs.getInt("UserId");
					   authen.user_name = rs.getString("user_name");
					   authen.password = rs.getString("Password");
					   authen.Role=rs.getString("Role");
				   }
				   System.out.println(authen.user_id+":"+authen.user_name+":"+authen.password+":"+authen.Role);
			   }
			   else 
			   {
				   authen = null;
			   }
			   
			   //Cleanup environment
			   rs.close();
			   stmt.close();
			   conn.close();

		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }	
		   return authen;
	   }


	   public AccountDetails[] getAccountDetails(int user_id)
	   {
		   AccountDetails[] acctdetail = new AccountDetails[10];
		   String sql = new String();
		   int iCount=0;
		   Connection conn = null;
		   Statement stmt = null;
		   try
		   {
			   conn = getConnection();
			 //Execute a query
			   System.out.println("Creating statement...");
			   stmt = conn.createStatement();
			   sql ="SELECT * FROM itbank.account where UserID="+user_id;
			   System.out.println("Creating SQL...:"+sql);
			   ResultSet rs = stmt.executeQuery(sql);
			   acctdetail= new AccountDetails[getRowCount(rs)];
			   while(rs.next()){
				   acctdetail[iCount] = new AccountDetails();
				   acctdetail[iCount].accountnumber = rs.getInt("AccountNumber");
				   acctdetail[iCount].user_id = rs.getInt("UserID");
				   acctdetail[iCount].balance = rs.getDouble("Balance");
				   acctdetail[iCount].accttype=rs.getString("AccountType");
				   System.out.println(acctdetail[iCount].accountnumber +":"+acctdetail[iCount].user_id+":"+acctdetail[iCount].balance+":"+acctdetail[iCount].accttype);
				   iCount= iCount+1;
			   }
			   
			   //Cleanup environment
			   rs.close();
			   stmt.close();
			   conn.close();

		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }	
		   
		   
		   return acctdetail;
		   
	   }
	   
	   
	   public objTransaction[] getTransactionDetails(int user_id)
	   {
		   objTransaction[] transaction = new objTransaction[10];
		   String sql = new String();
		   int iCount=0;
		   Connection conn = null;
		   Statement stmt = null;
		   try
		   {
			   conn = getConnection();
			 //Execute a query
			   System.out.println("Creating statement...");
			   stmt = conn.createStatement();
			   sql ="SELECT * FROM itbank.transaction where UserID="+user_id;
			   System.out.println("Creating SQL...:"+sql);
			   ResultSet rs = stmt.executeQuery(sql);
			   transaction= new objTransaction[getRowCount(rs)];
			   while(rs.next())
			   {
				   transaction[iCount] = new objTransaction();
				   transaction[iCount].transid = rs.getInt("transactionid");
				   transaction[iCount].acctnum=rs.getInt("accountnum");
				   transaction[iCount].amt=rs.getDouble("amount");
				   transaction[iCount].type=rs.getString("transactiontype");
				   transaction[iCount].method=rs.getString("method");
				   transaction[iCount].date=rs.getDate("date");
				  iCount= iCount+1;
			   }
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   return transaction;
	   }
	   
	   public void createCustomer (objSignUp signup)
	   {
		   String sql = new String();
		   Authentication authen = new Authentication();
		   Connection conn = null;
		   Statement stmt = null;
		   
		   try
		   {
			   conn = getConnection();
			 //Execute a query
			   System.out.println("Creating statement...");
			   stmt = conn.createStatement();
			   
			   //Insert in authentication table
			   sql="INSERT INTO itbank.authentication (USER_NAME,PASSWORD,ROLE) values(\""+ signup.user_name+"\",\""+signup.password+"\",\"Customer\")";
			   System.out.println("SQL Statement...authentication....:"+sql);
			   stmt.executeUpdate(sql);
			   
			   //Get userid
			   authen = getAuthentication(signup.user_name);
			   //authen = getAuthentication("bipul_ranjan");
			   
			   //Insert in to account
			   sql="INSERT INTO itbank.account(UserID,Balance,AccountType) values ("+authen.user_id+","+Math.round(Math.random()*1000000)+",\""+signup.accttype+"\")";
			   System.out.println("SQL Statement...account....:"+sql);
			   stmt.executeUpdate(sql);
			   
			   //Insert in customer detail
			   sql="INSERT INTO itbank.CUSTOMERDETAIL (USERID,CustomerFirstName,CustomerMiddleName,CustomerLastName,Emailid,Phonenumber,Address) values (";
			   sql = sql + authen.user_id+",\""+signup.firstname+"\",\""+signup.middlename+"\",\""+signup.lastname+"\",\""+signup.email+"\",\""+signup.phonenum+"\",\""+signup.add+"\")";
			   System.out.println("SQL Statement...CUSTOMERDETAIL....:"+sql);
			   stmt.executeUpdate(sql);
			   
			  			   
			 //Cleanup environment
			   stmt.close();
			   conn.close();

		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }	
		   
		   
	   }
	   
	   public void createServReq(objServiceRequest servreq)
	   {
		   String sql = new String();
		   Connection conn = null;
		   Statement stmt = null;
		   
		   try
		   {
			   conn = getConnection();
			 //Execute a query
			   System.out.println("Creating statement...");
			   stmt = conn.createStatement();
			   
			   //Insert in authentication table
			   sql="insert into itbank.servicerequest (userid,acctnumber,description,date) values("+ servreq.userid+","+servreq.acctnum+",\""+servreq.description+"\",CURDATE())";
			   System.out.println("SQL Statement...authentication....:"+sql);
			   stmt.executeUpdate(sql);
		   
		   //Cleanup environment
		   stmt.close();
		   conn.close();
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }			   
	   }
	   
	   public objServiceRequest [] getServReq(int userid)
	   {
		   objServiceRequest [] servreq =new objServiceRequest[10];
		   String sql = new String();
		   int iCount=0;
		   Connection conn = null;
		   Statement stmt = null;
		   try
		   {
			   conn = getConnection();
			 //Execute a query
			   System.out.println("Creating statement...");
			   stmt = conn.createStatement();
			   sql ="SELECT * FROM itbank.servicerequest where USERID="+userid;
			   System.out.println("Creating SQL...:"+sql);
			   ResultSet rs = stmt.executeQuery(sql);
			   servreq= new objServiceRequest[getRowCount(rs)];
			   while(rs.next())
			   {
				   servreq[iCount] = new objServiceRequest();
				   servreq[iCount].requestid = rs.getInt("servicerequestid");
				   servreq[iCount].acctnum=rs.getInt("acctnumber");
				   servreq[iCount].description=rs.getString("description");
				   servreq[iCount].date=rs.getDate("date");
				  iCount= iCount+1;
			   }
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
		   
		   return servreq;
	   }
	   
	   public void setTransaction(objTransaction transaction,int userid)
	   {
		   String sql = new String();
		   Connection conn = null;
		   Statement stmt = null;
		   
		   try
		   {
			   conn = getConnection();
			 //Execute a query
			   System.out.println("Creating statement...");
			   stmt = conn.createStatement();
			   
			   //Insert in authentication table
			   sql="INSERT INTO itbank.transaction (UserID,accountnum,amount,transactiontype,method,date) Values ("+userid+","+transaction.acctnum+","+transaction.amt+",\""+transaction.type+"\",\""+transaction.method+"\",CURDATE())";      
			   System.out.println("SQL Statement...authentication....:"+sql);
			   stmt.executeUpdate(sql);
		   
		   //Cleanup environment
		   stmt.close();
		   conn.close();
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }			   
	   }
	   
	   
	   public void updateAccount(AccountDetails acctdetail)
	   {
		   String sql = new String();
		   Connection conn = null;
		   Statement stmt = null;
		   
		   try
		   {
			   conn = getConnection();
			 //Execute a query
			   System.out.println("Creating statement...");
			   stmt = conn.createStatement();
			   
			   //Insert in authentication table
			   sql="UPDATE itbank.account  set  Balance ="+ acctdetail.balance +"where AccountNumber="+acctdetail.accountnumber+" and UserID ="+acctdetail.user_id; 
			   System.out.println("SQL Statement...authentication....:"+sql);
			   stmt.executeUpdate(sql);
		   
		   //Cleanup environment
		   stmt.close();
		   conn.close();
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }			   
	   }
	   private int getRowCount(ResultSet resultSet) {
		    if (resultSet == null) {
		        return 0;
		    }
		    try {
		        resultSet.last();
		        return resultSet.getRow();
		    } catch (SQLException exp) {
		        exp.printStackTrace();
		    } finally {
		        try {
		            resultSet.beforeFirst();
		        } catch (SQLException exp) {
		            exp.printStackTrace();
		        }
		    }
		    return 0;
		}


}
