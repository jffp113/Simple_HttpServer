package http.parser;

public class HttpParsedRequestHeader {
	private String method;
	private String resource;
	private String version;
	
	
	public HttpParsedRequestHeader(String method, String resource, String version) {
		this.method = method;
		this.resource = resource;
		this.version = version;
	}
	
	public String getMethod() {
		return method;
	}
	
	public String getResource() {
		return resource;
	}
	
	public String getVersion() {
		return version;
	}
}
