package algorithm.array;

/**
 * <p>
 * 机器人运动范围
 * 剑指13题
 * 回溯法
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/14
 */
public class RobotRange {
	public static void main(String[] args) {
		int threshold = 18;
		int threshold2 = 12;
		int rows = 40;
		int cols = 40;

		System.out.println(moveCount(threshold, rows, cols));
		System.out.println(moveCount(threshold2, rows, cols));
	}

	static int moveCount(int threshold, int rows, int cols) {
		if (threshold < 0 || rows < 0 || cols < 0) {
			return -1;
		}
		//初始化boolean
		boolean[][] visited = new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				visited[i][j] = false;
			}
		}

		return moveCountCore(threshold, rows, cols, 0, 0, visited);
	}

	static int moveCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
		int count = 0;
		if (check(threshold, rows, cols, row, col, visited)) {
			count = 1 + moveCountCore(threshold, rows, cols, row + 1, col, visited)
					+ moveCountCore(threshold, rows, cols, row, col + 1, visited)
					+ moveCountCore(threshold, rows, cols, row - 1, col, visited)
					+ moveCountCore(threshold, rows, cols, row, col - 1, visited);
		}
		return count;
	}

	static boolean check(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
		if (row >= 0 && col >= 0 && row < rows && col < cols && !visited[row][col] &&
				getDigitSum(row) + getDigitSum(col) <= threshold) {
			visited[row][col] = true;
			return true;
		}
		return false;
	}

	static int getDigitSum(int num) {
		int sum = 0;
		while (num > 0) {
			sum += num % 10;
			num /= 10;
		}
		return sum;
	}
}
