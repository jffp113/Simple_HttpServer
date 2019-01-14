package http.messages;

public interface HttpReply {
	public byte[] getHttpReplyBytes();
	public String getMenssage();
	public String getVersion();
	public int getCode();
	public void setData(byte[] payload);
	public void appendField(String key, String value);
}
