package callback.example1;

import java.net.Socket;

public interface ServerInterface {
	void newServerConnection(Socket socket);
}
