package sms;

import java.io.IOException;

import org.scapi4j.sms.SMS;

/**
 * Test class für SMS
 * @author TZHROTH3
 *
 */

public class Send {

	public static void main(String[] arg) throws IOException {
		
		
		SMS sms = new SMS();
		sms.setTextMessage("Hello World from your first Java API Class! Congrat Behar!");
		sms.setSenderAddress("+41797701816");
		sms.addReceiver("+41797701816");
		sms.addReceiver("+41792349619");
		sms.setApiKey("FCJq8KaXtBFeqeecccw71RcjS8Ns7plb");
		sms.send();
	

	}

	

}
