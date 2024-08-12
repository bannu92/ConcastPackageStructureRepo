package com.concast.crm.generic.databaseutility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DataBaseUtility {
	Connection con;
	
public void getDBConnection(String url, String username, String password) throws Exception {
	try
	{
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	DriverManager.getConnection(url,username,password);
	}
	catch(Exception e)
	{
		
	}
}
public void getDBConnection() throws Exception {
	try
	{
	Driver driver=new Driver();
	DriverManager.registerDriver(driver);
	DriverManager.getConnection("jdbc:mysql://localhost:3306/projects", "root", "root");
	}
	catch(Exception e)
	{
		
	}
}

public void closeDBConnection() throws Exception {
		try {
	con.close();
	}
	catch(Exception e)
		{
		
		}
	}
	
public ResultSet ExecuteQuery(String query) throws Exception
{
	ResultSet result=null;
	try {
		
	Statement st=con.createStatement();
	result=st.executeQuery(query);
}
	
	catch(Exception e)
	{
		
	}
	return result;
}

public int ExecuteNonSelectQuery(String query) throws Exception
{ 
	int result=0;
	try {
	Statement st=con.createStatement();
	result=st.executeUpdate(query);
}
	catch(Exception e)
	{
		
	}
	return result;
}

}

