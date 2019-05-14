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
public class ITestImpl implements ITest {
	@Override
	public void hello() {
		System.out.println(num);
	}

	public static void main(String[] args) {
		ITestImpl test = new ITestImpl();
		test.hello();
		new Test();
	}
}
