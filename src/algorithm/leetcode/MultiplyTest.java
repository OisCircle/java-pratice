package algorithm.leetcode;

import java.util.Arrays;

/**
 * <p>
 * 大数相乘
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
//		System.out.println(multiply("98", "99"));
		System.out.println(multiply2("99", "98"));
		System.out.println(multiply2("99", "100"));
		System.out.println(multiply2("25", "25"));
		System.out.println(multiply2("2", "3"));

//		System.out.println(multiply("2", "3"));
//		System.out.println(plus("18", "12"));
//		System.out.println(plus("1", "9"));
//		System.out.println(plus("2", "5"));
//		System.out.println(plus("0", "7"));
//		System.out.println(plus("7", "0"));
//		System.out.println(plus("99", "99"));
	}

	static String multiply2(String num1, String num2) {
		int len1 = num1.length();
		int len2 = num2.length();
		char[] res = new char[len1 + len2];
		Arrays.fill(res, '0');
		char[] up = num1.toCharArray();
		char[] down = num2.toCharArray();
		int carry1;
		int carry2;
		for (int i = len1 - 1; i >= 0; i--) {
			for (int j = len2 - 1; j >= 0; j--) {
				int temp = (up[i] - '0') * (down[j] - '0');
				int sum = (res[i + j + 1] - '0') + (temp % 10);
				carry1 = sum / 10;
				//注意下这里是第一位（个位）
				res[i + j + 1] = (char) ((sum % 10) + '0');
				sum = (res[i + j] - '0') + (temp / 10) + carry1;
				carry2 = sum / 10;
				//注意这里是第二位（十位）
				res[i + j] = (char) ((sum % 10) + '0');
				if (carry2 > 0) {
					//注意这里是第三位（百位），一次运算可能涉及到百位，比如99*98中的792+810=1602，其中的79和81，涉及到个十百位的变更
					res[i + j - 1] = (char) (carry2 + '0');
				}
			}
		}
		//结果有多余的0，比如99 X 100 = 09900，需要去掉前面的0
		//TODO 过滤0

		return String.valueOf(res);
	}
}