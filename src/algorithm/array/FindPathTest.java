package algorithm.array;

/**
 * <p>
 * 在矩阵中寻找是否存在对应的路径
 * 剑指offer 12题
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/14
 */
public class FindPathTest {
	public static void main(String[] args) {
		char[][] map = new char[][]{
				{'a', 'b', 't', 'g'},
				{'c', 'f', 'c', 's'},
				{'j', 'd', 'e', 'h'}};
		char[] path = new char[]{'b', 'f', 'c', 'e'};
		char[] path2 = new char[]{'a', 'b', 'f', 'b'};
		System.out.println(hasPath(map, 3, 4, path));
		System.out.println(hasPath(map, 3, 4, path2));
	}

	static boolean hasPath(char[][] map, int rows, int cols, char[] path) {
		if (path == null) {
			return false;
		}
		//初始化boolean
		boolean[][] visited = new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				visited[i][j] = false;
			}
		}

		Integer pathLength = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (hasPathCore(map, rows, cols, i, j, path, pathLength, visited)) {
					return true;
				}
			}
		}
		return false;
	}

	static boolean hasPathCore(char[][] map, int rows, int cols, int row, int col,
	                           char[] path, Integer pathLength, boolean[][] visited) {
		if (pathLength >= path.length) {
			return true;
		}
		boolean hasPath = false;
		//防止越界
		if (row >= 0 && row < rows && col >= 0 && col < cols && map[row][col] == path[pathLength] && !visited[row][col]) {
			++pathLength;
			visited[row][col] = true;
			//四个方向都要试探，只要可以就试探到底
			hasPath = hasPathCore(map, rows, cols, row, col - 1, path, pathLength, visited)
					||
					hasPathCore(map, rows, cols, row - 1, col, path, pathLength, visited)
					||
					hasPathCore(map, rows, cols, row, col + 1, path, pathLength, visited)
					||
					hasPathCore(map, rows, cols, row + 1, col, path, pathLength, visited);
			//恢复现场，回溯法重要的一点，虽然有些不用恢复现场，但是这个涉及到单一路径的问题
			if (!hasPath) {
				--pathLength;
				visited[row][col] = false;
			}
		}
		return hasPath;
	}
}
