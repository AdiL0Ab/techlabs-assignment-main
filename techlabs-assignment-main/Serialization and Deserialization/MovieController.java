package com.techlabs.serializationAndDeserialization;

import java.util.Scanner;

public class MovieController {
	private MovieManager manager;
	private Scanner scanner;
	
	public MovieController() {}
	
	public MovieController(Scanner scanner) {
		this.scanner = scanner;
		manager = new MovieManager();
	}
	
	public void start() {
		displayMenu();
	}
	
	private void displayMenu() {
		while(true) {
			System.out.println("Press \n1. Add Movie\n"
					+ "2. clear all Movie\n"
					+ "3. get movie by ID\n"
					+ "4. show Movie\n"
					+ "5. save Movie\n"
					+ "6. exit");
			int option = scanner.nextInt();
			if(option >= 6) {
				System.out.println("Thank you for your visit!");
				return;
			}
			displayMenuExtension(option);
		}
	}
	
	private void displayMenuExtension(int option) {
		switch(option) {
			case 1:
				manager.addMovie(getMovieDetails());
				break;
			case 2:
				manager.clearMovies();
				break;
			case 3:
				manager.getMovieId(getMovieIdInput());
				break;
			case 4:
				manager.loadMovies();
				break;
			case 5:
				manager.saveMovies();
				break;
			default:
				return;
		}
	}
	
	private Movie getMovieDetails() {
		int movieId;
		String movieName;
		int year;
		String genre;
		
		System.out.println("Enter movie id");
		movieId = scanner.nextInt();
		
		System.out.println("Enter movie name");
		movieName = scanner.next();
		
		System.out.println("Enter movie year");
		year = scanner.nextInt();
		
		System.out.println("Enter movie genre");
		genre = scanner.next();
		
		return new Movie(movieId, movieName, year, genre);
	}
	
	private int getMovieIdInput() {
		int id = scanner.nextInt();
		return id;
	}
}
