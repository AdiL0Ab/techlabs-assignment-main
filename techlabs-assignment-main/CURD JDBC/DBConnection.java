package com.techlabs.curd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	private static Connection connection;
	private DBConnection() {}
	
	//creating database
	static void createCompanyDb(String databaseName) {
		Connection connection = null;
        try {
        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","Root@root123");
            System.out.println("Connected to MySQL Server successfully.");

            Statement statement = null;
            try {
                statement = connection.createStatement();
                String sql = "CREATE DATABASE "+databaseName;
                statement.executeUpdate(sql);
                System.out.println("Database created successfully.");
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (statement != null) {
                    try {
                        statement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
	}
	
	//creating database
		static void deleteCompanyDb(String databaseName) {
			Connection connection = null;
	        try {
	        	connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","Root@root123");
	            System.out.println("Connected to MySQL Server successfully.");

	            Statement statement = null;
	            try {
	                statement = connection.createStatement();
	                String sql = "DROP DATABASE IF EXISTS "+databaseName;
	                statement.executeUpdate(sql);
	                System.out.println("Database delete successfully.");
	            } catch (SQLException e) {
	                e.printStackTrace();
	            } finally {
	                if (statement != null) {
	                    try {
	                        statement.close();
	                    } catch (SQLException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            if (connection != null) {
	                try {
	                    connection.close();
	                } catch (SQLException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
		}
	
	
	// connecting to database
	@SuppressWarnings("finally")
	static Connection connect() {
		try {
			if(connection == null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/company", "root", "Root@root123");
			}
			System.out.println("Connection successful");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			return connection;
		}
	}
	
	//create department table
	static void createDepartmentTable() {
		Statement statement = null;
		try {
		    statement = connection.createStatement();
		    String sql = "CREATE TABLE DEPT (" +
		            "DEPTNO INTEGER NOT NULL, " +
		            "DNAME VARCHAR(14), " +
		            "LOC VARCHAR(13), " +
		            "CONSTRAINT DEPT_PRIMARY_KEY PRIMARY KEY (DEPTNO))";
		    statement.executeUpdate(sql);
		    System.out.println("Table DEPT created successfully.");
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    // Close the statement
		    if (statement != null) {
		        try {
		            statement.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		}

	}
	
	//create employee table
	static void createEmployeeTable() {
		Statement statement = null;
		try {
		    statement = connection.createStatement();
		    String sql = "CREATE TABLE emp (" +
		                 "empno INT NOT NULL, " +
		                 "ename VARCHAR(10), " +
		                 "job VARCHAR(9), "+
		                 "mgr integer, " +
		                 "sal DECIMAL(10, 2), " +
		                 "hiredate DATEtime," +
		                 "comm DECIMAL(10,2),"+
		                 "deptno integer not null,"+
		                 "constraint emp_foreign_key foreign key (deptno) references dept (deptno), "+
		                 "constraint emp_primary_key primary key (empno)"+
		                 ")";
		    statement.executeUpdate(sql);
		    System.out.println("Table 'employee' created successfully.");
		} catch (SQLException e) {
		    e.printStackTrace();
		} finally {
		    if (statement != null) {
		        try {
		            statement.close();
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
		}
	}
	
	
	
}
