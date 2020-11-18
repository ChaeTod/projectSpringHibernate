package sk.kosickaakademia.jdbc.Artem;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJDBC {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
        String user = "hbstudent";
        String password = "hbstudent";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Connecting to database");
            Connection myConn = DriverManager.getConnection(jdbcURL, user, password);
            System.out.println("Connection successful!");
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
