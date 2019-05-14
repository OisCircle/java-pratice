package basic;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/2/16
 */
public class IntegerTest {
	public static void main(String[] args) {
		Integer i1 = 1;
		Integer i2 = 2;
		Integer i3 = 3;
		Integer i321 = 321;
		Integer i321b = 321;

		Long l3 = 3L;
		Long l321 = 321L;

		System.out.println(i3==(i1+i2));
		System.out.println(i321 == i321b);
		System.out.println(i321.equals(i321b));

	}
}
