package tests;

import static org.junit.jupiter.api.Assertions.*;

import http.HttpErrorCode;
import http.messages.*;
import junit.framework.TestCase;


public class HttpReplyTests extends TestCase {
	public static final String REPLY_MESSAGE1 = "HTTP/1.1 200 OK\r\n" + 
												"Date: Mon, 27 Jul 2009 12:28:53 GMT\r\n" + 
												"Server: Apache/2.2.14 (Win32)\r\n" + 
												"Last-Modified: Wed, 22 Jul 2009 19:15:56 GMT\r\n" + 
												"Content-Length: 20\r\n" + 
												"Content-Type: text/html\r\n" + 
												"Connection: Closed\r\n" +
												"\r\n" +
												"01234567890123456789";
	//Test Vars
	HttpReply reply;
	
	 @Override
	protected void setUp() {
		System.out.println("Setting it up!");

		
		reply = new HttpReplyClass(HttpErrorCode.SUCCESS_OK);
		reply.appendField("Date", "Mon, 27 Jul 2009 12:28:53 GMT");
		reply.appendField("Server", "Apache/2.2.14 (Win32)");
		reply.appendField("Last-Modified", "Wed, 22 Jul 2009 19:15:56 GMT");
		reply.appendField("Content-Length", "20");
		reply.appendField("Content-Type", "text/html");
		reply.appendField("Connection", "Closed");
		reply.setData("01234567890123456789".getBytes());
	}
	
	
	public void testContentIsEqual() {
		assertArrayEquals(REPLY_MESSAGE1.getBytes(), reply.getHttpReplyBytes());
	}

}
