package cryptography;

import java.util.Arrays;
import java.util.Base64;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2018/10/31
 */
public class Base64Test {
	public static void main(String[] args) {
		byte[] bytes = "Man".getBytes();

		String encodedStr = Base64.getEncoder().encodeToString(bytes);
		byte[] encodedBytes = Base64.getEncoder().encode(bytes);
		System.out.println(encodedStr);
		System.out.println(Arrays.toString(encodedBytes));
	}
}
