package algorithm.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/2
 */
public class MultiplyTest {
	public static void main(String[] args) {
//		System.out.println(multiply("401716832807512840963", "167141802233061013023557397451289113296441069"));

//		System.out.println(multiply("123", "456"));
//		System.out.println(multiply("100", "100"));
//		System.out.println(multiply("500", "500"));
//		System.out.println(multiply("25", "25"));
		System.out.println(multiply("98", "99"));

//		System.out.println(multiply("2", "3"));
//		System.out.println(plus("18", "12"));
//		System.out.println(plus("1", "9"));
//		System.out.println(plus("2", "5"));
//		System.out.println(plus("0", "7"));
//		System.out.println(plus("7", "0"));
//		System.out.println(plus("99", "99"));
	}


	static String multiply(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		char[] res = new char[len1 + len2];
		for (int i = 0; i < res.length; i++) {
			res[i] = '0';
		}
		char[] nums1 = num1.toCharArray();
		char[] nums2 = num2.toCharArray();
		int add = 0;

		for (int i = len1 - 1; i >= 0; i--) {
			int temp;
			for (int j = len2 - 1; j >= 0; j--) {
				temp = (nums1[i] - '0') * (nums2[j] - '0');
				int sum = res[i + j + 1] - '0' + add + temp % 10;
				res[i + j + 1] = (char) ('0' + sum % 10);
				add = sum / 10 + temp / 10;
			}
			res[i] += add;
		}
		for (int i = 0; i < res.length; i++) {
			if (res[i] != '0') {
				return String.valueOf(res).substring(i, res.length);
			}
		}
		return "0";
	}
}