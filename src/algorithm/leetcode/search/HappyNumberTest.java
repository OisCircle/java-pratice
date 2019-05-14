package algorithm.leetcode.search;

/**
 * <p>
 * 快乐数
 * 编写一个算法来判断一个数是不是“快乐数”。
 * <p>
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 示例:
 * <p>
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/8
 */
public class HappyNumberTest {
	public static void main(String[] args) {
		System.out.println(isHappy(19));
		System.out.println(isHappy(1));
		System.out.println(isHappy(2));
	}

	/**
	 * 解法1:利用规律,如果不是happyNumber则一定出现4,具体证明不清楚
	 * 解法2:利用set,每次将计算出的next放入set中,下次计算的时候判断是否在set中出现过,出现过则不是happyNumber
	 */
	static boolean isHappy(int n) {
		int next = 0;
		int num = n;
		while (next != 1 && next != 4) {
			next = 0;
			int button;
			while (num > 0) {
				button = num % 10;
				num /= 10;
				next += Math.pow(button, 2D);
			}
			num = next;
		}
		return next == 1;
	}
}
