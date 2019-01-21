package java_nio.Example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class UseOfSelector {
	public static void main(String[] args) throws IOException {
		// *****************************************************
		// Setting-up-the-Asynchronous-Server-Socket-Channel
		// *****************************************************

		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		serverSocketChannel.configureBlocking(false);

		ServerSocket serverSocket = serverSocketChannel.socket();
		serverSocket.bind(new InetSocketAddress(12345));

		Selector selector = Selector.open();
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

		// *****************************************************
		// Accepting-an-Incoming-Connection-Request
		// *****************************************************
		while (true) {
			System.out.println("We are waiting for event...");
			int select = selector.select();
			System.out.printf("Got %d event", select);

			Set<SelectionKey> selectionKeys = selector.selectedKeys();
			for (SelectionKey selectionKey : selectionKeys) {

				if ((selectionKey.readyOps() & SelectionKey.OP_ACCEPT) == SelectionKey.OP_ACCEPT) {
					// accept the connection
					System.out.println("Accepting the connection");
					ServerSocketChannel channel = (ServerSocketChannel) selectionKey.channel();
					SocketChannel socketChannel = channel.accept();
					socketChannel.configureBlocking(false);
					socketChannel.register(selector, SelectionKey.OP_READ);
					selectionKeys.remove(selectionKey);

				} else if ((selectionKey.readyOps() & SelectionKey.OP_READ) == SelectionKey.OP_READ) {

					// reading the content
					SocketChannel channel = (SocketChannel) selectionKey.channel();
					ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
					channel.read(byteBuffer);
					byteBuffer.flip();

					CharBuffer charBuffer = StandardCharsets.UTF_8.decode(byteBuffer);
					String result = new String(charBuffer.array());
					System.out.println(result);
					
					byteBuffer.clear();
					charBuffer.clear();
				}
			}
		}

	}
}
