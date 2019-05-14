package concurrency;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <p>
 * 通过synchronized（获取公共资源appleQueue的锁），结合wait/notify机制实现生产者-消费者模式
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/5
 */
public class ConsumerProviderSyncTest {
	public static void main(String[] args) {
		AppleTable table = new AppleTable();
		Thread consumer = new Thread(new Consumer(table));
		Thread provider = new Thread(new Provider(table));
		consumer.start();
		provider.start();
	}


}

class Consumer implements Runnable {
	private AppleTable table;

	Consumer(AppleTable table) {
		this.table = table;
	}

	@Override
	public void run() {
		while (true) {
			Queue<Apple> appleQueue = table.appleQueue;
			synchronized (table) {
				table.notify();
				if (appleQueue.size() > 0) {
					System.out.println("consume apple: " + appleQueue.poll().toString());
					System.out.println("consumer -> apple -1 ... current apple : " + appleQueue.size());
				} else {
					try {
						System.out.println("consumer -> waiting for provider ... ");
						table.wait();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			//模拟速度不一致
			try {
				Thread.sleep((long) ((Math.random() * 100) + 1));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

class Provider implements Runnable {
	private AppleTable table;

	Provider(AppleTable table) {
		this.table = table;
	}

	static int WEIGHT = 1;
	static final String COLOR = "red";

	@Override
	public void run() {
		while (true) {
			if (WEIGHT == 22) {
				System.exit(0);
			}
			synchronized (table) {
				table.notify();
				Queue<Apple> appleQueue = table.appleQueue;
				final int limit = table.limit;
				if (appleQueue.size() < limit) {
					appleQueue.offer(new Apple(WEIGHT++, COLOR));
					System.out.println("provider -> apple +1 ... current apple : " + appleQueue.size());
				} else {
					try {
						System.out.println("provider -> waiting for consumer ... ");
						table.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
			//模拟速度不一致
			try {
				Thread.sleep((long) ((Math.random() * 100) + 1));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

class AppleTable {
	Queue<Apple> appleQueue = new LinkedList<>();
	final int limit = 3;
}

class Apple {
	public Apple(int weight, String color) {
		this.weight = weight;
		this.color = color;
	}

	int weight;
	String color;

	@Override
	public String toString() {
		return "Apple[WEIGHT: " + weight + " COLOR: " + color + "]";
	}
}