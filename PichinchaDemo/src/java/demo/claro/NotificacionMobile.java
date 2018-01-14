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
 * @author Javier
 */
public class NotificacionMobile  implements Runnable {

    String mensaje = "{\"template\": {\n" +
"	    	\"name\": \"#default\",\n" +
"	    	\"parameters\": {\n" +
"	    		\"title\": \"Sale On Now!\",\n" +
"	    		\"body\": \" ";
           public NotificacionMobile (String pMensaje)
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
            }
    
    
    
    @Override
    public void run() {
       try {
                    		System.out.println("Inicio Thread");
                        
						Thread.sleep(180000);
					
       
     
       
       
         String url = "https://mobile-gse00003002.mobileenv.us2.oraclecloud.com/mobile/system/notifications/notifications";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		//add reuqest header
		con.setRequestMethod("POST");
con.setRequestProperty("Authorization", "Basic Y2xvdWQuYWRtaW46U2hlRXJAMUthblNhcw==");
con.setRequestProperty("Content-Type", "application/json");
con.setRequestProperty("Oracle-Mobile-Backend-ID", "a9190bf7-0cad-4cda-bbe2-d5cbdf82af4b");

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
    
}
