package concurrency;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * 两个线程分别打印 1- 100，A 打印偶数， B打印奇数
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/14
 */
public class ZeroToHundredTest {
	public static void main(String[] args) throws InterruptedException {
		AtomicInteger atomicInteger = new AtomicInteger(1);
		Thread threadA = new Thread(new ZeroToHundred("--", true, atomicInteger));
		threadA.start();
		Thread threadB = new Thread(new ZeroToHundred("------", false, atomicInteger));
		threadB.start();

		threadA.join();
		threadB.join();
	}
}

class ZeroToHundred implements Runnable {
	String name;
	boolean isOddPrinter;
	AtomicInteger count;

	ZeroToHundred(String name, boolean isOddPrinter, AtomicInteger count) {
		this.name = name;
		this.isOddPrinter = isOddPrinter;
		this.count = count;
	}

	@Override
	public void run() {
		while (count.intValue() <= 100) {
			int value = count.intValue();
			synchronized (ZeroToHundred.class) {
				if (((value & 1) == 1 && isOddPrinter) || ((value & 1) == 0 && !isOddPrinter)) {
					System.out.println(name + count.getAndIncrement());
				}
				ZeroToHundred.class.notify();
				try {
					//为什么要这样判断？不然最后一个线程自己wait了，没有别的线程notify他
					if (count.intValue() <= 100) {
						ZeroToHundred.class.wait();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
