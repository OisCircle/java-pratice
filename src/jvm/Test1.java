package jvm;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2018/10/7
 */
public class Test1 {
	public static String name = "hehe";
	public String location = "location2222";

	public static void sayHi(String name) {
		System.out.println("hi" + name);
	}

	public void sayHello() {
		System.out.println("hello");
	}
	public static void main(String[] args) throws Exception{
		while (true) {
			sayHi(name);
			Thread.sleep(10000L);
		}
	}
}
