package org.scapi4j.sms;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.gson.Gson;

public class SMS {
	private static final Logger log = LogManager.getLogger(SMS.class.getName());
	private SMSImpl sms = new SMSImpl();
	private String apiKey;

	/**
	 * constructor initializes SMS Impl object
	 */
	public SMS() {
		SMSOutboundMessageRequest smsOutboundMessage = new SMSOutboundMessageRequest();
		smsOutboundMessage.setAddress(new ArrayList<String>());
		SMSOutboundTextMessage sMSOutboundTextMessage = new SMSOutboundTextMessage();
		smsOutboundMessage.setOutboundSMSTextMessage(sMSOutboundTextMessage);
		sms.setOutboundSMSMessageRequest(smsOutboundMessage);
	}

	/**
	 * 
	 * @param receiverAddress
	 * 
	 */
	public void addReceiver(String receiverAddress) {
		// add error handling resp. check if the object are not null
		List<String> list = sms.getOutboundSMSMessageRequest().getAddress();
		list.add("tel:" + receiverAddress);
	}

	/**
	 * 
	 * @param textMessage
	 */
	public void setTextMessage(String textMessage) {
		if (sms != null) {
			if (sms.getOutboundSMSMessageRequest() != null) {
				if (sms.getOutboundSMSMessageRequest()
						.getOutboundSMSTextMessage() != null)
					sms.getOutboundSMSMessageRequest()
							.getOutboundSMSTextMessage()
							.setMessage(textMessage);

			}
		}

	}

	/**
	 * 
	 * @param senderAdress
	 */
	public void setSenderAddress(String senderAdress) {
		if (sms != null) {
			if (sms.getOutboundSMSMessageRequest() != null) {
				sms.getOutboundSMSMessageRequest().setSenderAdress(
						"tel: " + senderAdress);
			}
		}
	}

	public void send() {

		try {
			Gson gson = new Gson();
			String json = gson.toJson(sms);

			// URL
			URL url = new URL(
					"https://api.swisscom.com/v1/messaging/sms/outbound/tel:+41797701816/requests");

			// Verbindung offnen
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

			// Methode
			con.setRequestMethod("POST");
			// Header setzen
			con.setRequestProperty("client_id", apiKey);
			con.setRequestProperty("Accept", "application/json");
			con.setRequestProperty("Content-Type", "application/json");

			con.setDoOutput(true);

			OutputStreamWriter wr = new OutputStreamWriter(
					con.getOutputStream());

			wr.write(json.toString());

			wr.flush();

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

		} catch (Exception e) {
			log.error(sms.toString(), e);
			System.err.println(e);

		}

	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

}
