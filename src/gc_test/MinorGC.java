package gc_test;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2018/10/4
 */
public class MinorGC {
	private static final int _1MB = 1024 * 1024;

	public static void main(String[] args) {
		byte[] alloc1, alloc2, alloc3, alloc4;
		alloc1 = new byte[1 * _1MB];
		alloc2 = new byte[1 * _1MB];
		alloc3 = new byte[1 * _1MB];
		//
		alloc4 = new byte[2 * _1MB];

	}
}
