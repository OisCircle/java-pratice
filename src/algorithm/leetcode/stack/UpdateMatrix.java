package algorithm.leetcode.stack;

/**
 * 思路：动态规划
 * dp[i,j]=min(dp[上],dp[下],dp[左],dp[右])
 * 每次更新状态只能左上两个或者右下两个去对比，所以需要两次遍历
 * 第一次遍历：从头开始，dp[i,j] = matrix[i][j]==0 ? 0 : min(dp[i-1][j],dp[i][j-1])
 * 第二次遍历：从尾开始，dp[i,j] = min(dp[i][j],dp[i+1][j],dp[i][j+1])
 *
 * @author O
 * @since 2020/3/25
 */
public class UpdateMatrix {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 0, 0, 1},
                {1, 1, 1, 0},
                {1, 1, 0, 1},
                {1, 1, 1, 1}};
        matrix = updateMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] updateMatrix(int[][] matrix) {
        int MAX = 10001;
        final int row = matrix.length;
        if (row < 1) {
            return null;
        }
        final int col = matrix[0].length;
        int[][] res = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                res[i][j] = MAX;
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == 0) {
                    res[i][j] = 0;
                } else {
                    //左上或右上
                    res[i][j] = Math.min(i == 0 ? MAX : res[i - 1][j] + 1,
                            j == 0 ? MAX : res[i][j - 1] + 1);
                }
            }
        }

        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                res[i][j] = Math.min(res[i][j],
                        Math.min(i == row - 1 ? MAX : res[i + 1][j] + 1,
                                j == col - 1 ? MAX : res[i][j + 1] + 1
                        ));
            }
        }
        return res;
    }
}
