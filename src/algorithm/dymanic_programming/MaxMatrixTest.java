package algorithm.dymanic_programming;

/**
 * <p>
 * 最大正方形
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * <p>
 * x/y 0 1 2 3 4
 * --0 1 0 1 0 0
 * --1 1 0 1 1 1
 * --2 1 1 1 1 1
 * --3 1 0 0 1 0
 * <p>
 * 输出: 4
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/4
 */
public class MaxMatrixTest {
	private static int max;

	public static void main(String[] args) {
		int[][] matrix = new int[][]{
				{1, 0, 1, 0, 0},
				{1, 0, 1, 1, 1},
				{1, 1, 1, 1, 1},
				{1, 0, 0, 1, 0}};

		int[][] matrix2 = new int[][]{
				{1, 1, 1, 1},
				{1, 1, 1, 1},
				{1, 1, 1, 1}};

		int[][] matrix3 = new int[][]{
				{1}};
		System.out.println(maxSquare(matrix, 4, 5));
		System.out.println(maxSquare(matrix2, 3, 4));
		System.out.println(maxSquare(matrix3, 1, 1));
	}

	/**
	 * dfs暴力解法，每次判断右边，下边，右下边是否为1，是则继续dfs
	 * current：当前边长
	 * max：最长边长
	 */
	static int maxSquare(int[][] s, int x, int y) {
		max = 0;
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				if (s[i][j] == 1) {
					System.out.println("---");
					System.out.println("dfs start");
					dfs(s, i, j, x, y, 1);
					System.out.println("---");
				} else {
					System.out.println("not 1");
				}
			}
		}
		return max * max;
	}

	private static void dfs(int[][] s, int i, int j, int x, int y, int current) {
		if (current > max) {
			max = current;
		}
		//越界则返回
		if (i + current >= x || j + current >= y) {
			System.out.println("越界返回");
			return;
		}
		//查看右下角的元素是否都为1
		for (int k = 0; k < current; k++) {
			if (s[i + current][j + k] != 1) {
				print(i + current, j + k, false);
				return;
			}
			print(i + current, j + k, true);
		}
		for (int k = 0; k < current; k++) {
			if (s[i + k][j + current] != 1) {
				print(i + k, j + current, false);
				return;
			}
			print(i + k, j + current, true);
		}
		if (s[i + current][j + current] != 1) {
			print(i + current, j + current, false);
			return;
		}
		print(i + current, j + current, true);
		//通过检测，全为1，当前边长+1
		current++;
		System.out.println("checked ! current:" + current);
		dfs(s, i, j, x, y, current);
	}

	static void print(int x, int y, boolean one) {
		System.out.println("( " + x + "," + y + " ) = " + (one ? 1 : 0));
	}
}
