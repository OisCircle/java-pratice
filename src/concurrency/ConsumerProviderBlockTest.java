package concurrency;

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
	//这个构造函数有点奇怪，capacity为1代表最多2个队列元素
	private static BlockingQueue<Integer> queue = new LinkedBlockingDeque<>(1);

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
					System.out.println("生产者生产: " + number);
					System.out.println("当前队列长度: " + queue.size());
					queue.put(number++);
					//模拟速度不一致
					Thread.sleep((long) ((Math.random() * 3000) + 1));
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
					System.out.println("当前队列长度: " + queue.size());

					//模拟速度不一致
					Thread.sleep((long) ((Math.random() * 3000) + 1));
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
