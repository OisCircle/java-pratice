package concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * 编写一个可以从 1 到 n 输出代表这个数字的字符串的程序，但是：
 * <p>
 * 如果这个数字可以被 3 整除，输出 "fizz"。 如果这个数字可以被 5 整除，输出 "buzz"。 如果这个数字可以同时被 3 和 5 整除，输出 "fizzbuzz"。 例如，当 n = 15，输出： 1, 2, fizz, 4, buzz, fizz, 7, 8, fizz, buzz, 11, fizz, 13, 14, fizzbuzz。
 * <p>
 * 假设有这么一个类：
 * <p>
 * class FizzBuzz {   public FizzBuzz(int n) { ... }               // constructor public void fizz(printFizz) { ... }          // only output "fizz" public void buzz(printBuzz) { ... }          // only output "buzz" public void fizzbuzz(printFizzBuzz) { ... }  // only output "fizzbuzz" public void
 * number(printNumber) { ... }      // only output the numbers } 请你实现一个有四个线程的多线程版  FizzBuzz， 同一个 FizzBuzz 实例会被如下四个线程使用：
 * <p>
 * 线程A将调用 fizz() 来判断是否能被 3 整除，如果可以，则输出 fizz。 线程B将调用 buzz() 来判断是否能被 5 整除，如果可以，则输出 buzz。 线程C将调用 fizzbuzz() 来判断是否同时能被 3 和 5 整除，如果可以，则输出 fizzbuzz。 线程D将调用 number() 来实现输出既不能被 3 整除也不能被 5 整除的数字。
 * <p>
 * 来源：力扣（LeetCode） 链接：https://leetcode-cn.com/problems/fizz-buzz-multithreaded 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 *
 * --- 深刻教训 --- 玩Lock必须要try catch finally，lock一定要在接在try的下面一行，await、notify前必须要持有锁
 * --- 深刻教训 --- 玩Lock必须要try catch finally，lock一定要在接在try的下面一行，await、notify前必须要持有锁
 * --- 深刻教训 --- 玩Lock必须要try catch finally，lock一定要在接在try的下面一行，await、notify前必须要持有锁
 * --- 深刻教训 --- 玩Lock必须要try catch finally，lock一定要在接在try的下面一行，await、notify前必须要持有锁
 * --- 深刻教训 --- 玩Lock必须要try catch finally，lock一定要在接在try的下面一行，await、notify前必须要持有锁
 * --- 深刻教训 --- 玩Lock必须要try catch finally，lock一定要在接在try的下面一行，await、notify前必须要持有锁
 * --- 深刻教训 --- 玩Lock必须要try catch finally，lock一定要在接在try的下面一行，await、notify前必须要持有锁
 * --- 深刻教训 --- 玩Lock必须要try catch finally，lock一定要在接在try的下面一行，await、notify前必须要持有锁
 * --- 深刻教训 --- 玩Lock必须要try catch finally，lock一定要在接在try的下面一行，await、notify前必须要持有锁
 * --- 深刻教训 --- 玩Lock必须要try catch finally，lock一定要在接在try的下面一行，await、notify前必须要持有锁
 * --- 深刻教训 --- 玩Lock必须要try catch finally，lock一定要在接在try的下面一行，await、notify前必须要持有锁
 * --- 深刻教训 --- 玩Lock必须要try catch finally，lock一定要在接在try的下面一行，await、notify前必须要持有锁
 * --- 深刻教训 --- 玩Lock必须要try catch finally，lock一定要在接在try的下面一行，await、notify前必须要持有锁
 * --- 深刻教训 --- 玩Lock必须要try catch finally，lock一定要在接在try的下面一行，await、notify前必须要持有锁
 * --- 深刻教训 --- 玩Lock必须要try catch finally，lock一定要在接在try的下面一行，await、notify前必须要持有锁
 * --- 深刻教训 --- 玩Lock必须要try catch finally，lock一定要在接在try的下面一行，await、notify前必须要持有锁
 * --- 深刻教训 --- 玩Lock必须要try catch finally，lock一定要在接在try的下面一行，await、notify前必须要持有锁
 * --- 深刻教训 --- 玩Lock必须要try catch finally，lock一定要在接在try的下面一行，await、notify前必须要持有锁
 * --- 深刻教训 --- 玩Lock必须要try catch finally，lock一定要在接在try的下面一行，await、notify前必须要持有锁
 * --- 深刻教训 --- 玩Lock必须要try catch finally，lock一定要在接在try的下面一行，await、notify前必须要持有锁
 * --- 深刻教训 --- 玩Lock必须要try catch finally，lock一定要在接在try的下面一行，await、notify前必须要持有锁
 * --- 深刻教训 --- 玩Lock必须要try catch finally，lock一定要在接在try的下面一行，await、notify前必须要持有锁
 * --- 深刻教训 --- 玩Lock必须要try catch finally，lock一定要在接在try的下面一行，await、notify前必须要持有锁
 * --- 深刻教训 --- 玩Lock必须要try catch finally，lock一定要在接在try的下面一行，await、notify前必须要持有锁
 * --- 深刻教训 --- 玩Lock必须要try catch finally，lock一定要在接在try的下面一行，await、notify前必须要持有锁
 */
class FizzBuzz {

	private int n;
	private volatile int cur = 1;
	private ReentrantLock lock;
	private Condition fizzCondition;
	private Condition buzzCondition;
	private Condition fizzBuzzCondition;
	private Condition numCondition;
	private volatile boolean numberTurn = true;

	public static void main(String[] args) {
		FizzBuzz fizzBuzz = new FizzBuzz(5);
		new Thread(() -> {
			try {
				fizzBuzz.fizz(() -> System.out.println("fizz"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		new Thread(() -> {
			try {
				fizzBuzz.buzz(() -> System.out.println("buzz"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		new Thread(() -> {
			try {
				fizzBuzz.fizzbuzz(() -> System.out.println("fizzBuzz"));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		new Thread(() -> {
			try {
				fizzBuzz.number(System.out::println);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();
	}

	public FizzBuzz(int n) {
		this.n = n;
		lock = new ReentrantLock();
		fizzCondition = lock.newCondition();
		buzzCondition = lock.newCondition();
		numCondition = lock.newCondition();
		fizzBuzzCondition = lock.newCondition();
	}

	// printFizz.run() outputs "fizz".
	public void fizz(Runnable printFizz) throws InterruptedException {
		while (cur <= n) {
			try {
				lock.lock();
				System.out.println("lock fizz");
				if (numberTurn) {
					System.out.println("number turn fizzCondition.await();");
					fizzCondition.await();
					continue;
				}
				System.out.println("printFizz.run()");
				printFizz.run();
				numCondition.signal();
				fizzCondition.await();
				System.out.println("fizzCondition await end");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
		System.out.println("fizz --- end");
	}

	// printBuzz.run() outputs "buzz".
	public void buzz(Runnable printBuzz) throws InterruptedException {
		while (cur <= n) {
			try {
				lock.lock();
				System.out.println("lock buzz");
				if (numberTurn) {
					System.out.println("number turn buzzCondition.await();");
					buzzCondition.await();
					continue;
				}
				System.out.println("printBuzz.run()");
				printBuzz.run();
				numCondition.signal();
				buzzCondition.await();
				System.out.println("buzzCondition await end");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
		System.out.println("buzz --- end");
	}

	// printFizzBuzz.run() outputs "fizzbuzz".
	public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		while (cur <= n) {
			try {
				lock.lock();
				System.out.println("lock fizzbuzz");
				if (numberTurn) {
					System.out.println("number turn fizzBuzzCondition.await();");
					fizzBuzzCondition.await();
					continue;
				}
				System.out.println("printFizzBuzz.run()");
				printFizzBuzz.run();
				numCondition.signal();
				fizzBuzzCondition.await();
				System.out.println("fizzBuzzCondition await end");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
		System.out.println("fizzbuzz --- end");
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public void number(IntConsumer printNumber) throws InterruptedException {
		while (cur <= n + 1) {
			try {
				lock.lock();
				if (cur == n + 1) {
					//通知结束
					System.out.println("---end---");
					fizzCondition.signal();
					buzzCondition.signal();
					fizzBuzzCondition.signal();
					break;
				}
				System.out.println("lock number");
				if ((cur % 3) == 0 && (cur % 5) != 0) {
					System.out.println("fizzCondition.signal();");
					fizzCondition.signal();
				} else if ((cur % 3) != 0 && (cur % 5) == 0) {
					System.out.println("buzzCondition.signal()");
					buzzCondition.signal();
				} else if ((cur % 3) == 0 && (cur % 5) == 0) {
					System.out.println("fizzBuzzCondition.signal()");
					fizzBuzzCondition.signal();
				} else {
					//number自己打印，则下一次调用者还是自己
					System.out.println("printNumber.accept(cur)");
					printNumber.accept(cur);
					cur++;
					continue;
				}
				numberTurn = false;
				System.out.println("numCondition await start");
				numCondition.await();
				System.out.println("numCondition await end");
				cur++;
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.unlock();
			}
		}
		System.out.println("number --- end");
	}
}