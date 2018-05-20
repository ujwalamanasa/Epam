package com.epam.car.bean;
/*
 * This package contains this entity class named CarBean.
 * */
public class CarBean {
	private String carid;
	//carid which is a primary key(unique/not null)
	private String name;
	//Name of the car eg: HondaCity,Swift etc..
	private String category;
	//category of the car eg:Premium or Ordinary
	private int price;
	//stores the price of the car
	private int airbagsNo;
	//Stores airbags number
	
	/*
	 *   Getter and Setter methods for all the attributes are created here
	 */
	public String getCarid() {
		return carid;
	}
	public void setCarid(String carid) {
		this.carid = carid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAirbagsNo() {
		return airbagsNo;
	}
	public void setAirbagsNo(int airbagsNo) {
		this.airbagsNo = airbagsNo;
	}
	
}
