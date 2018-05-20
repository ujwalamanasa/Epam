package com.epam.car.service;
 /*
  * This package contains the class which takes user input.
  */
import com.epam.car.util.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import com.epam.car.bean.CarBean;
import com.epam.car.dao.CarDAO;

public class CarMain {

	/*This method adds the CarBean Object to the database.*/	
		public String addCar (CarBean carBean) {
	
/*
 *  These are the conditions under which a user defined
 *  exception WrongCarDataException (found in com.klu.car.util package)
 *  should be thrown.
 *  carBean is null
 *  carBean’s name is empty String
 *  carBean’s name contains less than 2 characters
 *  carBean’s type is not PREMIUM/ORDINARY
 *  carBean’s price less than 1 lakh
 */
			if(carBean.equals(null) || carBean.getName().equals(null)|| carBean.getName().length()<2 || ((!carBean.getCategory().equals("PREMIUM"))&&(!carBean.getCategory().equals("ORDINARY"))) || carBean.getPrice()<100000)
				{
					try {
			throw new WrongCarDataException();
					}
					catch(Exception e) {
						return "INCORRECT DATA";
					}
					}
				else {

					
					
					CarDAO cd=new CarDAO();
					String id=cd.generateCarId(carBean.getName());
					
						carBean.setCarid(id);
						cd.addCarBean(carBean);
						return "success";
						
					}
					
		}
		
				
			
	public static void main(String[] args){
			CarMain carMain = new CarMain();
			CarBean cb=new CarBean();
			
			cb.setName("HONDA");
			cb.setCategory("ORDINARY");
			cb.setPrice(1234097);
			cb.setAirbagsNo(3);
			String result = carMain.addCar(cb);
			System.out.println(result);

		}	

	}



