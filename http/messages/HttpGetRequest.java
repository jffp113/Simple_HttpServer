package http.messages;

import java.io.InputStream;
import http.HttpMethod;
import http.parser.HttpParsedRequestHeader;

public class HttpGetRequest extends HttpRequest{
	//Constants
	public static final HttpMethod HTTP_POST_REQUEST = HttpMethod.GET; 
	
	public HttpGetRequest(HttpParsedRequestHeader parsedHeader,InputStream in){
		super(HTTP_POST_REQUEST,parsedHeader,in);
	}

	
}
