package icbloodlog;

import java.util.*;
import java.io.*;

public class Hospital {
    
   HashMap<String, Integer> blood = new HashMap<String, Integer>();
   String name;
   double x, y;
      
   public Hospital(String nameIn, double xIn, double yIn){
      name = nameIn;
      x = xIn;
      y = yIn;
   }

   public void setHash(String a, Integer b) {
      blood.put(a, b);
   }
   
   public HashMap<String, Integer> getBlood() {
      return blood;
   }
   
   public void setName(String a) {
      name = a;
   }
   
   public String getName() {
      return name;
   }
   
   public double getX() {
      return x;
   }
   
   public double getY() {
      return y;
   }
   
   
}