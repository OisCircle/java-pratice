package jvm;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2018/10/15
 */
public class InvokeStaticTest {
	private static int a = 1;
	public static int b = 2;

	public static void sayHello() {
		System.out.println("Hello");
	}

	private void sayHi() {
		System.out.println("Hi");
	}

	public static void main(String[] args) {
		sayHello();
		InvokeStaticTest test = new InvokeStaticTest();
		test.sayHi();
	}
}
