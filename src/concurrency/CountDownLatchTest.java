package concurrency;

import java.sql.SQLOutput;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;
import java.util.stream.Stream;

/**
 * <p>
 * 多个线程同时启动,使用CountDownLatch来实现
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2018/7/31
 */
public class CountDownLatchTest {
	public static final int THREAD = 3;

	public static void main(String[] args) throws Exception {

		CountDownLatch startGate = new CountDownLatch(1);
		CountDownLatch endGate = new CountDownLatch(THREAD);

//		Stream
//				.iterate(0, i->{return ++i;})
//				.limit(THREAD)
//				.forEach(i->{
//					CompletableFuture.supplyAsync(() -> {
//						try {
//							System.out.println("wait for gate open...");
//							startGate.await();
//							System.out.println("gate has open , run task...");
//						} catch (InterruptedException e) {
//							e.printStackTrace();
//						}
//						return null;
//					}).whenCompleteAsync((u, throwable) -> {
//						endGate.countDown();
//					});
//				});

		for (int i = 0; i < THREAD; i++) {
			new Thread(() -> {
				try {
					System.out.println("wait for gate open...");
					startGate.await();
					System.out.println("gate has open , run task...");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}finally {
					endGate.countDown();
				}
			}).start();
		}
		Thread.sleep(1000L);
		System.out.println("open the gate...");
		startGate.countDown();
		System.out.println("awaiting...");
		endGate.await();
		System.out.println("job all done");
	}
}
