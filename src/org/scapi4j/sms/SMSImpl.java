package org.scapi4j.sms;

/**
 * 
 * @author TZHROTH3
 *
 *
 */

public class SMSImpl {

	private SMSOutboundMessageRequest outboundSMSMessageRequest;

	public SMSOutboundMessageRequest getOutboundSMSMessageRequest() {
		return outboundSMSMessageRequest;
	}

	public void setOutboundSMSMessageRequest(
			SMSOutboundMessageRequest outboundSMSMessageRequest) {
		this.outboundSMSMessageRequest = outboundSMSMessageRequest;
	}

	public void init() {

	}

}
