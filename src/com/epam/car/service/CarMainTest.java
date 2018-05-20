package com.epam.car.service;

import java.util.Arrays;
import java.util.Collection;

import com.epam.car.bean.CarBean;

public class CarMainTest {

	private String carid;
	private String name;
	private String category;
	private int price;
	private int airbagsNo;
	private String output;
	//private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	public CarMainTest(String carid,String name,String category,int price,int airbagsNo,String output) {
		this.carid=carid;
		this.name=name;
		this.category=category;
		this.price=price;
		this.airbagsNo=airbagsNo;
		this.output=output;
		
	}

	public static Collection<Object[]> generateData(){
		
		Object data[][] = {
				{1896,null,"PREMIUM",1234567,5,"INCORRECT DATA"},
				{1898,"Honda","PREMIUM",1234567,3,"success"},
				{1894,"a","PREMIUM",1234567,5,"INCORRECT DATA"},
				{1896,"Honda","PREMIUM",123,5,"INCORRECT DATA"},
				{1897,"Toyota","PRE",1234567,5,"INCORRECT DATA"},
				
				{1899,"Suzuki","ORDINARY",128888,5,"success"},
				
				
				
		};
		
		return Arrays.asList(data);
	}
	
	public void  testaddcar () {
		CarMain cm=new CarMain();
		CarBean cb=new CarBean();
		
		cb.setName(name);
		cb.setCategory(category);
		cb.setPrice(price);
		cb.setAirbagsNo(airbagsNo);
		assertEquals(output, cm.addCar(cb)+"");
	}

	private void assertEquals(String output2, String string) {
		// TODO Auto-generated method stub
		
	}
}
