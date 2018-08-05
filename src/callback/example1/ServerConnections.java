package callback.example1;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.logging.Level;

import java.util.logging.Logger;

public class ServerConnections implements Runnable {

	private int serverPort;
	private ServerInterface serverInterface;
	private ServerSocket mainSocket;

	public ServerConnections(int _serverPort, ServerInterface _serverInterface) {
		serverPort = _serverPort;
		serverInterface = _serverInterface;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("starting server Thread");

		if (serverInterface == null) {
			System.out.println("server thread error: callback null");
		}

		try {
			mainSocket = new ServerSocket(serverPort);
			while (true) {
				serverInterface.newServerConnection(mainSocket.accept());
			}
		} catch (IOException e) {
			Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, e);
		}
	}

	public static void main(String[] args) {
		ServerConnections sc = new ServerConnections(8888,new Server(8888));
		
	}
}
