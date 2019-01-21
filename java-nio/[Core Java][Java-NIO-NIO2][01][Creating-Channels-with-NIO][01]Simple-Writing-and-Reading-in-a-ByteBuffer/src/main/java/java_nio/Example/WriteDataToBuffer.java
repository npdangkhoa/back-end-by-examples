package java_nio.Example;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * Hello world!
 *
 */
public class WriteDataToBuffer {
	public static void main(String[] args) {
		ByteBuffer buffer = ByteBuffer.allocate(1024*1024);
		
		System.out.println("Position: "+ buffer.position());
		System.out.println("Limit: " + buffer.limit());
		
		buffer.putInt(10);
		buffer.putInt(20);
		buffer.putInt(30);
		buffer.putInt(40);
		System.out.println("======================================================");

		System.out.println("Position: "+ buffer.position());
		System.out.println("Limit: " + buffer.limit());
		System.out.println("======================================================");
		//get intBuffer
		IntBuffer intBuffer = buffer.asIntBuffer();
		int i = intBuffer.get();
		System.out.println("intBuffer: " + i);
		System.out.println("Position: "+ intBuffer.position());
		System.out.println("Limit: " + intBuffer.limit());
		System.out.println("======================================================");

		//get initBuffer
		buffer.flip();
		IntBuffer intBuffer2 = buffer.asIntBuffer();
		System.out.println("Position: "+ intBuffer2.position());
		System.out.println("Limit: " + intBuffer2.limit());
		System.out.println("======================================================");

		for(int j = 1;j <= intBuffer2.limit(); j ++) {
			i = intBuffer2.get();
			System.out.println("intBuffer: " + i);
			System.out.println("Position: "+ intBuffer2.position());
			System.out.println("Limit: " + intBuffer2.limit());
			System.out.println("======================================================");

		}
		
	}
}
