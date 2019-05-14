package algorithm.dymanic_programming;

/**
 * <p>
 * 剑指14题
 * A解法：动态规划，自下而上递推，用数组保存0，1，2.。。的最大长度
 * B解法：贪心算法，尽可能的剪长度为3的，剩下的4分成2x2
 * 书上有正确的思路，挺神奇的...
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/15
 */
public class CutRopeTest {
	public static void main(String[] args) {
		System.out.println(cutRopeA(-1));
		System.out.println(cutRopeA(0));
		System.out.println(cutRopeA(1));
		System.out.println(cutRopeA(4));
		System.out.println(cutRopeA(8));
	}

	/**
	 * 动态规划解法
	 */
	static int cutRopeA(int length) {
		if (length < 2) {
			return 1;
		}
		if (length == 2) {
			return 1;
		}
		if (length == 3) {
			return 2;
		}
		int[] result = new int[length + 1];
		//注意这里和上面的返回对的是不一样的
		result[0] = 0;
		result[1] = 1;
		result[2] = 2;
		result[3] = 3;
		int max;
		for (int i = 4; i <= length; i++) {
			max = 0;
			for (int j = 1; j <= i / 2; j++) {
				int value = result[j] * result[i - j];
				if (value > max) {
					max = result[j] * result[i - j];
				}
			}
			result[i] = max;
		}
		return result[length];
	}

	static int cutRopeB(int length) {
		return 0;
	}
}
