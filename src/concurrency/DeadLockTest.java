package concurrency;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/17
 */
public class DeadLockTest {
	public static void main(String[] args) {
		new Thread(new Test1()).start();
		new Thread(new Test2()).start();
	}


}

class Test1 implements Runnable {
	@Override
	public void run() {
		while (true) {
			synchronized (Test1.class) {
				System.out.println("test1 locked");
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("test1 try to get test2's lock");
				synchronized (Test2.class) {
					System.out.println("test1 get test2 lock");
				}
			}
		}
	}
}

class Test2 implements Runnable {
	@Override
	public void run() {
		while (true) {
			synchronized (Test2.class) {
				System.out.println("test2 locked");
				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("test2 try to get test1's lock");
				synchronized (Test1.class) {
					System.out.println("test2 get test1 lock");
				}
			}
		}
	}
}