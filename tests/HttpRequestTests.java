package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import http.messages.HttpRequest;

public class HttpRequestTests {

	public static final String GET_REQUEST = "GET /hello.htm HTTP/1.1\r\n" + 
											 "User-Agent: Mozilla/4.0 (compatible; MSIE5.01; Windows NT)\r\n" + 
											 "Host: www.tutorialspoint.com\r\n" + 
											 "Accept-Language: en-us\r\n" + 
											 "Accept-Encoding: gzip, deflate\r\n" + 
											 "Connection: Keep-Alive\r\n";
	
	
	private HttpRequest getRequest;
	private InputStream in;
	
	@Before
	public void setUp() {
		System.out.println("Setting it up!");
		
		in = new ByteArrayInputStream(GET_REQUEST.getBytes());
		getRequest = HttpRequest.httpRequestFactory(in);
		
		
	}

	@Test
	public void testGetRequestParser() {
		assertEquals("Mozilla/4.0 (compatible; MSIE5.01; Windows NT)",getRequest.getFieldValue("User-Agent"));
		assertEquals("www.tutorialspoint.com",getRequest.getFieldValue("Host"));
		assertEquals("en-us",getRequest.getFieldValue("Accept-Language"));
		assertEquals("gzip, deflate",getRequest.getFieldValue("Accept-Encoding"));
		assertEquals("Keep-Alive",getRequest.getFieldValue("Connection"));
		
	}
	
	@After
	public void tearDown() throws IOException {
		in.close();
	}

}
