package org.scapi4j.sms;

import java.util.ArrayList;
import java.util.List;

public class SMSOutboundMessageRequest {

	String senderAdress;
	List<String> address = new ArrayList<String>();
	SMSOutboundTextMessage outboundSMSTextMessage;
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
	public SMSOutboundTextMessage getOutboundSMSTextMessage() {
		return outboundSMSTextMessage;
	}
	public void setOutboundSMSTextMessage(
			SMSOutboundTextMessage outboundSMSTextMessage) {
		this.outboundSMSTextMessage = outboundSMSTextMessage;
	}
	public String getClientCorrelator() {
		return clientCorrelator;
	}
	public void setClientCorrelator(String clientCorrelator) {
		this.clientCorrelator = clientCorrelator;
	}
	
	
}
