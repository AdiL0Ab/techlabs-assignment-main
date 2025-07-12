package com.techlabs.serializationAndDeserialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
public class MovieManager implements Serializable{
	private List<Movie> movies;
	private static final String filePath = "C:\\Users\\Bobby\\Desktop\\test.txt";
	
	public MovieManager() {
		movies = new ArrayList<>();
//		loadMovies();
	}
	
	public void addMovie(Movie movie) {
		movies.add(movie);
		System.out.println("Movie added successfully to the list");
	}
	
	public void clearMovies() {
		movies.clear();
		System.out.println("All movie deleted!");
	}
	
	public void getMovieId(int id) {
		movies
		.stream()
		.filter((movie) -> movie.getId() == id)
		.forEach((movie) -> System.out.println(movie));
	}
	
	public void loadMovies() {
		//deserialize
		try {
			FileInputStream fileInput = new FileInputStream(filePath);
			@SuppressWarnings("resource")
			ObjectInputStream objectInput = new ObjectInputStream(fileInput);
			@SuppressWarnings("unchecked")
			List<Movie> movies = (List<Movie>) objectInput.readObject();
			movies
			.stream()
			.forEach((movie) -> System.out.println(movie));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void saveMovies() {
		//serialize
		try {
			FileOutputStream fileOutput = new FileOutputStream(filePath);
			@SuppressWarnings("resource")
			ObjectOutputStream objectOutput = new ObjectOutputStream(fileOutput);
			objectOutput.writeObject(movies);
			System.out.println("Serialization Successfull");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
