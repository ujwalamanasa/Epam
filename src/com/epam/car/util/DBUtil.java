package com.epam.car.util;
/*
 * This package contains this class to establish database connection.
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	 private static String dbURL = "jdbc:mysql://localhost:3306/carmanagement";
	 /*
	  * This is the connection URL for the mysql database
	  *jdbc is the API, mysql is the database, localhost is the server name on which mysql is running,
	  * 3306 is the port number and carmanagement is the database name.
	  */
	 private static String dbUser = "root";
	 //Default username for the mysql database is root

     private static String dbPass = "4398";
     //Password
	static Connection con=null;
	//create a connection object
	/*
	 * This method will establish a connection to the database and return the java.sql.Connection reference
	 */
public static Connection getDBConn() {
	try {
	Class.forName("com.mysql.jdbc.Driver");
	// The driver class for the mysql database.
	
	 con = DriverManager.getConnection(dbURL, dbUser, dbPass);
	 //Establish a connection with mysql database 

	}
	/*
	 * If any abnormal condition occurs stack trace will be displayed
	 */
	catch(Exception e) {
		
		System.out.println(e);
	}
	return con;
	}
}
