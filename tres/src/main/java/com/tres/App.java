package com.tres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class App {
	private static Scanner sc;
	private static String url = "jdbc:mysql://tres-db-1.cba8zgtsjpc0.ap-south-1.rds.amazonaws.com:3306/tres";
	private static String user = "admin";
	private static String pass;
	private static Connection conn;
	private static Statement stm;

	private static void createTable(String tableName, String schema) {
		String drop = "DROP TABLE IF EXISTS " + tableName;
		String create = "CREATE TABLE " + tableName + schema;
		try {
			stm.executeQuery(drop);
			stm.executeQuery(create);
			System.out.println("Table created");
		} catch (SQLException ex) {
			System.out.println("Problem in creating table : " + tableName);
			ex.printStackTrace();
		}
	}

	private static void getTable(String tableName) {
		String query = "SELECT * FROM " + tableName;

		try {
			ResultSet resultSet = stm.executeQuery(query);
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int noOfColumns = rsmd.getColumnCount();
			// print column-name
			for (int i = 1; i <= noOfColumns; i++) {
				if (i > 1)
					System.out.print("\t | \t");
				System.out.print(rsmd.getColumnName(i));
			}
			System.out.println();
			while (resultSet.next()) {
				for (int i = 1; i <= noOfColumns; i++) {
					if (i > 1)
						System.out.print("\t | \t");
					String columnValue = resultSet.getString(i);
					System.out.print(columnValue);
				}
				System.out.println();
			}

		} catch (SQLException ex) {
			System.out.println("Problem in fetching details from table : " + tableName);
			ex.printStackTrace();
		}
	}

	private static void insertValues(String tableName, String[] values) {
		String prefix = "INSERT INTO " + tableName + " VALUES (";

		try {
			for (String value : values) {
				String query = prefix + value + ")";
				stm.executeUpdate(query);
			}
		} catch (SQLException ex) {
			System.out.println("Problem in inserting values in table name : " + tableName);
			ex.printStackTrace();
		}
	}
	
	private static void deleteAll(String tableName) {
		String query = "TRUNCATE TABLE " + tableName;

		try {
			stm.executeQuery(query);
		} catch (SQLException ex) {
			System.out.println("Problem in deleting all values from table : " + tableName);
			ex.printStackTrace();
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		System.out.print("Enter password: ");
		pass = sc.nextLine().trim();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			conn = DriverManager.getConnection(url, user, pass);

			stm = conn.createStatement();
			
			
			getTable("station");
			
			
			
			// close everything
			stm.close();
			conn.close();

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();
		}

	}
}
