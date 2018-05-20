package com.epam.car.dao;
/*
 * This package contains the class that does the database related JDBC code.
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.epam.car.bean.CarBean;
import com.epam.car.util.DBUtil;

public class CarDAO {
    DBUtil dbutil=new DBUtil();
    // Creating a object for DBUtil class in util package
	Connection conn=dbutil.getDBConn();
	//collecting the connection reference into conn

	
	
/*
 * This method takes the values from the CarBean object and insert it into the database.
 */
	public String addCarBean(CarBean carbean) {
	
	
	try {

		PreparedStatement ps=conn.prepareStatement("INSERT INTO car_tbl VALUES(?,?,?,?,?);");
		// This Prepared Statement is used to send values into the database
	 ps.setString(1,carbean.getCarid());
		ps.setString(2, carbean.getName());
		ps.setInt(3, carbean.getPrice());
		ps.setString(4,carbean.getCategory());
		ps.setInt(5,carbean.getAirbagsNo());
		
/*
 * If the insertion is successful, then a String “SUCCESS” should be returned, else a String “FAIL” should be returned.
 */
		ps.executeUpdate();
		
			return "SUCCESS";
		
	
	
	}
	/*
	 * If any JDBC exception such as SQLException occur, this should return “FAIL”
	 */ 
	catch (SQLException e) {
	return "FAIL";
	}
	
}
	/*
	 *  This contains the code to create a new Car id. 
	 *  CarID is a combination of first 2 letters of name, followed by 4 digit sequence number
     */
public String generateCarId (String name) {
	String id=name.substring(0,2);
	    //To get first two letters of name
	try {
		/*
		 * This query is used to insert sequence number into the database
		 */
		PreparedStatement ps=conn.prepareStatement("insert into car_seq(seqno) values('seqno')");
		// This Prepared Statement is used to send values into the database
	 ps.executeUpdate();
	PreparedStatement ps1=conn.prepareStatement("select max(car_seq) from car_seq");
	// This Prepared Statement is used to retrieve values from the database
	ResultSet rs1=ps1.executeQuery();
	rs1.next();
	
	String result=id + rs1.getInt("max(car_seq)");
	    //Here, result string contains the carid.
		/*
		 * upon successful creation return id, else return null
		 */
	return result;
	}
	/*
	 * If any exception occurs, this should return null”
	 */ 
	
	catch(Exception e) {
		return null;
	}
}


}
