package com.epam.car.util;
/*
 * This package contains the class to handle the user defined exception.
 */

public class WrongCarDataException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

/*
 *  Override the toString() method of the Object class and return a String “Data Incorrect”.
 */
public String toString() {
	return "Data Incorrect";
}
}
