package com.techlabs.inheritance;

public class Car extends FourWheeler{
	double price;
	
	Car(String name, double milage, double price){
		setName(name);
		setMilage(milage);
		setPrice(price);
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	void displayDetails() {
		System.out.println("Name: " + getName());
		System.out.println("Milage: " + getMilage() +" km/l");
		System.out.println("Price: Rs." + getPrice()+"\n");
	}
}
