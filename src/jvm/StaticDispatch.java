package jvm;

/**
 * <p>
 *方法静态分派
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2018/10/16
 */
public class StaticDispatch {
	static abstract class Human {
	}

	static class Man extends Human {

	}

	static class Women extends Human {

	}

	public void sayHello(Human guy) {
		System.out.println("hello guy!");
	}
	public void sayHello(Man man) {
		System.out.println("hello man!");
	}
	public void sayHello(Women women) {
		System.out.println("hello women!");
	}

	public static void main(String[] args) {
		Human women = new Women();
		Human man = new Man();
		StaticDispatch sd = new StaticDispatch();
		sd.sayHello(man);
		sd.sayHello(women);

		sd.sayHello(new Women());
	}
}
