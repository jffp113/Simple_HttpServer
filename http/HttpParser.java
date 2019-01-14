package http;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class intends to be a parser for the Request and Reply of HTTP
 *
 */
public class HttpParser {
	
	public static String HEADER_REPLY_REGEX = "^(?<version>HTTP\\/\\d\\.\\d)\\s(?<code>\\d{3})\\s(?<menssage>\\S*)";
	public static String HEADER_REQUEST_REGEX = "^(?<method>GET|POST|PUT|HEAD|OPTIONS|DELETE)\\s(?<resource>.+)\\s(?<version>HTTP\\/\\d\\.\\d)"; 
	public static String REQUEST_FIELD_REGEX = "^(?<header>\\S+):\\s(?<value>.+)";
	public static String RANGE_REQUEST_REGEX = "^bytes\\s(?<min>\\d*)-(?<max>\\d*)\\/(?<lenght>\\d*)";
	
	public static String readLine(InputStream in) {
		StringBuffer sb = new StringBuffer();
		int c;
		
		try {
			while((c = in.read()) >= 0) {
				
				if(c == '\r')
					continue;
				if(c == '\n')
					break;
				
				sb.append(Character.valueOf((char) c));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	final static Pattern HEADER_REQUEST_PATTERN = Pattern.compile(HEADER_REQUEST_REGEX);	
	
	public static HttpParsedRequestHeader parseRequestHeader(String request) {
		Matcher m = HEADER_REQUEST_PATTERN.matcher(request);
		
		if(!m.matches())
			return null;
		
		return new HttpParsedRequestHeader(m.group("method"),m.group("resource"),m.group("version"));
	}
	
	final static Pattern HEADER_REPLY_PATTERN = Pattern.compile(HEADER_REPLY_REGEX);	
	
	public static String[] parseReply(String request) {
		Matcher m = HEADER_REPLY_PATTERN.matcher(request);
		
		if(!m.matches())
			return null;
		
		return new String[]{m.group("version"),m.group("code"),m.group("menssage")};
	}
	
	final static Pattern REQUEST_FIELD_PATTERN = Pattern.compile(REQUEST_FIELD_REGEX);
	
	public static String[] parseFieldLine(String line) {
		Matcher m = REQUEST_FIELD_PATTERN.matcher(line);
		if(!m.matches())
			return null;
		
		return new String[] {m.group("header"),m.group("value")};
	}
	
	public static long[] parseRanges(String line) { 
		return null;
	}
	

}

