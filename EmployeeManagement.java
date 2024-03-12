package demoTraining;

import java.sql.*;
import java.util.Scanner;

public class EmployeeManagement{

    private static final String DB_URL = "jdbc:mysql://localhost:3306/kit_attandance";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "karan@kit";

    private Connection connection;
    private Scanner scanner;

    public EmployeeManagement() {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            scanner = new Scanner(System.in);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\nEmployee Management System Menu:");
            System.out.println("1. Add Employee Attendence");
            System.out.println("2. Retrieve Employee Attendence");
            System.out.println("3. Update Employee Attendence");
            System.out.println("4. Delete Employee Attendence");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (choice) {
                case 1:
                    addEmployeeAttandance();
                    break;
                case 2:
                    retrieveEmployeeDetails();
                    break;
                case 3:
                    updateEmployeeAttandance();
                    break;
                case 4:
                    deleteEmployeeAttandance();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void addEmployeeAttandance() {
        System.out.println("\nAdding Employee Attendence...");
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Employee IN_TIME: ");
        String in_time = scanner.nextLine();
        System.out.print("Enter Employee OUT_TIME: ");
        String out_time = scanner.nextLine();
        System.out.print("Enter Employee Status: ");
        String status = scanner.nextLine();

        try {
            String sql = "INSERT INTO emp_atten (emp_id, emp_name, in_time, out_time, status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.setString(2, name);
            statement.setString(3, in_time);
            statement.setString(4, out_time); 
            statement.setString(5, status); 
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Employee Attendence added successfully!");
            } else {
                System.out.println("Failed to add employee Attendence.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void retrieveEmployeeDetails() {
        System.out.println("\nRetrieving Employee Attendence...");
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        try {
            String sql = "SELECT * FROM emp_atten WHERE emp_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Employee ID: " + resultSet.getInt(1));
                System.out.println("Name: " + resultSet.getString(2));
                System.out.println("in_time: " + resultSet.getString(3));
                System.out.println("out_time: " + resultSet.getString(4));
                System.out.println("status: " + resultSet.getString(5));
            } else {
                System.out.println("Employee not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updateEmployeeAttandance() {
        System.out.println("\nUpdating Employee Attendence...");
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter updated Time: ");
        String in_time = scanner.nextLine();

        try {
            String sql = "UPDATE emp_atten SET in_time = ? WHERE emp_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, in_time);
            statement.setInt(2, id);
            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Employee Attendence updated successfully!");
            } else {
                System.out.println("Employee not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteEmployeeAttandance() {
        System.out.println("\nDeleting Employee...");
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        try {
            String sql = "DELETE FROM emp_atten WHERE emp_id = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                System.out.println("Employee attendence   deleted successfully!");
            } else {
                System.out.println("Employee not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        EmployeeManagement system = new EmployeeManagement();
        system.start();
    }
}