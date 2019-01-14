package http;

public enum HttpErrorCode {
	CONTINUE(100,""),
	SUCCESS_OK(200,"OK"),
	SUCCESS_CREATED(201,""),
	SUCCESS_ACCEPTED(202,""),
	SUCCESS_NONAUTHORITATIVE(203,""),
	ERROR_BADRESQUEST(400,""),
	ERROR_UNAUTHORIZED(401,"");
	
	
	private int value;
	private String menssage;
	
	HttpErrorCode(int value,String menssage) {
		this.value = value;
		this.menssage = menssage;
	}
	
	public String toString() {
		return Integer.toString(value) + " " + menssage;
	}
	
	public int getCode() {
		return value;
	}
	
	public String getMenssage() {
		return menssage;
	}
}
