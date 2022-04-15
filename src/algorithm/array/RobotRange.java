package algorithm.array;

/**
 * <p>
 * 机器人运动范围
 *
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 *
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
		int rows = 40;
		int cols = 40;

		System.out.println(moveCount(18, rows, cols));
		System.out.println(moveCount(12, rows, cols));
	}

	static int moveCount(int threshold, int rows, int cols) {
		if (threshold < 0 || rows < 0 || cols < 0) {
			return -1;
		}
		//初始化boolean
		boolean[][] visited = new boolean[rows][cols];

		return moveAndCount(threshold, rows, cols, 0, 0, visited);
	}

	static int moveAndCount(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
		int count = 0;
		if (canMove(threshold, rows, cols, row, col, visited)) {
			count = 1 + moveAndCount(threshold, rows, cols, row + 1, col, visited)
			        + moveAndCount(threshold, rows, cols, row, col + 1, visited)
			        + moveAndCount(threshold, rows, cols, row - 1, col, visited)
			        + moveAndCount(threshold, rows, cols, row, col - 1, visited);
		}
		return count;
	}

	static boolean canMove(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
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
