package java_nio.Example;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channel;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Hello world!
 *
 */
public class WriteCharsetToFileUtf8 {
	public static void main(String[] args) throws IOException {
		Charset utf8 = StandardCharsets.UTF_8;
		
		String hello = "Hello world from khoa Nguyên";
		
		// move string to charBuffer
		CharBuffer charBuffer = CharBuffer.allocate(1024*1024);
		charBuffer.put(hello);
		System.out.println("======================================================");
		System.out.println("Length: " + hello.length());
		System.out.println("Position: " + charBuffer.position());
		System.out.println("Limit: " + charBuffer.limit());
		System.out.println("======================================================");
		
		System.out.println("======================================================");
		System.out.println("Write data to file:");
		System.out.println("======================================================");

		// Move charBuffer to File
		charBuffer.flip();
		ByteBuffer byteBuffer = utf8.encode(charBuffer);
		FileChannel fileChannel = FileChannel.open(Paths.get("files/charset-utf8.txt"), StandardOpenOption.CREATE,StandardOpenOption.WRITE);
		fileChannel.write(byteBuffer);
		
		
	}
}
