package com.techlabs.shoppingCart;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Test {
	public static void main(String []args) {
		
		Product mango = new Product(101, "Mango", 100, 10);
		Product apple = new Product(102, "Apple", 150, 5);
		Product milk = new Product(103, "Milk", 60, 7);
		Product biscuit = new Product(104, "Biscuit", 20, 0);
		Product tea = new Product(105, "Tea", 55, 6);
		
		LineItem mangoItem = new LineItem(1001, 3, mango);
		LineItem teaItem = new LineItem(1002, 2, tea);
		LineItem appleItem = new LineItem(1003, 5, apple);
		
		List<LineItem> items = Arrays.asList(mangoItem, teaItem, appleItem);
		
		Order order1 = new Order(10001, new Date(), items);
		
		List<Order> orderList = Arrays.asList(order1);
		Customer customer = new Customer(100001, "Vishnu", orderList);
		printOrder(customer);
	}
	
	
	public static void printOrder(Customer customer) {
		List<Order> orders = customer.getOrders();
		int orderNumber = 1;
		for(Order order : orders) {
			List<LineItem> itemsList = order.getItems();
			System.out.println("|--------------------------- ORDER "+orderNumber+ " -------------------------------|");
			System.out.println("   Id  " + "    name   " + "   quantity   " +  "   unitPrice   " + "    total  ");
			System.out.println("|-------------------------------------------------------------------|");
			for(LineItem item : itemsList) {
				System.out.println("   " + item.getId() 
				+ "    " + item.getProduct().getName() 
				+ "         " + item.getQuantity()
				+ "           " + item.getProduct().getPrice()
				+ "         " + item.calculateLineItemCost());
			}
			System.out.println("|-------------------------------------------------------------------|");
			System.out.println("                                                   "+order.calculateOrderPrice());
			System.out.println("|-------------------------------------------------------------------|");
			++orderNumber;
		}
	}
}
