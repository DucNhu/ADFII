package ADFII;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Scanner;

public class StudentsController {
    public static void add() {
        Students students = new Students("", "", "", 0);
        Scanner scanner = new Scanner(System.in);
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/adfii?" +
                        "&serverTimezone=UTC" +
                        "&useSSL=false" +
                        "&allowPublicKeyRetrieval=true",
                "root",
                "");
             Statement statement = connection.createStatement();
        ) {
            System.out.println("Enter your student ID: ");
            String id = scanner.nextLine();
            students.setId(id);
            System.out.println("Enter your student name:");
            String name = scanner.nextLine();
            students.setName(name);
            System.out.println("Enter your student of address:");
            String address = scanner.nextLine();
            students.setAddress(address);
            System.out.println("Enter your student of phone:");
            int phone = scanner.nextInt();
            students.setPhone(phone);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void save() {
        Students students = new Students("", "", "", 0);
        Scanner scanner = new Scanner(System.in);
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/adfii?" +
                        "&serverTimezone=UTC" +
                        "&useSSL=false" +
                        "&allowPublicKeyRetrieval=true",
                "root",
                "");
             Statement statement = connection.createStatement();
        ) {
            statement.executeUpdate("INSERT INTO students VALUES ('" + students.getId() + "', '" + students.getName() + "', '" + students.getAddress() + "', 0" + students.getPhone() + " );" );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void select() {
        try (
                Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/adfii?" +
                                "&serverTimezone=UTC" +
                                "&useSSL=false" +
                                "&allowPublicKeyRetrieval=true",
                        "root",
                        ""
                );
                Statement stmt = conn.createStatement();
        ) {
            String strSelect = "select * from students";
            ResultSet rset = stmt.executeQuery(strSelect);

            while (rset.next()){
                String StudentID = rset.getString("StudentID");
                String StudentName = rset.getString("StudentName");
                String Address = rset.getString("Address");
                String Phone = rset.getString("Phone");

                System.out.println(StudentID + ", " + StudentName + ", " + Address + ", " + Phone);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
