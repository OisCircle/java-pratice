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
public class FinalizedTest {
	public static void main(String[] args) {
		FT ft = new FT();
		System.gc();
		ft = null;
		System.out.println("asdas");
		System.gc();


	}
}

class FT {

	@Override
	protected void finalize() throws Throwable {
		System.out.println("FT::finalize()");
	}
}
