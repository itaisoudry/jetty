package test;

import java.net.URI;

import javax.websocket.ContainerProvider;
import javax.websocket.WebSocketContainer;

import org.eclipse.jetty.websocket.client.ClientUpgradeRequest;
import org.eclipse.jetty.websocket.client.WebSocketClient;

public class ClientMain implements Runnable {
	private String dest;

	public ClientMain(String dest) {
		this.dest = dest;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		WebSocketClient client = new WebSocketClient();
		try {

			ClientSocket socket = new ClientSocket();
			client.start();
			URI echoUri = new URI(dest);
			ClientUpgradeRequest request = new ClientUpgradeRequest();
			client.connect(socket, echoUri, request);
			socket.getLatch().await();
			ServerSocket server = new ServerSocket();
			socket.sendMessage("echo");
			socket.sendMessage("test");
			// Thread.sleep(10000l);

		} catch (Throwable t) {
			t.printStackTrace();
		} finally {
			try {
				client.stop();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
}
