package com.advanceproblems;

import java.io.*;
import java.sql.*;

    public class GenerateCSVFromDatabase {
        private static final String JDBC_URL = "jdbc:mysql://localhost:3306/company_db"; // Change database name
        private static final String JDBC_USER = "root"; // Change username
        private static final String JDBC_PASSWORD = "password"; // Change password
        private static final String CSV_FILE = "employees.csv";

        public static void main(String[] args) {
            writeCSVFromDatabase();
        }

        public static void writeCSVFromDatabase() {
            String query = "SELECT employee_id, name, department, salary FROM employees";

            try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query);
                 BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE))) {

                // Write Headers
                writer.write("Employee ID,Name,Department,Salary");
                writer.newLine();

                // Write Data
                while (rs.next()) {
                    int id = rs.getInt("employee_id");
                    String name = rs.getString("name");
                    String department = rs.getString("department");
                    double salary = rs.getDouble("salary");

                    writer.write(id + "," + name + "," + department + "," + salary);
                    writer.newLine();
                }

                System.out.println("CSV file '" + CSV_FILE + "' generated successfully.");

            } catch (SQLException | IOException e) {
                e.printStackTrace();
            }
        }
    }


