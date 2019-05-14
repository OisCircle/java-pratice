package concurrency;

import java.util.concurrent.Semaphore;

/**
 * <p>
 * 阻塞型
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2018/7/31
 */
public class SemaphoreTest {
	public static void main(String[] args){
		Semaphore wc = new Semaphore(2,true);
		for (int i = 0; i < 4; ++i) {
			new Person(i,wc).start();
		}


	}
}

class Person extends Thread {
	Person(int num,Semaphore wc) {
		this.num = num;
		this.wc = wc;
	}
	private int num;
	private Semaphore wc;
	@Override
	public void run() {
		super.run();
		try {
			wc.acquire();
			System.out.println("工人 " + num + " 进入厕所...");
			Thread.sleep(2000L);
			System.out.println("工人 " + num + " 离开厕所...");
			wc.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}