package algorithm.math;

/**
 * <p>
 * 剑指43题：1~n中1出现的个数
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/24
 */
public class NumberOf1Test {
	public static void main(String[] args) {
		System.out.println(numberOf1(12));
		System.out.println(numberOf1(123));
		System.out.println(numberOf1(1231));
	}

	/**
	 * 穷举法
	 */
	static int numberOf1(int num) {
		if (num < 1) {
			return -1;
		}
		int sum = 1;
		for (int i = 1; i < num; i++) {
			for (int current = i; current > 0; current /= 10) {
				if (current % 10 == 1) {
					sum++;
				}
			}
		}
		return sum;
	}
}
