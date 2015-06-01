package sms;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

import com.google.gson.Gson;


/**
 * 
 * @author Behar
 * Sms senden 
 */
public class Sms {
	
	private String to;  //Telefonnummer
	private String text; //Nachricht
	private int tokenLength;  //??
	private String expireTime; //?
	

	
	/**
	 * @param apiKey
	 * @param sms
	 * @throws IOException 
	 */
	public static void senden (String apiKey, Sms sms) throws IOException {
		try{
			//Json Parameter erstellen 
			Gson gson = new Gson();
			String json = gson.toJson(sms);
			
			//URL 
			URL url = new URL("https://api.swisscom.com/v1/messaging/sms/outbound/tel:+797701816/requests"); 
			
			//Verbindung offnen 
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			//Methode
			con.setRequestMethod("POST");
			//Header setezn 
			con.setRequestProperty("client_id", apiKey);
			con.setRequestProperty("Accept", "application/json; charset=utf-8");
			con.setRequestProperty("Content-Type", "application/json; charset=utf-8");
			
			con.setDoOutput(true);
			
			//Json data im Body hinzufügen 
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		    String param = "json=" + URLEncoder.encode(json, "UTF-8");
		    wr.write(param.getBytes());
		    
		    System.out.println(json);
		    wr.flush();
		    wr.close();
		    
		 // Get the response
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
 
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();
 
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
 
            // 7. Print result
            System.out.println(response.toString());
			
		}
		catch (MalformedURLException e) {
			 e.printStackTrace();
		}
		
	} 
	
	//Getter und  Setter Methoden 
	
	/**
	 * 
	 * @return Nachricht 
	 */
	public String getTo() {
		return to;
	}
	
	/**
	 * 
	 * @param to Telefonnummer des Senders 
	 */
	public void setTo(String to) {
		this.to = to;
	}
	
	/**
	 * @return Nachricht
	 */
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
	public int getTokenLength() {
		return tokenLength;
	}
	
	public void setTokenLength(int tokenLength) {
		this.tokenLength = tokenLength;
	}
	
	public String getExpireTime() {
		return expireTime;
	}
	
	public void setExpireTime(String expireTime) {
		this.expireTime = expireTime;
	}

}
