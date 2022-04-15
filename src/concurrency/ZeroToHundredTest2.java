package concurrency;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替打印奇偶
 * <p>
 * 使用lock&conditio/synchronized 实现
 * <p>
 * 关键点
 * <p>
 * 1 要保证两条线程都能正常退出（最后一次打印的时候，不需要await了，否则另一条线程无法结束）
 *
 * 2 condition配合await、signal方法使用，Object配合wait、notify方法使用
 *
 * 3 await方法，会放弃当前锁的占有，所以调用前必须是先持有锁的，也就是要在lock.lock、lock.unlock里面使用，不然会抛IllegalMonitorStateException
 *
 * @author qiuchengquan
 * @since 2021/8/1
 */
public class ZeroToHundredTest2 {

	private static int count = 1;
	private static ReentrantLock lock = new ReentrantLock();

	public static void main(String[] args) throws Exception {
		Condition condition = lock.newCondition();

		new Thread(() -> {
			try {
				while (count <= 100) {
					lock.lock();
					System.out.println("--> " + count++);
					condition.signal();
					//防止线程无法终止
					if (count <= 100) {
						condition.await();
					}
					lock.unlock();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}).start();

		new Thread(() -> {
			try {
				while (count <= 100) {
					lock.lock();
					System.out.println("-----> " + count++);
					condition.signal();
					//防止线程无法终止
					if (count <= 100) {
						condition.await();
					}
					lock.unlock();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}).start();
	}

	//使用synchronized、wait、notify机制，一样的，要注意wait方法调用前自身必须持有锁
	public void test() {
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