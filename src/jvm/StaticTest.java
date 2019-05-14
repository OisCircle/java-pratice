package jvm;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2018/10/13
 */
public class StaticTest {
	public static int a = 1;
	static{
		a = 2;
	}

}

class StaticTest2 extends StaticTest {
	public static int b = a;
	static{
		b = 3;
	}
}

class StaticTestMain {
	public static void main(String[] args) {
		//父类先初始化 a=2 , 子类初始化 a = 3
		System.out.println(StaticTest2.b);
	}
}