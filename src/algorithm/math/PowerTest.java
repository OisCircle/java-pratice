package algorithm.math;

import java.util.Scanner;

/**
 * <p>
 * <p>
 * 东东对幂运算很感兴趣,在学习的过程中东东发现了一些有趣的性质: 9^3 = 27^2, 2^10 = 32^2
 * 东东对这个性质充满了好奇,东东现在给出一个整数n,希望你能帮助他求出满足 a^b = c^d(1 ≤ a,b,c,d ≤ n)的式子有多少个。
 * 例如当n = 2: 1^1=1^1
 * 1^1=1^2
 * 1^2=1^1
 * 1^2=1^2
 * 2^1=2^1
 * 2^2=2^2
 * 一共有6个满足要求的式子
 * <p>
 * 输入描述:
 * 输入包括一个整数n(1 ≤ n ≤ 10^6)
 * <p>
 * <p>
 * 输出描述:
 * 输出一个整数,表示满足要求的式子个数。因为答案可能很大,输出对1000000007求模的结果
 * 示例1
 * 输入
 * 2
 * 输出
 * 6
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/13
 */
public class PowerTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		print(n);
//		print(2);
	}

	/**
	 * 目前只知道暴力解法
	 */
	static void print(int n) {
		int count = 0;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				for (int k = 1; k <= n; k++) {
					for (int l = 1; l <= n; l++) {
						if (nkLoop(i, j) == nkLoop(k, l)) {
							count++;
						}
					}
				}
			}
		}
		System.out.println(count);
	}

	static long nkLoop(int n, int k) {
		if (n == 1) {
			return 1;
		}
		long t = n;
		long res = 1;
		while (k > 0) {
			if ((k & 1) == 1) {
				res *= t;
			}
			t *= t;
			k >>= 1;
		}
		return res;
	}
}
