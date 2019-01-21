package java_nio.Example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * Hello world!
 *
 */
public class UseOfSelector {
	public static void main(String[] args) throws IOException {
		 ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		 serverSocketChannel.configureBlocking(false);
		 
		 ServerSocket serverSocket = serverSocketChannel.socket();
		 serverSocket.bind(new InetSocketAddress(12345));
		 
		 Selector selector = Selector.open();
		 serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		
	}
}
