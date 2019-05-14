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
public class Daemon {
	public static void main(String[] args) throws InterruptedException {
		T t = new T();
		t.setDaemon(true);
		System.out.println("t is alive: " + t.isAlive());
		t.start();
		System.out.println("t is alive: " + t.isAlive());

		Thread.sleep(20L);
		System.out.println("t is alive: " + t.isAlive());
		Thread.sleep(20L);
		System.out.println("t is alive: " + t.isAlive());
	}
}

class T extends Thread{
	@Override
	public void run() {
		System.out.println("start...没有end则该线程是守护线程");
		try {
			Thread.sleep(1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("end...");
	}
}