package algorithm.dymanic_programming;

/**
 * <p>
 * 剑指14题
 * A解法：动态规划，自下而上递推，用数组保存0，1，2.。。的最大长度
 * B解法：贪心算法，尽可能的剪长度为3的，剩下的4分成2x2
 * 书上有正确的思路，挺神奇的...

 // 题目：给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
 // 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘
 // 积是多少？例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此
 // 时得到最大的乘积18。

 * 动态规划思路：
 * 设f(n)为题解答案。长度为n的绳子假设第一刀砍长度i，剩下的n-i的长度，砍的情况下，最大长度为f(n-i)，不砍的情况下，最大长度为n-i
 *
 * 所以得出 f(n) = Max{ i * Max [ f(n-i) , n-i ] }
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
		System.out.println(cutRopeA(13));

		System.out.println("-------------");

		System.out.println(cutRopeB(-1));
		System.out.println(cutRopeB(0));
		System.out.println(cutRopeB(1));
		System.out.println(cutRopeB(4));
		System.out.println(cutRopeB(8));
		System.out.println(cutRopeB(13));
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
		//注意这里和上面的返回对的是不一样的，对于2来说，长度确实是2，因为可以不用砍成1*1
		result[0] = 0;
		result[1] = 1;
		result[2] = 2;
		result[3] = 3;
		int max;
		for (int i = 4; i <= length; i++) {
			max = 0;
			for (int j = 1; j <= i / 2; j++) {
				//n>=4的时候，无需计算i * (n-i)，没有result[0,1,2,3]大
				int value = result[j] * result[i - j];
				if (value > max) {
					max = value;
				}
			}
			result[i] = max;
		}
		return result[length];
	}

	static int cutRopeB(int length) {
		int max = 1;
		for (int i = 0; i < length; i+=3) {
			int left = length - i;
			if (left <= 4) {
				max *= left;
				break;
			}
			max *= 3;
		}
		return max;
	}
}
