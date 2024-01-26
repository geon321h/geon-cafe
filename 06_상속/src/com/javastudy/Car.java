package com.javastudy;

public class Car {

	private String name;
	private int year;
	
	public Car(String name, int year) {
		
		this.name = name;
		this.year = year;
		
	}
	
	public void display() {
		
		System.out.println("name:" + name);
		System.out.println("year:" + year);
		
	}
	
}
