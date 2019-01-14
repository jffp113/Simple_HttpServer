package http.messages;
import http.HttpErrorCode;

public class HttpReplyClass implements HttpReply {
	public static final String DEFAULT_HTTP_VERSION = "HTTP/1.1";
	private static final String HEADER_FORMAT = "%s %s\r\n";
	private static final String FIELD_FORMAT = 	"%s: %s\r\n";
	private static final String TO_STRING_FORMAT = "%s\r\n%s";
	
	private HttpErrorCode code;
	private String httpVersion;
	
	private StringBuffer message;
	private byte[] payload;

	public HttpReplyClass(HttpErrorCode code) {
		super();
		this.code = code;
		payload = null;
		httpVersion = DEFAULT_HTTP_VERSION;
		message = new StringBuffer();
		appendHeader();
	}
	
	private void appendHeader() {
		message.append(String.format(HEADER_FORMAT, this.getVersion() 
									, code));
	}
	
	public void appendField(String key, String value) {
		message.append(String.format(FIELD_FORMAT, key, value));
	}
	
	public void setData(byte[] payload) {
		this.payload = payload;
	}
	
	
	public int getCode() {
		return code.getCode();
	}
	
	public String getVersion() {
		return this.httpVersion;
	}

	public String getMenssage() {
		return code.getMenssage();
	}
	
	public byte[] getHttpReplyBytes(){
		return this.toString().getBytes();
	}
	
	public String toString() {
		return String.format(TO_STRING_FORMAT,message.toString(), new String(payload));
	}
	
}
