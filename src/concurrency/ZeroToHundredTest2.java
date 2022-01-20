package concurrency;

/**
 * @author qiuchengquan
 * @since 2021/8/1
 */
public class ZeroToHundredTest2 {

	private static int count = 1;

	public static void main(String[] args) {
		new Thread(() -> {
			synchronized (ZeroToHundredTest2.class) {
				while (count <= 100) {
					System.out.println("----> " + count++);
					ZeroToHundredTest2.class.notify();
					if (count <= 100) {
						try {
							ZeroToHundredTest2.class.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}).start();

		new Thread(() -> {
			synchronized (ZeroToHundredTest2.class) {
				while (count <= 100) {
					System.out.println("--> " + count++);
					ZeroToHundredTest2.class.notify();
					if (count <= 100) {
						try {
							ZeroToHundredTest2.class.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
			}
		}).start();
	}
}
