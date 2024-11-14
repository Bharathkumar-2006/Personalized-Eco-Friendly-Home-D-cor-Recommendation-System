package Admin_functions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import dbcon.Database;
public class Updatepro {
    Database conn = new Database();
    public void updateDecorItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter item ID to update: ");
        int itemId = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter new item name: ");
        String itemName = scanner.nextLine();
        System.out.print("Enter new category: ");
        String category = scanner.nextLine();
        System.out.print("Is it eco-friendly? (true/false): ");
        boolean ecoFriendly = scanner.nextBoolean();
        System.out.print("Enter brand ID: ");
        int brandId = scanner.nextInt();
        System.out.print("Enter new price: ");
        double price = scanner.nextDouble();

        String sql = "UPDATE DécorItems SET item_name = ?, category = ?, eco_friendly = ?, brand_id = ?, price = ? WHERE item_id = ?";

        try (Connection conn = Database.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, itemName);
            pstmt.setString(2, category);
            pstmt.setBoolean(3, ecoFriendly);
            pstmt.setInt(4, brandId);
            pstmt.setDouble(5, price);
            pstmt.setInt(6, itemId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Decor item updated successfully.");
            } else {
                System.out.println("No decor item found with the given ID.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }
}