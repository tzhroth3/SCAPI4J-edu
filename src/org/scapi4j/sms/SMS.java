package org.scapi4j.sms;

import java.util.ArrayList;
import java.util.List;

public class SMS {
	private SMSImpl sms = new SMSImpl();

	/**
	 * 
	 */
	SMS() {
		SMSOutboundMessageRequest smsOutboundMessage = new SMSOutboundMessageRequest();
		smsOutboundMessage.setAddress(new ArrayList<String>());
		SMSOutboundTextMessage sMSOutboundTextMessage = new SMSOutboundTextMessage();
		smsOutboundMessage.setOutboundSMSTextMessage(sMSOutboundTextMessage);
		sms.setOutboundSMSMessageRequest(smsOutboundMessage);
	}

	/**
	 * 
	 * @param receiverAddress
	 */
	public void addReceiver(String receiverAddress) {
		List<String> list = sms.getOutboundSMSMessageRequest().getAddress();
		list.add(receiverAddress);
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
				sms.getOutboundSMSMessageRequest()
						.setSenderAdress(senderAdress);
			}
		}
	}

}
