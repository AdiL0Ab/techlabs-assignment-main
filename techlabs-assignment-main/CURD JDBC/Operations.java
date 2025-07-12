package com.techlabs.curd;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Operations {
	private Operations() {}
	
//	1. Insert Records into Department
	public static void insertRecordsIntoDepartment(Connection connection, Scanner scanner) {
		Department department = createDepartment(scanner);
        try {
        	String sql = "INSERT INTO dept (DEPTNO, DNAME, LOC) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, department.getDeptno());
            preparedStatement.setString(2, department.getDname());
            preparedStatement.setString(3, department.getLoc());
            preparedStatement.executeUpdate();
            System.out.println("Records inserted into the department table successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
//	2. insert records into employee
	 public static void insertRecordsIntoEmployee(Connection connection, Scanner scanner) {
		 	Employee employee = createEmployee(scanner);
	        try {
	        	String sql = "INSERT INTO emp (EMPNO, ENAME, JOB, MGR, HIREDATE, SAL, COMM, DEPTNO) "
	        			+ "VALUES (?,?,?,?,?,?,?,?)"; 
	        	 PreparedStatement preparedStatement = connection.prepareStatement(sql);
	        	 preparedStatement.setInt(1, employee.getEmpno());
	        	 preparedStatement.setString(2, employee.getEname());
	        	 preparedStatement.setString(3, employee.getJob());
	        	 Integer mgr = employee.getManager()==-1 ? null : employee.getManager();
	        	 preparedStatement.setObject(4, mgr);
	        	 preparedStatement.setDate(5, employee.getHiredate());
	        	 preparedStatement.setDouble(6, employee.getSal());
	        	 preparedStatement.setDouble(7, employee.getComm());
	        	 preparedStatement.setInt(8, employee.getDeptno());
	        	 preparedStatement.executeUpdate();
	            System.out.println("Records inserted into the employee table successfully!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

//	 3. display all employees in a perticular department. Accept department name from user.
	 public static void displayEmployeesInDepartment(Connection connection, Scanner scanner) {
	        try {
	            Statement statement = connection.createStatement();

	            System.out.print("Enter the department name: ");
	            String departmentName = scanner.next();

	            String sql = "SELECT * FROM emp WHERE DEPTNO IN " +
	                    "(SELECT DEPTNO FROM dept WHERE DNAME = '" + departmentName + "')";
	            ResultSet resultSet = statement.executeQuery(sql);

	            System.out.println("Employees in the " + departmentName + " department:");
	            while (resultSet.next()) {
	                Employee employee = new Employee();
	                employee.setEmpno(resultSet.getInt("EMPNO"));
	                employee.setEname(resultSet.getString("ENAME"));
	                employee.setJob(resultSet.getString("JOB"));
	                employee.setManager(resultSet.getInt("MGR"));
	                employee.setHiredate(resultSet.getDate("HIREDATE"));
	                employee.setSal(resultSet.getDouble("SAL"));
	                employee.setComm(resultSet.getDouble("COMM"));
	                employee.setDeptno(resultSet.getInt("DEPTNO"));
	                System.out.println(employee);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
//	 4. update records of emloyees. increase commision by 20%
	 public static void updateEmployeeRecords(Connection connection, Double percentageInc) {
	        try {
	            double inc = percentageInc/100.0;
	            String sql = "UPDATE emp SET COMM = COMM + (COMM * "+inc+")";
	            PreparedStatement preparedStatement = connection.prepareStatement(sql);
	            preparedStatement.executeUpdate();
	            System.out.println("Employee records updated successfully!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
//	 6. delete employees having salary less than ............. . accept salary from user.
	 public static void deleteEmployeesWithSalaryLessThan(Connection connection, Scanner scanner) {
	        try {
	            Statement statement = connection.createStatement();
	            
	            // Accepting salary from the user
	            System.out.print("Enter the salary: ");
	            double salary = scanner.nextDouble();
	            
	            // Deleting employees with salary less than the specified amount
	            String sql = "DELETE FROM emp WHERE SAL < " + salary;
	            int rowsAffected = statement.executeUpdate(sql);

	            System.out.println(rowsAffected + " employee(s) deleted successfully!");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
//	 7. display all employees
	 public static void displayAllEmployees(Connection connection) {
	        try {
	            Statement statement = connection.createStatement();

	            // Displaying all employees
	            String sql = "SELECT * FROM emp";
	            ResultSet resultSet = statement.executeQuery(sql);

	            System.out.println("All Employees:");
	            while (resultSet.next()) {
	                Employee employee = new Employee();
	                employee.setEmpno(resultSet.getInt("EMPNO"));
	                employee.setEname(resultSet.getString("ENAME"));
	                employee.setJob(resultSet.getString("JOB"));
	                employee.setManager(resultSet.getInt("MGR"));
	                employee.setHiredate(resultSet.getDate("HIREDATE"));
	                employee.setSal(resultSet.getDouble("SAL"));
	                employee.setComm(resultSet.getDouble("COMM"));
	                employee.setDeptno(resultSet.getInt("DEPTNO"));
	                System.out.println(employee);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
//	 8. dispay all departments
	 public static void displayAllDepartments(Connection connection) {
	        try {
	            Statement statement = connection.createStatement();

	            // Displaying all departments
	            String sql = "SELECT * FROM dept";
	            ResultSet resultSet = statement.executeQuery(sql);

	            System.out.println("All Departments:");
	            while (resultSet.next()) {
	                Department department = new Department();
	                department.setDeptno(resultSet.getInt("DEPTNO"));
	                department.setDname(resultSet.getString("DNAME"));
	                department.setLoc(resultSet.getString("LOC"));
	                System.out.println(department);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
// -------------------------------- helper methods -------------------------------
	 private static Department createDepartment(Scanner scanner) {
		System.out.println("Enter Department Number.");
		int deptno = scanner.nextInt(); 
		
		System.out.println("Enter Department Name.");
		String dname = scanner.next();
		
		System.out.println("Enter Department Loc");
		String loc = scanner.next();
		
		return new Department(deptno, dname, loc);
	}
	
	private static Employee createEmployee(Scanner scanner) {
		System.out.println("Enter employee number.");
		int empno = scanner.nextInt(); 
		
		System.out.println("Enter employee name.");
		String ename = scanner.next();
		
		System.out.println("Enter employee job.");
		String job = scanner.next();
		
		System.out.println("Enter manager's employee number.");
		int manager = scanner.nextInt(); 
		
		System.out.println("Enter Hire Date (YYYY-MM-DD)");
		String hiredate = scanner.next(); 
		
		System.out.println("Enter employee Salary.");
		double sal = scanner.nextDouble();
		
		System.out.println("Enter employee Commission.");
		double comm = scanner.nextDouble();
		
		System.out.println("Enter employee department number");
		int deptno = scanner.nextInt();
		
		return new Employee(empno, ename, job, manager, DateConverter(hiredate), sal, comm, deptno);
	}
	
	private static Date DateConverter(String dateString) {
		String pattern = "yyyy-MM-dd";

		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		try {
		    java.util.Date utilDate = dateFormat.parse(dateString);
		    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		    return sqlDate;
		} catch (ParseException e) {
		    e.printStackTrace();
		}
		return null;
	}
}
