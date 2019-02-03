/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icbloodlog;

/**
 *
 * @author JohnS
 */
import java.net.*;
import java.io.*;

public class MapRequest {
    
    public String findHospital(String cityIn, String stateIn) throws Exception {
        
        URL maps = new URL("https://maps.googleapis.com/maps/api/place/findplacefromtext/json?"
        +"input=Hospital&inputtype=textquery&fields=name"
        +"&key=AIzaSyDtj14ViIIhGFhXaYCC8VWBmHHonoKN2mw");
        
        String city = cityIn.replaceAll("\\s", "+");
        String state = stateIn.replaceAll("\\s", "+");
        
        URL latNlon = new URL("https://maps.googleapis.com/maps/api/geocode/xml?"
                + "address=" + city + "," + state + "&"
                + "key=AIzaSyDtj14ViIIhGFhXaYCC8VWBmHHonoKN2mw");
        
        URLConnection yc = maps.openConnection();
        
        URLConnection LL = latNlon.openConnection();
        
        try (BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()))) {
            String inputLine;
            
            while ((inputLine = in.readLine()) != null)
                return inputLine;
        }
        
        try (BufferedReader in2 = new BufferedReader(new InputStreamReader(LL.getInputStream()))) {
            String inputLine2;
            
            while ((inputLine2 = in2.readLine()) != null)
                return inputLine2;
        }
        return null;
    }
  
}