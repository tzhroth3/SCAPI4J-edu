package sms;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.scapi4j.sms.SMSImpl;
import org.scapi4j.sms.SMSOutboundMessageRequest;
import org.scapi4j.sms.SMSOutboundTextMessage;

import com.google.gson.Gson;

public class Send {

	public static void main(String[] arg) throws IOException {

		SMSImpl sms = new SMSImpl();

		SMSOutboundMessageRequest smsOutboundMessage = new SMSOutboundMessageRequest();
		smsOutboundMessage.setSenderAdress("+417977011816");
		List listA = new ArrayList();
		
		listA.add("+41797701816");

		smsOutboundMessage.setAddress(listA);

		SMSOutboundTextMessage sMSOutboundTextMessage = new SMSOutboundTextMessage();
		smsOutboundMessage.setOutboundSMSTextMessage(sMSOutboundTextMessage);

		sms.setOutboundSMSMessageRequest(smsOutboundMessage);

		
		//sms.getOutboundSMSMessageRequest().getOutboundSMSTextMessage().setMessage(message);
		
		senden("FCJq8KaXtBFeqeecccw71RcjS8Ns7plb", sms);

	}

	public static void senden(String apiKey, SMSImpl sms) throws IOException {
		try {
			// Json Parameter erstellen
			Gson gson = new Gson();
			String json = gson.toJson(sms);

			// URL
			URL url = new URL(
					"https://api.swisscom.com/v1/messaging/sms/outbound/tel:+41797701816/requests");

			// Verbindung offnen
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

			// Methode
			con.setRequestMethod("POST");
			// Header setezn
			con.setRequestProperty("client_id", apiKey);
			con.setRequestProperty("Accept", "application/json; charset=utf-8");
			con.setRequestProperty("Content-Type",
					"application/json; charset=utf-8");

			con.setDoOutput(true);

			
			OutputStreamWriter wr= new OutputStreamWriter(con.getOutputStream());

			wr.write(json.toString());

			wr.flush();
			/*
			// Json data im Body hinzufügen
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			
			
			String param = "json=" + URLEncoder.encode(json, "UTF-8");
			// wr.write(param.getBytes());
			wr.write(json.toString());
*/
			System.out.println("JSON OBJECT: " + json);
			wr.flush();
			wr.close();

			// Get the response
			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(new InputStreamReader(
					con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// 7. Print result
			System.out.println(response.toString());

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}

	}

}
