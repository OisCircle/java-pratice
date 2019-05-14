package jvm;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2018/10/18
 */
public class Test {
	public Test() {
		System.out.println("Test.class loaded by : " + this.getClass().getClassLoader().toString());
	}

	public void method() {
		if (true) {
			System.out.println("aaa");
		} else {
			System.out.println("bbb");
		}
		int a = 2;
		int b = 234;
		Integer c = 1231;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
	}
}