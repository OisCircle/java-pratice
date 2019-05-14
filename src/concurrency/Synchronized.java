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
public class Synchronized {
	public static void main(String[] args) {
		Resource t1 = new Resource();
		Resource t2 = new Resource();
		t1.setName("t1");
		t2.setName("t2");

		t1.start();
		t2.start();
	}
}

class Resource extends Thread {
	int i = 3;

	@Override
	public void run() {
			while (i > 0) {
				Num.getNum();
				i--;
			}
	}
}

class Num {
	private static int num = 3;

	synchronized public static void getNum() {
		System.out.println(T.currentThread().getName() + " got " + num);
		num--;
	}
}