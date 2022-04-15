package algorithm.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * 回形针打印矩阵
 *
 * 思路：直接斜着打印（比如下面的nums0，12369，每次都左下角一直遍历），遇到第一行的列等于偶数时做反转就好了
 *
 * @author O
 * @since 2020/3/26
 */
public class FindDiagonalOrder {
    public static void main(String[] args) {
        int[][] nums0 = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        Arrays.stream(findDiagonalOrder(nums0)).forEach(System.out::print);
        System.out.println();
        nums0 = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };
        Arrays.stream(findDiagonalOrder(nums0)).forEach(System.out::print);
        System.out.println();
        nums0 = new int[][]{
                {1}
        };
        Arrays.stream(findDiagonalOrder(nums0)).forEach(System.out::print);
        System.out.println();
        nums0 = new int[][]{
                {1, 2}
        };
        Arrays.stream(findDiagonalOrder(nums0)).forEach(System.out::print);
    }

    public static int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length < 1) {
            return new int[0];
        }
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> res = new ArrayList<>(row * col);
        //是偶数则须反转遍历结果，奇数则不用
        int direction = 0;
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < col; i++) {
            temp.clear();
            for (int j = 0; j < Math.min(i + 1, row); j++) {
                temp.add(matrix[j][i - j]);
            }
            if ((direction++ & 1) == 0) {
                Collections.reverse(temp);
            }
            res.addAll(temp);
        }
        for (int i = row - 1; i > 0; i--) {
            temp.clear();
            for (int j = 0; j < Math.min(i, col); j++) {
                temp.add(matrix[row - i + j][col - j - 1]);
            }
            if ((direction++ & 1) == 0) {
                Collections.reverse(temp);
            }
            res.addAll(temp);
        }
        int[] list = new int[row * col];
        for (int i = 0; i < res.size(); i++) {
            list[i] = res.get(i);
        }
        return list;
    }
}
