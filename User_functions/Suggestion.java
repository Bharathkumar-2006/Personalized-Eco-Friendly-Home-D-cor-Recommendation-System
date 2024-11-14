package User_functions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import dbcon.Database;


public class Suggestion {
    public void Getsuggestion() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = sc.nextLine();
        System.out.println("Enter your preferences: ");
        String preferences = sc.nextLine();
        System.out.println("Enter your budget: ");
        double budget = sc.nextDouble();

        String sql = "INSERT INTO Users (username, preferences, budget) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, username);
            pstmt.setString(2, preferences);
            pstmt.setDouble(3, budget);
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        System.out.println("Enter room length (in meters): ");
        double length = sc.nextDouble();
        System.out.println("Enter room width (in meters): ");
        double width = sc.nextDouble();
        System.out.println("Enter room height (in meters): ");
        double height = sc.nextDouble();
    

        sql = "INSERT INTO RoomDimensions (length, width, height) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setDouble(1, length);
            pstmt.setDouble(2, width);
            pstmt.setDouble(3, height);
            pstmt.executeUpdate();
            System.out.println("Room dimensions added successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String query = "SELECT item_name FROM Decoritems WHERE eco_friendly = TRUE" ;
        
        try (Connection connection = Database.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
             
            System.out.println("Here are some eco-friendly decor suggestions:");
            while (resultSet.next()) {
                System.out.println("- " + resultSet.getString("item_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sc.close();
    }    
}