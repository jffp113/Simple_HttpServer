package http.server;
import java.io.*;
import java.net.Socket;
import java.util.Iterator;

import http.HttpReplyClass;
import http.messages.HttpReply;
import http.messages.HttpRequest;

public class ClientHandler implements Runnable {

	private Socket socket;
	
	public ClientHandler(Socket socket) {
		this.socket = socket;
	}
	
	public HttpRequest getRequest(InputStream in) {
		return HttpRequest.httpRequestFactory(in);
	}
	
	@Override
	public void run() {
		HttpRequest request = null;
		HttpReply reply = null;
		//TODO
		
	}
}
