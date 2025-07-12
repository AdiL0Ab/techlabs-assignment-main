package com.techlabs.curd;

import java.sql.Connection;
import java.util.Scanner;

public class Test {
	public static void main(String []args) {
		DBConnection.deleteCompanyDb("Company");
		DBConnection.createCompanyDb("Company");
		Connection connection = DBConnection.connect();
		DBConnection.createDepartmentTable();
		DBConnection.createEmployeeTable();
		
		Scanner scanner = new Scanner(System.in);
		
		int choice = 0;
        do {
        	System.out.println();
            System.out.println("------------- Menu: -----------");
            System.out.println("1. Insert Records into Department");
            System.out.println("2. Insert Records into Employee");
            System.out.println("3. Display Employees in a particular Department");
            System.out.println("4. Update Employee Records");
            System.out.println("5. Insert New Employee in the HR Department");
            System.out.println("6. Delete Employees with Salary Less Than a Given Amount");
            System.out.println("7. Display All Employees");
            System.out.println("8. Display All Departments");
            System.out.println("9. Exit");
            
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    Operations.insertRecordsIntoDepartment(connection, scanner);
                    break;
                case 2:
                    Operations.insertRecordsIntoEmployee(connection, scanner);
                    break;
                case 3:
                    Operations.displayEmployeesInDepartment(connection, scanner);
                    break;
                case 4:
                    Operations.updateEmployeeRecords(connection, 20.0);
                    break;
                case 5:
                	System.out.println("Currently not implemented.");
//                    insertNewEmployeeInHRDepartment(connection);
                    break;
                case 6:
                    Operations.deleteEmployeesWithSalaryLessThan(connection, scanner);
                    break;
                case 7:
                    Operations.displayAllEmployees(connection);
                    break;
                case 8:
                    Operations.displayAllDepartments(connection);
                    break;
                case 9:
                    System.out.println("You are logged out!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    break;
            }
        } while (choice != 9);

        scanner.close();
	}
}
