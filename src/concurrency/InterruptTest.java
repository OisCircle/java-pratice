package concurrency;

import javax.swing.text.AbstractDocument;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2018/8/2
 */
public class InterruptTest {
	public static void main(String[] args) throws InterruptedException {
		Thread1 thread=new Thread1();
		thread.start();


		Thread.sleep(6000L);
		System.out.println("interrupt...");


	}
}

class Thread1 extends Thread {
	@Override
	public void run() {
		super.run();
		try {
			interrupt();
			System.out.println(isInterrupted());
			while (true) {
				Thread.sleep(2000L);
				System.out.println("sleep 2 seconds...");
			}
		} catch (InterruptedException e) {
			System.out.println("stop sleeping...");
		}
	}
}