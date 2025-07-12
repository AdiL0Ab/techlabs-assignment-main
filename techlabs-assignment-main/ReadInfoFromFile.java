package com.techlabs.streams;
import java.io.FileInputStream;
import java.io.IOException;

public class ReadInfoFromFile {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream inputFile = new FileInputStream("C:/Users/Bobby/Desktop/testing.txt");
		int charCount = 0, lineCount = 0, wordCount = 0;
		
		int ch;
		int prev = -1;
		while((ch = inputFile.read()) != -1) {
			if(ch != ' ') 
				++charCount;
			
			if(ch == '\n') 
				++lineCount;
			
			if(ch == '\n' || ch == '\t' || (prev != ' ' && ch == ' '))
				++wordCount;
			
			prev = ch;
		}
		
		inputFile.close();
		
		System.out.println("Char count: " + charCount);
		System.out.println("Word count: " + wordCount);
		System.out.println("line count: " + lineCount);
		
		
	}

}
