package algorithm.array;

import java.util.ArrayList;

/**
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/15
 */
public class PrintMatrixTest {
	public static void main(String[] args) {
		System.out.println(printMatrix(new int[][]{{1, 2, 3, 4}, {12, 13, 14, 5}, {11, 16, 15, 6}, {10, 9, 8, 7}}));
		System.out.println(printMatrix(new int[][]{{1, 2, 3, 4}, {8, 7, 6, 5}}));
		System.out.println(printMatrix(new int[][]{{1, 2}, {8, 3}, {7, 4}, {6, 5}}));
		System.out.println(printMatrix(new int[][]{{1, 2, 3, 4, 5}, {12, 13, 14, 15, 6}, {11, 10, 9, 8, 7}}));
		System.out.println(printMatrix(new int[][]{{1, 2, 3, 4}, {10, 11, 12, 5}, {9, 8, 7, 6}}));
		System.out.println(printMatrix(new int[][]{{1, 2, 3}, {10, 11, 4}, {9, 12, 5}, {8, 7, 6}}));
		System.out.println(printMatrix(new int[][]{{1, 2, 3, 4, 5}}));
		System.out.println(printMatrix(new int[][]{{1}, {2}, {3}, {4}, {5}}));
		System.out.println(printMatrix(new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}}));
	}

	static ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> res = new ArrayList<>();
		if (matrix.length < 1) {
			return res;
		}
		int row = matrix.length;
		int col = matrix[0].length;
		for (int start = 0; start * 2 < row && start * 2 < col; start++) {
			int endX = col - start - 1, endY = row - start - 1;
			for (int i = start; i <= endX; i++) {
				res.add(matrix[start][i]);
			}
			if (endY > start) {
				for (int i = start+1; i <= endY; i++) {
					res.add(matrix[i][endX]);
				}
			}
			if (endY > start && endX > start) {
				for (int i = endX - 1; i >= start; i--) {
					res.add(matrix[endY][i]);
				}
			}
			if (endY - 1 > start && endX > start) {
				for (int i = endY - 1; i >= start + 1; i--) {
					res.add(matrix[i][start]);
				}
			}
		}
		return res;
	}
}
