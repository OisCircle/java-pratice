package reflect.jdkProxy;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/5/12
 */
public class RealWorker implements Worker {
	public void work() {
		System.out.println("work()");
	}

	public void eat() {
		System.out.println("eat()");
	}

	public void sleep() {
		System.out.println("sleep()");
	}
}
