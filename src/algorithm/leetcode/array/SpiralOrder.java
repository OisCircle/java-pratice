package algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 待完成
 *
 * @author O
 * @since 2020/3/27
 */
public class SpiralOrder {
    public static void main(String[] args) {
        int[][] nums0 = new int[][]{
                {1, 2, 3},
                {8, 9, 4},
                {7, 6, 5}
        };
        int[][] nums1 = new int[][]{
                {1, 2, 3, 4},
                {12, 13, 14, 5},
                {11, 16, 15, 6},
                {10, 9, 8, 7}
        };
        int[][] nums2 = new int[][]{
                {1, 2, 3, 4}
        };
        int[][] nums3 = new int[][]{
                {1},
                {2},
                {3},
                {4}
        };
        int[][] nums4 = new int[][]{
                {1}
        };
        System.out.println(spiralOrder(nums0));
        System.out.println(spiralOrder(nums1));
//        System.out.println(spiralOrder(nums2));
//        System.out.println(spiralOrder(nums3));
//        System.out.println(spiralOrder(nums4));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length < 1) {
            return new ArrayList<>();
        }
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> res = new ArrayList<>(row * col);
        int time = Math.min(row + 1, col + 1) / 2;
        for (int i = 0; i < time; i++) {
            //向右
            for (int j = i; j < row - i; j++) {
                res.add(matrix[i][j]);
            }
            //向下
            for (int j = i + 1; j < col - i - 1; j++) {
                res.add(matrix[i + j][col - i - 1]);
            }
            //向左
            for (int j = col - i - 1; j >= 0; j--) {
                res.add(matrix[row - i - 1][j]);
            }
            //向上
            for (int j = row - i - 2; j > 0; j--) {
                res.add(matrix[j][i]);
            }
        }
        return res;
    }
}
