package callback.example1;

import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements ServerInterface {
	ExecutorService workers = Executors.newFixedThreadPool(10);
	private ServerConnections serverConnectionHandler;

	public Server(int _address) {
		System.out.println("Start server....");
		serverConnectionHandler = new ServerConnections(_address, this);
		workers.execute(serverConnectionHandler);
		System.out.println("Do something else...");
	}

	@Override
	public void newServerConnection(Socket socket) {
		// TODO Auto-generated method stub
		System.out.println("A function of my child class was called.");
	}

}
