package jvm;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2018/10/11
 */
public class PassiveRef {
	static {
		System.out.println("PassiveRef init");
	}

	PassiveRef() {
		System.out.println("PassiveRef constructor...");
	}
	public static final String HELLOWORLD = "hello world";
}