package algorithm.bit_operation;

/**
 * <p>
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/13
 */
public class NumberOf1Test {
	public static void main(String[] args) {
		System.out.println(numberOf1(0));
		System.out.println(numberOf1(15));
		System.out.println(numberOf1(16));
		System.out.println(numberOf1(Integer.MIN_VALUE));
		System.out.println(numberOf1(Integer.MAX_VALUE));
	}

	/**
	 * 思路:
	 * a)10100-1=10011;
	 * b)10100&10011=10000;
	 * c)多少次ab这样的操作,代表有多少个1
	 */
	static int numberOf1(int n) {
		int count = 0;
		while (n != 0) {
			n &= (n - 1);
			count++;
		}
		return count;
	}
}
