package java_nio.Example;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Hello world!
 *
 */
public class WriteBufferToFile {
	public static void main(String[] args) throws IOException {
		ByteBuffer buffer = ByteBuffer.allocate(1024*1024);
		
		System.out.println("Position: "+ buffer.position());
		System.out.println("Limit: " + buffer.limit());
		
		buffer.putInt(10);
		buffer.putInt(20);
		buffer.putInt(30);
		buffer.putInt(40);
		System.out.println("======================================================");
		Path path = Paths.get("files/inits.bin");
		FileChannel fileChannel = FileChannel.open(path,StandardOpenOption.CREATE, StandardOpenOption.WRITE);
		
		buffer.flip();
		fileChannel.write(buffer);		
		System.out.println("File Size: " + Files.size(path));
		
		
		
	}
}
