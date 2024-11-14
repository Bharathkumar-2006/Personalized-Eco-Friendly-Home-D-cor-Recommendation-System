package Admin_functions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import dbcon.Database;
public class Deletepro {

    public void deleteDecorItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter item ID to delete: ");
        int itemId = scanner.nextInt();

        String sql = "DELETE FROM DecorItems WHERE item_id = ?";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, itemId);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Decor item deleted successfully.");
            } else {
                System.out.println("No decor item found with the given ID.");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        scanner.close();
    }
}