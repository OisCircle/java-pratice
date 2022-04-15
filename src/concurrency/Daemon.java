package concurrency;

/**
 * <p>
 * 只要当前JVM实例中尚存在任何一个非守护线程没有结束，守护线程就全部工作；只有当最后一个非守护线程结束时，守护线程随着JVM一同结束工作
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

class T extends Thread {

	@Override
	public void run() {
		while (true) {
			System.out.println("守护线程工作中");
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}