package generic.test3;

/**
 * @author qiuchengquan
 * @since 2020/10/24
 */
public class CreatorGeneric {

	public static void main(String[] args) {
		XCreator xCreator = new XCreator();
		xCreator.f();
	}
}

abstract class GenericWithCreate<T> {

	final T element = create();

	abstract T create();

}

class X {

}

class XCreator extends GenericWithCreate<X> {

	@Override
	X create() {
		return new X();
	}

	void f() {
		System.out.println(element.getClass().getSimpleName());
	}
}
