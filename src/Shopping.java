import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        while(true){
            System.out.println("Enter the option below");
            System.out.println("1 :Insert");
            System.out.println("2 :View");
            System.out.println("3 :Search");
            System.out.println("4 :Update");
            System.out.println("5 :Delete");
            System.out.println("6 :exit");

            choice = sc.nextInt();

            switch (choice){
                case 1:
                    System.out.println("Insert");
                    System.out.println("Enter the nme ");
                    String name = sc.next();
                    System.out.println("Enter the description ");
                    String desname = sc.next();
                    System.out.println("Enter the manufacture date");
                    String date = sc.next();
                    System.out.println("Enter the brand name");
                    String brandName = sc.next();
                    System.out.println("Enter the price");
                    int price = sc.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingdb","root","");
                        String sql = "INSERT INTO `products`(`productname`, `description`, `mfd`, `brandname`, `price`) VALUES(?,?,?,?,?)";
                        PreparedStatement stmt = con.prepareStatement(sql);
                        stmt.setString(1,name);
                        stmt.setString(2,desname);
                        stmt.setString(3,date);
                        stmt.setString(4,brandName);
                        stmt.setInt(5,price);
                        stmt.executeUpdate();
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 2:
                    System.out.println("View");
                    break;
                case 3:
                    System.out.println("Search");
                    break;
                case 4:
                    System.out.println("Update");
                    break;
                case 5:
                    System.out.println("Delete");
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}