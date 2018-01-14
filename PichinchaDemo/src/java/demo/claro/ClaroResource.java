/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.claro;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import dtos.CalendarDTO;
import dtos.Push;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * REST Web Service
 *
 * @author Javier
 */
@Path("cafam")
public class ClaroResource {

    @Context
    private UriInfo context;
    private static String headers = "";
    private static int conteoActividad = 1;
    String mensaje = "{\"message\": \"" ;

    /**
     * Creates a new instance of ClaroResource
     */
    public ClaroResource() {
    }


        
    
      @POST
     @Path("pushnotification")

    @Consumes(MediaType.APPLICATION_JSON)
 public Response createAcitivity(String content) 
 {
      Gson tok = new Gson();
        Push ver = tok.fromJson(content, Push.class);
        
          String  algo = mensaje +=  ver.getMensaje();
          String retorno = "";
          algo = algo + " \"}";
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

		System.out.println("Post Code : " + algo);

		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(algo);
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
                if (responseCode == 201)
                {
                retorno = "OK";
                        }
                else
                {
                                    retorno = "Nope";

                }
       
       } catch (Exception e) {
						e.printStackTrace();
					} 
                    
                    
     
       return Response.status(201).entity(retorno).build();

    }
 
 
 
 
 
 
    
    
    
    
    
    
    
    
    
    
 
    
}
