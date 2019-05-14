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
public class ClassLoaderTest {
	public static void main(String[] args) throws Exception {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();
		ClassLoader classLoader1 = new ClassLoader() {
			@Override
			public Class<?> loadClass(String name) throws ClassNotFoundException {
				//属于双亲委派模型中的子节点, 所以属于同一个类加载器加载, 因此instanceof方法返回true
				return super.loadClass(name);
			}
		};
		Class c1 = classLoader.loadClass("jvm.Test1");
		Class c2 = classLoader1.loadClass("jvm.Test1");
		Class c3 = classLoader.loadClass("jvm.Test1");

		System.out.println(c1.equals(c2));
		System.out.println(c1 == c2);

		Object t1 = c1.newInstance();
		Object t2 = c2.newInstance();
		System.out.println(t1 == t2);
		System.out.println(t1.equals(t2));

		System.out.println();
		System.out.println(c1.isInstance(c1));
		System.out.println(c2.isInstance(c2));
		System.out.println(c1.isInstance(c2));
		System.out.println(c1.isInstance(t1));
		System.out.println(c1.isInstance(t2));


		System.out.println(c3.isInstance(t1));
	}
}
