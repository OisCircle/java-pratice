package algorithm.bit_operation;

/**
 * <p>
 * 剑指15
 * 二进制中1的个数
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/15
 */
public class NumOf1Test {
	public static void main(String[] args) {
		System.out.println(numberOf1A(9));
		System.out.println(numberOf1B(9));
		System.out.println(numberOf1B(13));
		System.out.println(numberOf1B(16));
		System.out.println(numberOf1C(9));
	}

	/**
	 * 移动原来的数字
	 * 数字过大会有bug
	 */
	static int numberOf1A(int num) {
		int count = 0;
		while (num > 0) {
			if ((num & 1) == 1) {
				count++;
			}
			num = num >> 1;
		}
		return count;
	}

	/**
	 * 不移动原来的数字
	 */
	static int numberOf1B(int num) {
		int count = 0;
		int flag = 1;
		while (flag <= num) {
			if ((num & flag) >= 1) {
				count++;
			}
			flag <<= 1;
		}
		return count;
	}

	/**
	 * 带来惊喜的解法
	 */
	static int numberOf1C(int num) {
		int count = 0;
		while (num != 0) {
			++count;
			num = (num - 1) & num;
		}
		return count;
	}

}
