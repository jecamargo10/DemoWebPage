/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.claro;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 *
 * @author javie
 */
public class NewClass {
    
        String mensaje = "{\"message\": \"" ;
    public NewClass(String pMensaje)
           {
               mensaje += pMensaje;
    
               mensaje +="\",\n" +
"	    		\"badge\": 5,\n" +
"	    		\"custom\": {\n" +
"	    			\"acme1\": \"value1\",\n" +
"	    			\"acme2\": [\"value2\", \"value3\"]\n" +
"		      	}\n" +
"	  		  }\n" +
"			  }\n" +
"			} ";
               
               
               
               
               
               
               
               
               
               
               
               
                     try {
                    		System.out.println("Inicio Thread");
                        
					
       
     
       
       
         String url = "https://mobile-gse00012378.mobileenv.us2.oraclecloud.com/mobile/system/notifications/notifications";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
con.setRequestProperty("Authorization", "Basic Y2xvdWQuYWRtaW46UXF3ZXIxMjM0");
con.setRequestProperty("Content-Type", "application/json");
con.setRequestProperty("Oracle-Mobile-Backend-ID", "399a7a42-333f-46e7-9c03-114f8657ba76");
con.setRequestProperty("Accept", "application/json");

		System.out.println("Post Code : " + mensaje);

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(mensaje);
		wr.flush();
		wr.close();

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);

		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		//print result
		System.out.println("Response Code : " + responseCode);
       
       } catch (Exception e) {
						e.printStackTrace();
					} 
               
               
            }
    
    
    public static void main (String [ ] args) {

 

new NewClass( "TENGO sueño");
 

        }
    
    
}
