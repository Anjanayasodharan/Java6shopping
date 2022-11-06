import java.sql.*;
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
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingdb","root","");
                        String sql = "SELECT `productname`, `description`, `mfd`, `brandname`, `price` FROM `products`";
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()){
                            name = rs.getString("productname");
                            String Desc = rs.getString("description");
                            String Manu_date = rs.getString("mfd");
                            String BrandName = rs.getString("brandname");
                            price = rs.getInt("price");
                            System.out.println("productname ="+name);
                            System.out.println("description ="+Desc);
                            System.out.println("mfd ="+Manu_date);
                            System.out.println("brandname ="+BrandName);
                            System.out.println("price ="+price+'\n');
                        }

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 3:
                    System.out.println("Search");
                    System.out.println("Enter the id");
                    int id = sc.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingdb","root","");
                        String sql = "SELECT `id`, `productname`, `description`, `mfd`, `brandname`, `price` FROM `products` WHERE `id`="+id;
                        Statement stmt = con.createStatement();
                        ResultSet rs = stmt.executeQuery(sql);
                        while (rs.next()){
                            name = rs.getString("productname");
                            String Desc = rs.getString("description");
                            String Manu_date = rs.getString("mfd");
                            String BrandName = rs.getString("brandname");
                            price = rs.getInt("price");
                            System.out.println("productname ="+name);
                            System.out.println("description ="+Desc);
                            System.out.println("mfd ="+Manu_date);
                            System.out.println("brandname ="+BrandName);
                            System.out.println("price ="+price+'\n');
                        }

                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 4:
                    System.out.println("Update");
                    System.out.println("Enter the id");
                    id = sc.nextInt();
                    System.out.println("Enter the nme ");
                    name = sc.next();
                    System.out.println("Enter the description ");
                    desname = sc.next();
                    System.out.println("Enter the manufacture date");
                    date = sc.next();
                    System.out.println("Enter the brand name");
                    brandName = sc.next();
                    System.out.println("Enter the price");
                    price = sc.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingdb","root","");
                        String sql = "UPDATE `products` SET `productname`='"+name+"',`description`='"+desname+"',`mfd`='"+date+"',`brandname`='"+brandName+"',`price`='"+price+"' WHERE `id`="+id;
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 5:
                    System.out.println("Delete");
                    System.out.println("Enter the id");
                    id = sc.nextInt();
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoppingdb","root","");
                        String sql = "DELETE FROM `product` WHERE `id`="+id;
                        Statement stmt = con.createStatement();
                        stmt.executeUpdate(sql);
                    }
                    catch (Exception e){
                        System.out.println(e);
                    }
                    break;
                case 6:
                    System.exit(0);
            }
        }
    }
}