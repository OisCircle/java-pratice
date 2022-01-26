package algorithm.math;

/**
 *
 * 两个大数相加
 *
 * '9' - '0' = 0 ，字符运算的时候会转成ascii码，所以需要减去一个'0'
 *
 * 1.两个字符串从后往前算
 * 2.字符相加时注意转ascii的问题，并且保存进位
 * 3.注意数字一长一短的兼容，短的字符串在后面运算时用0替代
 * 4.最后要reverse
 *
 * @author qiuchengquan
 * @since 2021/10/22
 */
public class BigNumberAddTest {

	public static void main(String[] args) {
		System.out.println(add("999", "99"));
		System.out.println(add("10", "99"));
		System.out.println(add("1", "9"));
		System.out.println(add("1", "0"));
	}

	public static String add(String num1, String num2) {
		if (num1.length() < 1) {
			return num2;
		}
		if (num2.length() < 1) {
			return num1;
		}
		int index1 = num1.length() - 1, index2 = num2.length() - 1;
		int carry = 0;
		StringBuilder res = new StringBuilder();
		while (index1 >= 0 || index2 >= 0) {
			int n1 = index1 >= 0 ? num1.charAt(index1) - '0' : 0;
			int n2 = index2 >= 0 ? num2.charAt(index2) - '0' : 0;
			int sum = n1 + n2 + carry;
			res.append(sum % 10);
			carry = sum / 10;
			index1--;
			index2--;
		}
		if (carry > 0) {
			res.append(1);
		}
		return res.reverse().toString();
	}
}
