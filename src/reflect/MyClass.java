package reflect;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2018/9/28
 */
public class MyClass {
	int a;
	String b;

	public void hello(String abc) {
		System.out.println("hello");
	}

	public void hi(String str) {
		System.out.println("hi");
	}

	public static void main(String[] args) {
		Class<MyClass> c = MyClass.class;

		Method[] methods = c.getMethods();
		Arrays.stream(methods).forEach(method -> {
			System.out.println("method name: "+method.getName());
			System.out.println("return type: "+method.getReturnType().getName());
		});
	}
}
