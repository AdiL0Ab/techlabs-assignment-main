package com.techlabs.assignments;
import java.util.Scanner;

public class MatrixMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int row1, col1, row2, col2;
		
		System.out.println("Enter number of rows for matrix1.");
		row1 = scanner.nextInt();
		System.out.println("Enter number of cols for matrix1.");
		col1 = scanner.nextInt();
		
		int matrix1[][] = new int[row1][col1];
		System.out.println("Enter values for matrix1.");
		
		for(int i=0; i<row1; ++i) {
			for(int j=0; j<col1; ++j) {
				matrix1[i][j] = scanner.nextInt();
			}
		}
		
		
		System.out.println("Enter number of rows for matrix2.");
		row2 = scanner.nextInt();
		System.out.println("Enter number of cols for matrix2.");
		col2 = scanner.nextInt();
		
		if(col1 != row2) {
			System.out.println("Enter a valid matrix dimension !!");
			return;
		}
		
		int matrix2[][] = new int[row2][col2];
		System.out.println("Enter values for matrix1.");
		
		for(int i=0; i<row2; ++i) {
			for(int j=0; j<col2; ++j) {
				matrix2[i][j] = scanner.nextInt();
			}
		}
		
		
		int resultMatrix[][] = new int[row1][col2];
		for(int i=0; i<row1; ++i) {
			for(int j=0; j<col2; ++j) {
				for(int k=0; k<col1; ++k) {
					resultMatrix[i][j] += matrix1[i][k]*matrix2[k][j];
				}
			}
		}
		
		
		System.out.println("Resultant Matrix:- ");
		for(int i=0; i<row1; ++i) {
			for(int j=0; j<col2; ++j) {
				System.out.print(resultMatrix[i][j]+"\t");
			}
			System.out.println("");
		}
		
		scanner.close();
	}

}
