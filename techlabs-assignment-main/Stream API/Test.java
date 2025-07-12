package com.techlabs.streamsAssignment;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Region europe = new Region(1, "Europe");
		Region americas = new Region(2, "Americas");
		Region asia = new Region(3, "Asia");
		Region middleEast  = new Region(4, "Middle East and Africa");
		
		Country italy = new Country("IT", "Italy", 1);
		Country japan = new Country("JP", "Japan", 3);
		Country us = new Country("US", "United States of America", 2);
		Country china = new Country("CN", "China", 3);
		Country india = new Country("IN", "India", 3);
		
		Country australia = new Country("AU", "Australia", 3);
		Country zimbabwe = new Country("ZW", "Zimbabwe",4);
		Country singapore = new Country("SG", "Singapore", 3);
		Country uk = new Country("UK", "United Kingdom", 1);
		Country france = new Country("FR", "France", 1);
		
		Country germany = new Country("DE", "Germany", 1);
		Country zambia = new Country("ZM", "Zambia", 4);
		Country egypt= new Country("EG", "Egypt", 4);
		Country brazil= new Country("BR", "Brazil", 2);
		Country switzerland= new Country("CH", "Switzerland", 1);
		
		Country netherlands= new Country("NL", "Netherlands", 1);
		Country mexico= new Country("MX", "Mexico", 2);
		Country kuwait= new Country("KW", "Kuwait", 4);
		Country israel= new Country("IL", "Israel", 4);
		Country denmark= new Country("DK", "Denmark", 1);
		
		Country hongkong = new Country("HK", "HongKong", 3);
		Country nigeria = new Country("NG", "Nigeria", 4);
		Country argentina = new Country("AR", "Argentina", 2);
		Country belgium = new Country("BE","Belgium",1);
		
		List<Region> regions = Arrays.asList(europe, americas, asia, middleEast);
		List<Country> countries = Arrays.asList(italy, japan, us, china, india, australia, zimbabwe, singapore,
				uk, france, germany, zambia, egypt, brazil, switzerland, netherlands, mexico, kuwait, israel, 
				denmark, hongkong, nigeria, argentina, belgium);
		
		//1. print the countries regionwise
		regions
		.stream()
		.map(region -> region.getRegionId())
		.forEach(id -> {
						regions
						.stream()
						.filter(region -> region.getRegionId() == id)
						.forEach(region -> System.out.println("\n" + region.getRegionName()));
						countries
						.stream()
						.filter(country -> country.getRegionID() == id)
						.forEach(country -> System.out.println(country));
					});
		
		
		//2. count countries in a region
		System.out.println();
		countries
		.stream()
        .collect(Collectors.groupingBy(Country::getRegionID, Collectors.counting()))
        .forEach((regionID, count) -> {
        	regions
			.stream()
			.filter(region -> region.getRegionId() == regionID)
			.forEach(region -> System.out.println(region.getRegionName()+": "+count));
        });
                

		//3. accept regionid and print all countries belonging to that region
        System.out.println();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter region ID: ");
		int id = scanner.nextInt();
		
		regions
		.stream()
		.filter(region -> region.getRegionId() == id)
		.forEach(region ->System.out.println(region.getRegionName()+": "));
		
		countries
		.stream()
		.filter(country -> country.getRegionID() == id)
		.forEach(country -> System.out.println(country));
		
		scanner.close();			
	}

}
