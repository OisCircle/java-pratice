package concurrency;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CompletableFuture;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2018/8/7
 */
public class PublishTest {
	public static Long start;
	public static Long end;

	public static void main(String[] args) throws InterruptedException {
		Unsafe unsafe = null;
		Thread.sleep(1000L);
		new A(unsafe).start();

		initialize(unsafe);

	}

	public static void initialize(Unsafe unsafe) {
		unsafe = new Unsafe();
		PublishTest.start = System.nanoTime();
		System.out.println("unsafe initialized at " + PublishTest.start);
	}

}

class A extends Thread {
	public A(Unsafe unsafe) {
		this.unsafe = unsafe;
	}

	Unsafe unsafe;

	@Override
	public void run() {
		super.run();
		do {
			PublishTest.end = System.nanoTime();
			System.out.println("thread sees unsafe at " + PublishTest.end);
			System.out.println("time gap : " + (PublishTest.end - PublishTest.start)/1000000D +" ms");
		} while (unsafe != null);
	}
}

class Unsafe {
	int a;
}