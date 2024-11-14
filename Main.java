import java.util.*;
import User_functions.*;
import Admin_functions.*;

public class Main{
    public static void main(String[] args) {

            Addpro add =new Addpro();
            Deletepro del = new Deletepro();
            Updatepro up = new Updatepro();
            Review re = new Review();
            Suggestion sug = new Suggestion();


        Scanner sc = new Scanner(System.in);

        System.out.println("---Welcome to BK's Personalized Eco-Friendly Home Décor Recommendation System---");
        

        System.out.println("1. Enter as User");
        System.out.println("2. Enter as Admin");
        System.out.println("3. Exit");
        System.out.println("Please enter a option(like 1,2 or 3) for further operations....");
        int opt = sc.nextInt();

        if(opt == 1){
            System.out.println("Welcome User! Please select an option");
            System.out.println("1. Get Decor suggestions");
            System.out.println("2. Review a product");
            System.out.println("3. Exit");
            int opt1 = sc.nextInt();
            switch(opt1){
                case 1:
                    sug.Getsuggestion();
                    break;
                case 2:
                    re.Reviewproduct();
                    break;
                case 3:
                    System.out.println("Thank you! Exiting...");
                    break;
            }
        }else if(opt ==2){
            System.out.println("1. Add products");
            System.out.println("2. Update product");
            System.out.println("3. Delete Product");
            System.out.println("4. Exit");
            int opt2 = sc.nextInt();
            switch(opt2){
                case 1:
                add.addDecorItem();
                break;
                case 2:
                up.updateDecorItem(); 
                break;
                case 3:
                del.deleteDecorItem();
                break;
                case 4:
                System.out.println("Thank you! Exiting...");
                break;
                }
        }else{
            System.out.println("Thank you for using our product. Exiting the application....");
        }
        sc.close();
    }
}