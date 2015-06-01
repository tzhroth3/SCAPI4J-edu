package org.scapi4j.edu;

import java.util.ArrayList;
import java.util.List;

public class SmsOutboundMessageRequest {

	String senderAdress;
	List<String> address = new ArrayList<String>();
	SmsOutboundTextMessage outboundSMSTextMessage;
	String clientCorrelator = "anyID";
	
	public String getSenderAdress() {
		return senderAdress;
	}
	public void setSenderAdress(String senderAdress) {
		this.senderAdress = senderAdress;
	}
	public List<String> getAddress() {
		return address;
	}
	public void setAddress(List<String> address) {
		this.address = address;
	}
	public SmsOutboundTextMessage getOutboundSMSTextMessage() {
		return outboundSMSTextMessage;
	}
	public void setOutboundSMSTextMessage(
			SmsOutboundTextMessage outboundSMSTextMessage) {
		this.outboundSMSTextMessage = outboundSMSTextMessage;
	}
	public String getClientCorrelator() {
		return clientCorrelator;
	}
	public void setClientCorrelator(String clientCorrelator) {
		this.clientCorrelator = clientCorrelator;
	}
	
	
}
