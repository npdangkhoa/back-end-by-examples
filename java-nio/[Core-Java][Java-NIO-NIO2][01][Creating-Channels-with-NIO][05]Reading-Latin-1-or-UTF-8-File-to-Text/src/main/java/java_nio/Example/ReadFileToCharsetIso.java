package java_nio.Example;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Hello world!
 *
 */
public class ReadFileToCharsetIso {
	public static void main(String[] args) throws IOException {
		Charset charset = StandardCharsets.ISO_8859_1;
		String strPath = "files/charset-iso.txt";

		System.out.println("======================================================");
		System.out.println("Read data from fileChannel to byteBuffer");
		System.out.println("======================================================");

		ByteBuffer byteBuffer = ByteBuffer.allocate(1024*1024);
		
		FileChannel fileChannel = FileChannel.open(Paths.get(strPath), StandardOpenOption.READ);
		fileChannel.read(byteBuffer);
		
		System.out.println("======================================================");
		System.out.println("convert ByteBuffer to charBuffer");
		System.out.println("======================================================");
		
		byteBuffer.flip();
		CharBuffer charBuffer = charset.decode(byteBuffer);
		
		System.out.println("======================================================");
		System.out.println("Position: " + charBuffer.position());
		System.out.println("Limit: " + charBuffer.limit());
		System.out.println("======================================================");
		System.out.println(new String(byteBuffer.array()));
		
	}
}
