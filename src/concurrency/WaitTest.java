package concurrency;


import com.sun.webkit.dom.DOMWindowImpl;

import static concurrency.WaitTest.success;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2018/8/5
 */
public class WaitTest {
	volatile static boolean success = false;

	public static void main(String[] args) throws InterruptedException {
		Test test = new Test(null);
		Test test1 = new Test(test);
		Test test2 = new Test(test1);


		test.start();
		test1.start();
		Thread.sleep(1000L);
		System.out.println("after 1 s... change boolean");
		success = true;
		System.out.println("start a new thread");
		test2.start();
	}


}

class Test extends Thread {
	Test other;

	public Test(Test other) {
		this.other = other;
	}
	@Override
	public void run() {
		try {
			synchronized (this) {
				while (!success) {
					System.out.println(currentThread().getName() + " wait...");
					this.wait();
				}
				this.notifyAll();
				if (other != null) {
					synchronized (other) {
						other.notifyAll();
					}
				}
				System.out.println(currentThread().getName() + " not success!");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
