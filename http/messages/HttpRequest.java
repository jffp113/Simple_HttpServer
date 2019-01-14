package http.messages;

import java.io.InputStream;

import http.*;
import http.parser.HttpParsedRequestHeader;
import http.parser.HttpParser;

public abstract class HttpRequest {
	//Constants
	public static final String DEFAULT_SERVER_VERSION = "HTTP/1.1";
	private static final String HEADER_FORMAT = "%s %s %s\r\n";
	private static final String FIELD_FORMAT = "%s: %s\r\n";
	private static final String RETURN_LINE = "\r\n";
	
	//Variables
	private HttpMethod method;
	private String resource, version;
	
	
	
	//private 
	
	protected HttpRequest(HttpMethod method,HttpParsedRequestHeader parsedHeader, InputStream in){
		this.method = method;
		this.resource = parsedHeader.getResource();
		this.version = parsedHeader.getVersion();
		parseInputStream(in);
	}
	
	private void parseInputStream(InputStream in) {
		//TODO
	}
	
	public static HttpRequest httpRequestFactory(InputStream in) {
		String header = HttpParser.readLine(in);
		HttpParsedRequestHeader parsedHeader = HttpParser.parseRequestHeader(header);
		return httpRequestCreator(parsedHeader, in);
	}
	 
	private static HttpRequest httpRequestCreator(HttpParsedRequestHeader parsedHeader,InputStream in) {
		HttpRequest request = null;
		
		switch(parsedHeader.getMethod()) {
			case "GET": request =  new HttpGetRequest(parsedHeader,in);
						break;
			//TODO
		}
		
		return request;
		
	}

	
	
}

