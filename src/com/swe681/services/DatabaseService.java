package com.swe681.services;

import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;


public class DatabaseService {
	String connectionString = "jdbc:mysql://swe645assignment4.cxfdxaz2eghd.us-east-1.rds.amazonaws.com:3306/swe645assignment4";
	String userName = "kdighe_swe645";
	String password = "kdighe_swe645";
	
	protected Connection createDbConnection( String connectionString,String  userName, String password) 
	{
		Connection con = null;
		System.out.println("---Connection String is -------"+connectionString);
		System.out.println("------Creating RDS MySQL connection-------");
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(connectionString, userName, password);
		} 
		catch (Exception e) 
		{
			System.out.println("------Error connecting-------");
			e.printStackTrace();
		}
		return con;
	}
	
	public void insertNewSession(String sessionID)
	{
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		
		conn = createDbConnection(connectionString,userName,password);
		
		try {
			preparedStatement = conn.prepareStatement("INSERT INTO swe645assignment4.sessions VALUES(?,?)");
			preparedStatement.setString(1, sessionID);
			preparedStatement.setString(2,"ACTIVE");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
	public ArrayList<String> getAllActiveSessions()
	{
		Connection conn = null;
		PreparedStatement statement;
		ArrayList<String> sessionlist = new ArrayList<String>();
		String selectQuery = "SELECT * FROM swe645assignment4.sessions; ";
		conn = createDbConnection(connectionString,userName,password);
		
		ResultSet rs;
		try {
			statement = conn.prepareStatement(selectQuery);
			rs = statement.executeQuery();
			while(rs.next())
			{
				sessionlist.add(rs.getString("sessionid"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
			return sessionlist;
	}
	
	public int InsertUser(String email, String firstName, String lastName, String uName, String pword)
	{

		
		Connection conn = null;
		String insertQuery = "";
		int row  = 0;
		System.out.println("-----------------In InsertStudentDetails function-------------------");
		PreparedStatement preparedStamenet = null;
		
		System.out.println(email + firstName + lastName + uName +pword);
		
		try
		{
			conn = createDbConnection(connectionString, userName, password);
			
			preparedStamenet = conn.prepareStatement("INSERT into swe645assignment4.users(fname,lname,email,username,pword) values(?,?,?,?,?)");
			preparedStamenet.setString(1, firstName);
			preparedStamenet.setString(2, lastName);
			preparedStamenet.setString(3, email);
			preparedStamenet.setString(4, uName);
			preparedStamenet.setString(5, pword);
			
			preparedStamenet.executeUpdate();
			
			//System.out.println("------query------"+ rs.toString());
		}
		catch(Exception e)
		{
			System.out.println("----------Error in InsertListing-------");
			e.printStackTrace();
		}
		finally
		{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return row;
	}
	
	public StringBuilder validation(String email, String firstName, String lastName, String uname, String pword)
	{
		
		StringBuilder errormsg= new StringBuilder();
		if(email.length()<1 || email.equals(null))
		{
			errormsg.append("\n");
			errormsg.append("Please enter email");
			errormsg.append("\n");
		}
		else 
		{
			if(!email.matches("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$"))
			{
				errormsg.append("Please enter valid email");
				errormsg.append("\n");
			}
			
		}
		
		if(firstName.length()<1 || firstName==null)
		{
			errormsg.append("Please enter First Name");
			errormsg.append("\n");
		}
		else if(!firstName.matches("^[a-zA-Z]{10,20}$"))
		{
			errormsg.append("Please enter valid First Name");
			errormsg.append("\n");
		}
		
		if(lastName.length()<1 || lastName==null)
		{
			errormsg.append("Please enter Last Name");
			errormsg.append("\n");
		}
		else if(!lastName.matches("^[a-zA-Z]{10,20}$"))
		{
			errormsg.append("Please enter valid Last Name");
			errormsg.append("\n");
		}
		
		if(uname.length()<1 || uname==null)
		{
			errormsg.append("Please enter User Name");
			errormsg.append("\n");
		}
		else if(!uname.matches("^[A-Za-z0-9]{5,16}$"))
		{
			errormsg.append("Please enter valid User Name");
			errormsg.append("\n");
		}
		
		if(pword.length()<1 || pword==null)
		{
			errormsg.append("Please enter password");
			errormsg.append("\n");
		}
		else if(!pword.matches("^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{5,20}$"))
		{
			errormsg.append("Please enter valid password");
			errormsg.append("\n");
		}
		return errormsg;
		
	}

	public String hashPassword(String pword) {
		// TODO Auto-generated method stub
		String hashedPassword=null;
		
		if(pword.length()<1)
		{
			return null;
		}
		
		try
		{
			MessageDigest digest = MessageDigest.getInstance("MD5");
			
			digest.update(pword.getBytes(),0,pword.length());
			hashedPassword = new BigInteger(1,digest.digest()).toString(16);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
		return hashedPassword;
	}
}
