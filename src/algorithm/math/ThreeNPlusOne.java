package algorithm.math;

/**
 * <p>
 * 3n+1问题
 * 输入一个数，偶数时则砍掉一半；奇数时，则（3n+1）砍掉一半，最后直到得到1.问，进行了多少次？
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/12
 */
public class ThreeNPlusOne {
	public static void main(String[] args) {
		printCount(3);
		printCount(704511);
	}

	static void printCount(long n) {
		if (n < 0) {
			System.out.println("-1");
		}
		long step = 0;
		while (n != 1) {
			if ((n & 1) == 0) {
				n /= 2;
			} else {
				n = 3 * n + 1;
			}
			step++;
		}
		System.out.println(step);
	}
}
