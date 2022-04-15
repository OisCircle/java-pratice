package concurrency;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * <p>
 * 通过JAVA API 阻塞队列实现生产者-消费者模式
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/23
 */
public class ConsumerProviderBlockTest {

	private static BlockingQueue<Integer> queue = new LinkedBlockingDeque<>(1);
	private static Random random = new Random();

	public static void main(String[] args) {
		new Thread(new Provider()).start();
		new Thread(new Consumer()).start();
	}

	static class Provider implements Runnable {

		int number = 1;

		@Override
		public void run() {
			try {
				while (true) {
					queue.put(number);
					System.out.println("生产者生产: " + number);
					number++;
					//模拟速度不一致
					Thread.sleep((random.nextInt(3) * 1000) + 1000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static class Consumer implements Runnable {

		@Override
		public void run() {
			try {
				while (true) {
					Integer number = queue.take();
					System.out.println("消费者消费: " + number);

					//模拟速度不一致
					Thread.sleep((random.nextInt(3) * 1000) + 1000);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
