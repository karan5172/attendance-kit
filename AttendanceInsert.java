package demoTraining;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AttendanceInsert {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/kit_attandance";
        String username = "root";
        String password = "karan@kit";

        String sql = "INSERT INTO emp_atten (emp_id, emp_name, in_time, out_time, status) VALUES (?, ?, ?, ?, ?)";

        try {

            Connection conn = DriverManager.getConnection(url, username, password);


            PreparedStatement pstmt = conn.prepareStatement(sql);


            System.out.println("Enter Employee ID:");
            String value1 = scanner.nextLine();

            System.out.println("Enter Employe Name:");
            String value2 = scanner.nextLine();
            
            System.out.println("Enter IN_TIME:");
            String value3 = scanner.nextLine();
            
            System.out.println("Enter OUT_TIME:");
            String value4 = scanner.nextLine();
            
            System.out.println("Enter Status:");
            String value5 = scanner.nextLine();


            pstmt.setString(1, value1);
            pstmt.setString(2, value2);
            pstmt.setString(3, value3);
            pstmt.setString(4, value4);
            pstmt.setString(5, value5);

            pstmt.executeUpdate();

            pstmt.close();
            conn.close();

            System.out.println("Data inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting data: " + e.getMessage());
        } finally {

            scanner.close();
        }
    }
}
