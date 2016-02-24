/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package JavaFabric;
import java.sql.*;
import java.lang.*;
import java.util.*;
//package javafabric;



/**
 *
 * @author Anjali Menon
 */
public class JavaFabric {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InputMismatchException,Exception{
        // TODO code application logic here

        Class.forName("org.postgresql.Driver");
       
        Connection connection = null;//Getting connection
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ammucute95");
       
         Statement stmt =null;// 
         
         ResultSet rs= null;
     System.out.println("\nEnter the user id : ") ;
     Scanner in = new Scanner(System.in) ;
     String userid = in.next();
     
      String q = ("select userid from users where userid='"+userid+"'");
      stmt=connection.createStatement();
      rs=stmt.executeQuery(q);
      int c=0;//will be changed to 1 when a match is found
      while(rs.next()) {
          String a = rs.getString("userid");
          if(userid.equals(a)) //checks whether userid exist in the database
          {
              System.out.println("\nYou are a registered member.");
              c=1;
          }
         
          
      }
     
       if(c==0)
          {    System.out.println("\nSorry, you are not a registered member") ;
              System.exit(0);
          }
     
     System.out.println("\nWhich action do you want to take?") ;
     System.out.println("\n1. Clothes I have");
     System.out.println("\n2. Clothes in the laundry") ;
     System.out.println("\n3. Add a cloth") ;
     System.out.println("\n4. Shop details of a particular cloth") ;

     
     int option = in.nextInt();
     switch(option) {
         case 1: {
                    System.out.println("\nOn what basis do you want to search?") ;
                    System.out.println("\n1. Cloth id") ;
                    System.out.println("\n2. Cloth Type") ;
                    System.out.println("\n3. Cloth Material") ;
                    System.out.println("\n4. Brand") ;
                    
                    int op1 = in.nextInt();
                    switch(op1) {
                        case 1: {
                                System.out.println("\nEnter the cloth id : ") ;
                                String cid = in.next();
                                String query = (
                                        "select clothid,brand,cost,clothmaterial,clothtype from clothes where clothid='"+cid+"'");
                                stmt=connection.createStatement();
                                rs=stmt.executeQuery(query);
                                 while(rs.next()) {
                                     String ccid = rs.getString("clothid") ;
                                     String brand = rs.getString("brand") ;
                                     String cost = rs.getString("cost");
                                     String clothmat = rs.getString("clothmaterial");
                                     String type = rs.getString("clothtype");
                                     System.out.println("\nThe cloth details are : \nclothid :" + ccid + ", Brand name : " + brand + ", cost : " + cost + ", Cloth Material : " + clothmat);
                                 }
                                }
                                break ;
                        case 2: {
                                    System.out.println("\nEnter the cloth type : ") ;
                                String type = in.next() ;
                                String query = (
                                        "select clothid,brand,cost,clothmaterial,clothtype from clothes where clothtype= '"+type + "'");
                                stmt=connection.createStatement();
                                rs=stmt.executeQuery(query);
                                 while(rs.next()) {
                                     String ccid = rs.getString("clothid") ;
                                     String brand = rs.getString("brand") ;
                                     String cost = rs.getString("cost");
                                     String clothmat = rs.getString("clothmaterial");
                                     String tpe = rs.getString("clothtype");
                                     System.out.println("\nThe cloth details are : \nclothid :" + ccid + ", Brand name : " + brand + ", cost : " + cost + ", Cloth Type : " + tpe + "Cloth material : " + clothmat);
                                 }
                                
                                }
                                break ;
                        case 3: {
                                System.out.println("\nEnter the cloth material : ") ;
                                String clothm = in.next();
                                String query = (
                                        "select clothid,brand,cost,clothmaterial,clothtype from clothes where clothmaterial='"+clothm+"'");
                                stmt=connection.createStatement(); 
                                rs=stmt.executeQuery(query);
                                 while(rs.next()) {
                                     String ccid = rs.getString("clothid") ;
                                     String brand = rs.getString("brand") ;
                                     String cost = rs.getString("cost");
                                     String clothmat = rs.getString("clothmaterial");
                                     String type = rs.getString("clothtype");
                                     System.out.println("\nThe cloth details are : \nclothid :" + ccid + ", Brand name : " + brand + ", cost : " + cost);
                                 }
                                }
                                break ;
                        case 4: {
                                     System.out.println("\nEnter the cloth brand : ") ;
                                String type = in.next() ;
                                String query = (
                                        "select clothid,brand,cost,clothmaterial,clothtype from clothes where brand= '"+type + "'");
                                stmt=connection.createStatement();
                                rs=stmt.executeQuery(query);
                                 while(rs.next()) {
                                     String ccid = rs.getString("clothid") ;
                                     String brand = rs.getString("brand") ;
                                     String cost = rs.getString("cost");
                                     String clothmat = rs.getString("clothmaterial");
                                     String tpe = rs.getString("clothtype");
                                     System.out.println("\nThe cloth details are : \nclothid :" + ccid + ", Brand name : " + brand + ", cost : " + cost + ", Cloth Type : " + tpe + "Cloth material : " + clothmat);
                                 }
                                }
                                break ;
                        default : System.out.println("\nSorry, You entered a wrong option") ;
                        
                    }
            }
         break ;
    
         case 2: {
                      System.out.println("\nEnter the clothid : ") ;
                                String type = in.next() ;
                                String query = (
                                        "select dateofgiving,dateofreceiving from laundry where clothid= '"+type + "'");
                                stmt=connection.createStatement();
                                rs=stmt.executeQuery(query);
                                 while(rs.next()) {
                                     String ccid = rs.getString("dateofgiving") ;
                                     String brand = rs.getString("dateofreceiving") ;
                                      System.out.println("\nThe cloth in laundry are : \ndateofgiving :" + ccid + ", dateofreceiving : " + brand );
                                 }
                 }
                 break;
         case 3: {
                    System.out.println("Enter the clothid ranging from C300 to C100000") ;
                    String id=in.next();
                    System.out.println("Enter the brand") ;
                    String brand=in.next();
                    System.out.println("Enter the cost") ;
                    int cost=in.nextInt();
                    System.out.println("Enter the clothmaterial") ;
                    String mat=in.next();
                    System.out.println("Enter the clothtype") ;
                    String type=in.next();
                    String query = (
                                        "insert into clothes values( '"+id+"','"+brand+"','"+cost+"','"+mat+"','"+type+"')");
                    System.out.println("Cloth successfully added!") ;
                    stmt=connection.createStatement();
                    int s=stmt.executeUpdate(query);
                 }
                 break;
              case 4: {
                    System.out.println("Enter the clothid") ;
                    String id=in.next();
                     String query = (
                                        "select shopid,shopname,locatn,contactno from shop natural join boughtfrom where boughtfrom.clothid='"+id+"'");
                    stmt=connection.createStatement();
                                rs=stmt.executeQuery(query);
                                 while(rs.next()) {
                                     String ccid = rs.getString("shopid") ;
                                     String brand = rs.getString("shopname") ;
                                     String loc=rs.getString("locatn");
                                     String cont=rs.getString("contactno");
                                     System.out.println("\nThe Shop details : \nShopid :" + ccid + ", Shopname : " + brand+", Location:"+loc+", Contact:"+cont );
                                 }
                   
                 }
                 break;
                 
     }
     
     
     
      connection.close();//closing the connection
    }
}
    
    

