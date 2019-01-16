package http.server;

import java.net.ServerSocket;
import java.util.concurrent.*;


//Request
public class HttpServer {
	public static final int PORT = 8000;
	public static final int THREAD_COUNT = 5;
	
	private static void start() throws Exception {
		
		ServerSocket sk = new ServerSocket(PORT);
		ExecutorService pool = Executors.newFixedThreadPool(THREAD_COUNT);
		
		while(true) {
			pool.submit(new ClientHandler(sk.accept()));
		}
	}
	
	
	
	public static void main(String args[]) {
		try {
			start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
