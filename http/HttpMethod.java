package http;

public enum HttpMethod {
	GET("GET"),
	POST("POST"),
	PUT("PUT"),
	DELETE("DELETE");
	
	private String representation;
	
	private HttpMethod(String representation) {
		this.representation = representation;
	}
	
	public String toString() {
		return this.representation;
	}
}
