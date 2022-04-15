package algorithm.dymanic_programming;

/**
 * <p>
 * 剑指49题：获取从小到大顺序的第1500个丑数（只包含因子2，3，5的数字，也就是只能被2，3，5整除）
 * 解法1：暴力解法，遍历每个数字并一直除
 * 解法2：动态规划，将获取到的数字存放起来
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/26
 */
public class UglyNumberTest {
	public static void main(String[] args) {
		System.out.println(uglyNumberViolent(6));
		System.out.println(uglyNumberDP(1500));


	}


	static int uglyNumberViolent(int n) {
		int current = 0, number = 1;
		while (current != n) {
			if (isUgly(number++)) {
				current++;
			}
		}
		return --number;
	}

	/**
	 * 丑数可以由前面的数字*2或者*3或者*5中的最小值得来
	 * 最笨的动态规划就是将之前存起来的丑数，每个都x2x3x5，看看最小的结果，再添加到下一个丑数中
	 * 好的动态规划：避免每次都将每个丑数x2x3x5，每次乘的时候都记录下当前刚好大于最大丑数的那个下标，避免重复计算
	 */
	static int uglyNumberDP(int n) {
		if (n < 1) {
			return 0;
		}
		int multiple2 = 0, multiple3 = 0, multiple5 = 0;
		int[] uglys = new int[n];
		uglys[0] = 1;
		for (int i = 1; i < n; i++) {
			//避免重复运算，并且记录index，找到刚好大于目前找到的丑数的那个下标
			while (uglys[multiple2] * 2 <= uglys[i - 1]) {
				multiple2++;
			}
			while (uglys[multiple3] * 3 <= uglys[i - 1]) {
				multiple3++;
			}
			while (uglys[multiple5] * 5 <= uglys[i - 1]) {
				multiple5++;
			}
			uglys[i] = minWithin3Numbers(uglys[multiple2] * 2, uglys[multiple3] * 3, uglys[multiple5] * 5);
		}
		return uglys[n - 1];
	}

	static int minWithin3Numbers(int a, int b, int c) {
		return b < a ? (c < a ? c : b) : (Math.min(c, a));
	}

	static boolean isUgly(int num) {
		while (num % 2 == 0) {
			num /= 2;
		}
		while (num % 3 == 0) {
			num /= 3;
		}
		while (num % 5 == 0) {
			num /= 5;
		}
		return num == 1;
	}
}
