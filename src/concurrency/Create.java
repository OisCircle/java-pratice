package concurrency;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2018/7/26
 */
public class Create {
	public static void main(String[] args) throws InterruptedException {
		Counter counter = new Counter();
//		Thread a = new Thread(new Counter(),"a");
//		Thread b = new Thread(new Counter(),"b");
//		Thread c = new Thread(new Counter(),"c");

		Thread a = new Thread(counter, "a");
		Thread b = new Thread(counter, "b");
		Thread c = new Thread(counter, "c");


		a.start();
		b.start();
		c.start();

		System.out.println(a.isAlive());
		System.out.println(b.isAlive());
		System.out.println(c.isAlive());

		Thread.sleep(1000L);
		System.out.println(a.isAlive());
		System.out.println(b.isAlive());
		System.out.println(c.isAlive());
	}
}

class Counter implements Runnable {
	private int count = 3;


	@Override
	public void run() {
		synchronized (this) {
			while (count > 0) {
				System.out.println(Thread.currentThread().getName() + " count: " + count--);
			}
		}
	}
}