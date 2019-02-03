package icbloodlog;

import java.util.*;
import java.io.*;
import java.text.*;

/** 
* Program designed for use by first responders to show how much blood is
* able to be sent to a given location from a local hospital.
*/

public class ICBlood {
   
   public static void main(String[] args) {
      
      int number = 0;
      
      Scanner scan = new Scanner(System.in);
      scan.useDelimiter(" ");
      
      HashMap<String, Integer> blood = new HashMap<String, Integer>();
      
      System.out.println("How many types of blood do you need?");
      number = Integer.parseInt(scan.nextLine());
      System.out.println("What type of blood and how much (in pints) do you need? (Put a space between type and pints)");
      
      //String input = scan.nextLine();
      //String[] bloodType = new String[number * 2];
      
      String response = scan.nextLine();
      String[] record = response.split(" ");
      
      for (int i = 0; i + 1 < record.length; i = i + 2) {
         blood.put(record[i], Integer.parseInt(record[i + 1]));
      }
      double x, y = 0;
      System.out.print("Please input your current location (x coordinate): ");
      x = Double.parseDouble(scan.nextLine());
      System.out.print("Please input your current location (y coordinate): ");
      y = Double.parseDouble(scan.nextLine());
      
      DecimalFormat df = new DecimalFormat("#0.0#");
      
      Hospital[] check = new Hospital[3];// number of hospitals in range, initiatilzed at 0 for placeholder.
      check[0] = new Hospital("BEE", 100, 200);
      check[1] = new Hospital("JEW", 200, 400);
      check[2] = new Hospital("A", 20, 30);
      check[0].setHash("AB+", 2);
      check[1].setHash("AB+", 5);
      check[2].setHash("AB+", 8);
      check[0].setHash("A+", 12);
      check[1].setHash("A+", 40);
      check[2].setHash("A+", 34);
      check[0].setHash("A-", 21);
      check[1].setHash("A-", 12);
      check[2].setHash("A-", 17);
      check[0].setHash("B+", 24);
      check[1].setHash("B+", 58);
      check[2].setHash("B+", 9);
      check[0].setHash("B-", 17);
      check[1].setHash("B-", 9);
      check[2].setHash("B-", 70);
      check[0].setHash("AB+", 0);
      check[1].setHash("AB+", 31);
      check[2].setHash("AB+", 4);
      check[0].setHash("AB-", 19);
      check[1].setHash("AB-", 23);
      check[2].setHash("AB-", 31);
      check[0].setHash("O-", 18);
      check[1].setHash("O-", 20);
      check[2].setHash("O-", 33);
      check[0].setHash("O+", 17);
      check[1].setHash("O+", 24);
      check[2].setHash("O+", 7);
      
      
      
      
      try {
         for (int j = 0; j + 1 < record.length; j = j + 2) {
            for (int i = 1; i < check.length; i++) {
               if (check[i - 1].getBlood().get(record[j]) < check[i].getBlood().get(record[j]) && check[i].getBlood().get(record[j]) >= blood.get(record[j]) ) {
                  System.out.println("Hospital " + check[i].getName() + " has the required amount to fulfill your request."); 
                  System.out.println("Hospital " + check[i].getName() + " is " + df.format(Math.sqrt(Math.pow((check[i].getY() - y), 2) + Math.pow((check[i].getX() - x), 2))) + " miles away.\n");  
               }
               else {
                  System.out.println("Hospital " + check[i].getName() + " cannot fulfill request.");
               }
            }
         }
      }
      catch (NullPointerException e) {
         System.out.println("No blood could be found in the given area! ERROR! ERROR!");
      }
      
   }
}