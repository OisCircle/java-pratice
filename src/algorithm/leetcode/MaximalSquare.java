package algorithm.leetcode;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/4
 */
public class MaximalSquare {
	private static int max;

	public static void main(String[] args) {
		char[][] matrix = new char[][]{
				{'1', '0', '1', '0', '0'},
				{'1', '0', '1', '1', '1'},
				{'1', '1', '1', '1', '1'},
				{'1', '0', '0', '1', '0'}};
		System.out.println(maximalSquare(matrix));
	}

	static int maximalSquare(char[][] matrix) {
		if (matrix.length < 1) {
			return 0;
		}
		max = 0;
		int x = matrix.length;
		int y = matrix[0].length;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (matrix[i][j] == '1') {
					dfs(matrix, i, j, x, y, 1);
				}
			}
		}
		return max * max;
	}

	/**
	 * dfs暴力解法，右下边不用遍历，因为每次判断右边，下边，右下边是否为1，是则继续dfs
	 * current：当前边长
	 * max：最长边长
	 */
	private static void dfs(char[][] s, int i, int j, int x, int y, int current) {
		//越界则返回
		if (i + current >= x || j + current >= y) {
			return;
		}
		//查看右下角的元素是否都为1
		for (int k = 0; k < current; k++) {
			if (s[i + current][j + k] != '1') {
				return;
			}
		}
		for (int k = 0; k < current; k++) {
			if (s[i + k][j + current] != '1') {
				return;
			}
		}
		if (s[i + current][j + current] != '1') {
			return;
		}
		//通过检测，全为1，当前边长+1
		current++;
		if (current > max) {
			max = current;
		}
		dfs(s, i, j, x, y, current);
	}
}
