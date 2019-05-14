package algorithm.backtrack;

import java.util.Arrays;

/**
 * <p>
 * 算法导论书上的N皇后问题回溯法
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/4
 */
public class NQueenTest {
	/**
	 * 定义n皇后的数据结构
	 */
	private static int[] x;
	private static int sum;

	public static void main(String[] args) {
		System.out.println(nQueen(8));
	}

	public static int nQueen(int n) {
		x = new int[n];
		sum = 0;
		backtrack(0);
		return sum;
	}


	/**
	 * 回溯法，注意里面的for循环
	 */
	private static void backtrack(int n) {
		//回溯超过n了，说明成功找到一种解法
		if (n >= x.length) {
			sum++;
		} else {
			//不断递归试探
			for (int i = 0; i < x.length; i++) {
				//第n行放第i位
				x[n] = i;
				//如果能放置，试探下一个
				if (place(n)) {
					backtrack(n + 1);
				}
			}
		}
	}

	/**
	 * n行所在的位置是否能放皇后
	 */
	private static boolean place(int n) {
		for (int i = 0; i < n; i++) {
			if (x[i] == x[n] || Math.abs(n - i) == Math.abs(x[n] - x[i])) {
				return false;
			}
		}
		return true;
	}
}
