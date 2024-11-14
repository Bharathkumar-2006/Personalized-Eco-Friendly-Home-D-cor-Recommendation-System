package User_functions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import dbcon.Database;

public class Review {
    private int userId;
    private int itemId;
    private int rating;
    private String reviewText;

    public void Reviewproduct() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your User ID: ");
        this.userId = sc.nextInt();
        
        System.out.print("Enter the Item ID you are reviewing: ");
        this.itemId = sc.nextInt();
        
        System.out.print("Enter your rating (1-5): ");
        this.rating = sc.nextInt();
        
        sc.nextLine();
        System.out.print("Enter your review text: ");
        this.reviewText = sc.nextLine();
        String sql = "INSERT INTO Reviews (user_id, item_id, rating, review_text) VALUES (?, ?, ?, ?)";
        try (Connection conn = Database.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setInt(1, this.userId);
                pstmt.setInt(2, this.itemId);
                pstmt.setInt(3, this.rating);
                pstmt.setString(4, this.reviewText);
                pstmt.executeUpdate();
                System.out.println("Review added successfully!");
            }
            
        catch(SQLException e) {
            System.out.println("Error while inserting review: " + e.getMessage());
        }
        sc.close();
    }
}
