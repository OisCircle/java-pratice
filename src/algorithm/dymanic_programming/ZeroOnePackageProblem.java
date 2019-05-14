package algorithm.dymanic_programming;

import java.util.Arrays;

/**
 * <p>
 * 01背包问题动态规划解法
 * 重量太大则拿下一个试试，否则看看拿和不拿，两个结果哪个大
 * 最优解：重量为0的时候可以拿0的价值
 * 递归公式: B ( k , cap ) = cap < w[i] ? B(k-1,cap): max{ B(k - 1, cap - w[ k ] ) + v[k] , B(k-1,cap) }
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/6
 */
public class ZeroOnePackageProblem {
	public static void main(String[] args) {
		//w，v第一个都为0，因为递归边界需要，代表重量为0的时候可以拿0的价值
		int[] w = new int[]{0, 2, 3, 4, 5, 9};
		int[] v = new int[]{0, 3, 4, 5, 8, 10};
		int itemCount = w.length;
		int maxCap = 20;
		int[][] res = new int[itemCount][maxCap + 1];
		//第一行为0，实际上不需要写，int数组默认是0
		for (int item = 1; item < itemCount; item++) {
			for (int cap = 0; cap <= maxCap; cap++) {
				if (cap < w[item]) {
					res[item][cap] = res[item - 1][cap];
				} else {
					int notTake = res[item - 1][cap];
					int take = res[item - 1][cap - w[item]] + v[item];
					res[item][cap] = take > notTake ? take : notTake;
				}
			}
			System.out.println(Arrays.toString(res[item]));
		}
		zeroOnePackageProblem();
		zeroOnePakageProblem0();
	}

	static void zeroOnePackageProblem() {
		int[] w = new int[]{0, 2, 3, 4, 5, 9};
		int[] v = new int[]{0, 3, 4, 5, 8, 10};
		int[][] res = new int[6][21];
		for (int item = 1; item < 6; item++) {
			for (int cap = 0; cap < 21; cap++) {
				if (cap < w[item]) {
					res[item][cap] = res[item - 1][cap];
				} else {
					int take = res[item - 1][cap - w[item]] + v[item];
					int notTake = res[item - 1][cap];
					res[item][cap] = take > notTake ? take : notTake;
				}
			}
		}
		System.out.println(res[5][20]);
	}


	static void zeroOnePakageProblem0() {
		int[] w = new int[]{0, 4, 6, 2, 2, 5, 1};
		int[] v = new int[]{0, 8, 10, 6, 3, 7, 2};
		int count = w.length;
		int maxCap = 12;
		int[][] res = new int[count][maxCap + 1];
		for (int i = 1; i < count; i++) {
			for (int cap = 0; cap < maxCap + 1; cap++) {
				if (cap < w[i]) {
					res[i][cap] = res[i - 1][cap];
				} else {
					int take = res[i - 1][cap - w[i]] + v[i];
					int notTake = res[i - 1][cap];
					res[i][cap] = Math.max(take, notTake);
				}
			}
			System.out.println(Arrays.toString(res[i]));
		}
		//24
		System.out.println(res[count - 1][maxCap]);
	}
}
