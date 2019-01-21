package java_nio.Example;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class ReadFileToBuffer {
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("files/inits.bin");
		ByteBuffer buffer = ByteBuffer.allocate(1024 * 1024);

		FileChannel fileChannel = FileChannel.open(path, StandardOpenOption.READ);
		fileChannel.read(buffer);

		System.out.println("======================================================");
		System.out.println("File Size: " + Files.size(path));
		System.out.println("Position: " + buffer.position());
		System.out.println("Limit: " + buffer.limit());
		System.out.println("======================================================");

		buffer.flip();
		
		System.out.println("======================================================");
		System.out.println("File Size: " + Files.size(path));
		System.out.println("Position: " + buffer.position());
		System.out.println("Limit: " + buffer.limit());
		System.out.println("======================================================");
		List<Integer> ints = new ArrayList<Integer>();
		IntBuffer intBuffer = buffer.asIntBuffer();

		try {
			while (true) {
				ints.add(intBuffer.get());
			}
		} catch (Exception e) {
		}
		System.out.println("======================================================");
		System.out.println("size: " +ints.size());
		ints.forEach(System.out::println);
		System.out.println("======================================================");

	}
}
