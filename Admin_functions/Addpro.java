package Admin_functions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import dbcon.Database;
public class Addpro {

    public void addDecorItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter item ID: ");
        int itemId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.print("Enter item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        System.out.print("Is it eco-friendly? (true/false): ");
        boolean ecoFriendly = scanner.nextBoolean();
        System.out.print("Enter brand ID: ");
        int brandId = scanner.nextInt();
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();         
        System.out.print("Enter brand name: ");
        String brandName = scanner.nextLine();
        System.out.print("Does the brand focus on sustainability? (true/false): ");
        boolean ecofriendly = scanner.nextBoolean();
        
        String sql = "INSERT INTO Brands (brand_id, brand_name, eco_friendly) VALUES (?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, brandId);
            pstmt.setString(2, brandName);
            pstmt.setBoolean(3, ecofriendly);
            pstmt.executeUpdate();
            System.out.println("Brand added successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        sql = "INSERT INTO DecorItems (item_id, item_name, category, eco_friendly, brand_id, price) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, itemId);
            pstmt.setString(2, itemName);
            pstmt.setString(3, category);
            pstmt.setBoolean(4, ecoFriendly);
            pstmt.setInt(5, brandId);
            pstmt.setDouble(6, price);
            pstmt.executeUpdate();
            System.out.println("Decor item added successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            scanner.close();
        }
    }
}