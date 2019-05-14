package concurrency;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/14
 */
public class OddEvenPrintTest {
	public static void main(String[] args) {
		OEPrinter a = new OEPrinter("printer a", 0);
		OEPrinter b = new OEPrinter("printer b", 1);
		new Thread(a).start();
		new Thread(b).start();
	}

}

class OEPrinter implements Runnable {
	String name;
	int output;

	OEPrinter(String name, int output) {
		this.name = name;
		this.output = output;
	}

	@Override
	public void run() {
		while (!Thread.interrupted()) {
			synchronized (OEPrinter.class) {
				System.out.println(name + " output: " + output);
				OEPrinter.class.notify();
				try {
					OEPrinter.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
