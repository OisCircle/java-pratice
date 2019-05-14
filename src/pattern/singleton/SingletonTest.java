package pattern.singleton;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/19
 */
public class SingletonTest {
	public static void main(String[] args) {

	}
}
class EagerSingleton{
	private static final Object resource = new Object();
	private EagerSingleton() {

	}

	public Object getResource() {
		return resource;
	}
}
class LazySingleton{
	private LazySingleton() {

	}
	private static volatile Object resource;

	public Object getResource() {
		if (resource == null) {
			synchronized (LazySingleton.class) {
				if (resource == null) {
					return new Object();
				}
			}
		}
		return resource;
	}
}