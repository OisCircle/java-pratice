package algorithm.leetcode.array;

/**
 * 剑指Offer专项突破版 第13题，二维子矩阵的数字之和
 * <p>
 * 输入二维矩阵，求左上角至右下角圈起来的坐标之和
 * <p>
 * eg：(2,1) (4,3) 输出：2+0+1+1+0+1+0+3+0=8
 * <p>
 * [3, 0, 1, 4, 2] [5, 6, 3, 2, 1] [1, 2, 0, 1, 5] [4, 1, 0, 1, 7] [1, 0, 3, 0, 5]
 * <p>
 * 思路1 O（mn）暴力解法：从(2,1)累加到(4,3)
 * <p>
 * 由于这个函数调用多次，同一范围内的矩阵和可能会被重复算多几次，所以可以预计算出来指定下标的矩阵和，存起来，再去计算的时候，只需O（1）时间复杂度就可以算出结果了
 * <p>
 * 例如(2,1)(4,3)的和，sum=sum(4,3)-sum(1,3)-sum(4,0)+sum(1,1)
 * <p>
 * 所以预计算出指定下标的sum，再根据sum去O（1）算出子矩阵和即可
 *
 * @author qiuchengquan
 * @since 2021/11/7
 */
public class SubMatrixSum {

	private static int[][] SUM = null;

	public static void main(String[] args) {
		int[][] matrix = new int[][]{
			{3, 0, 1, 4, 2},
			{5, 6, 3, 2, 1},
			{1, 2, 0, 1, 5},
			{4, 1, 0, 1, 7},
			{1, 0, 3, 0, 5}
		};
		preSum(matrix);
		System.out.println(subMatrixSum(2, 1, 4, 3));
	}

	public static void preSum(int[][] matrix) {
		//在矩阵左上角一圈，多算一排0出来，是为了兼容index=-1的情况
		SUM = new int[matrix.length + 1][matrix[0].length + 1];
		for (int i = 0; i < matrix.length; i++) {
			int rowSum = 0;
			for (int j = 0; j < matrix[0].length; j++) {
				rowSum += matrix[i][j];
				//sum[i][j+1]是之前已经算过的
				SUM[i + 1][j + 1] = SUM[i][j + 1] + rowSum;
			}
		}
	}

	public static int subMatrixSum(int r1, int c1, int r2, int c2) {
		//注意SUM，比原矩阵多了左上角两排0的数字
		return SUM[r2 + 1][c2 + 1] - SUM[r1][c2 + 1] - SUM[r2 + 1][c1] + SUM[r1][c1];
	}
}
