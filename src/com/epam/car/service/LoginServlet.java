package com.epam.car.service;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.epam.car.util.DBUtil;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
        
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        // Store username value into name varible
        String password = request.getParameter("password");
     // Store password value into password varible
        DBUtil dbutil=new DBUtil();
        // create a dbutil object
    	Connection conn=dbutil.getDBConn();
    	//collecting the connection reference into conn
         
        try {
            
      
        		
        		 Statement stmt=(Statement) conn.createStatement();
        			// This Statement is used to retrieve values from the database
        		 String	sql="SELECT * FROM login WHERE username='"+name+"' AND password='"+password+"';";/*gets the username and password which is in the database that matches the username and password which are in the URL. If the result set is not empty, it means there exists a match. So, username and password are valid. If the result set is empty, it means there is no such username and password entry.*/
        		 		ResultSet rs=stmt.executeQuery(sql);
        		 		 
        		 		if(rs.next()){
        		 			
        		 		
        		 if(rs.getString(1).equals(name)&&rs.getString(2).equals(password)){
        		
        			 
        		       
        			
      CarMain cm=new CarMain();
      cm.main(null);;
          
        			 
        		 }    
        		 
        		 		
        		 		}
        		 		
        	
         
        
    }
        catch(Exception e) {
        	
        }
}
    
}