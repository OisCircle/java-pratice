package algorithm.leetcode.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author O
 * @since 2020/3/20
 */
public class NumIslands {
    public static void main(String[] args) {
        char[][] grid0 = new char[][]{
                {'1', '1', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '0', '1'}
        };
        char[][] grid1 = new char[][]{
                {'1', '0', '0', '1'},
                {'0', '1', '0', '1'},
                {'1', '1', '0', '1'},
                {'1', '1', '0', '1'}
        };
        char[][] grid2 = new char[][]{
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'}
        };
        char[][] grid3 = new char[][]{
                {'0', '0', '0', '0'},
                {'0', '0', '0', '0'},
                {'0', '0', '0', '0'},
                {'0', '0', '0', '0'}
        };
        System.out.println(numIslands2(grid0) == 2);
        System.out.println(numIslands2(grid1) == 3);
        System.out.println(numIslands2(grid2) == 1);
        System.out.println(numIslands2(grid3) == 0);
    }

    public static int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '0';
                    count += 1;
                    conquer(grid, i, j);
                }
            }
        }
        return count;
    }

    /**
     * 深度优先遍历
     */
    private static void conquer(char[][] grid, int r, int c) {
        final int row = grid.length;
        final int col = grid[0].length;
        //上边的格子
        if (r != 0 && grid[r - 1][c] == '1') {
            grid[r - 1][c] = '0';
            conquer(grid, r - 1, c);
        }
        //下边的格子
        if (r != row - 1 && grid[r + 1][c] == '1') {
            grid[r + 1][c] = '0';
            conquer(grid, r + 1, c);
        }
        //左边的格子
        if (c != 0 && grid[r][c - 1] == '1') {
            grid[r][c - 1] = '0';
            conquer(grid, r, c - 1);
        }
        //右边的格子
        if (c != col - 1 && grid[r][c + 1] == '1') {
            grid[r][c + 1] = '0';
            conquer(grid, r, c + 1);
        }
    }

    /**
     * 广度优先遍历
     */
    public static int numIslands2(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    q.offer(i * col + j);
                    grid[i][j] = '0';
                    while (!q.isEmpty()) {
                        int index = q.poll();
                        int x = index / col;
                        int y = index % col;
                        //上下左右
                        if (x != 0 && grid[x - 1][y] == '1') {
                            q.offer((x - 1) * col + y);
                            grid[x - 1][y] = '0';
                        }
                        if (x != row - 1 && grid[x + 1][y] == '1') {
                            q.offer((x + 1) * col + y);
                            grid[x + 1][y] = '0';
                        }
                        if (y != 0 && grid[x][y - 1] == '1') {
                            q.add(x * col + y - 1);
                            grid[x][y - 1] = '0';
                        }
                        if (y != col - 1 && grid[x][y + 1] == '1') {
                            q.offer(x * col + y + 1);
                            grid[x][y + 1] = '0';
                        }
                    }
                }
            }
        }
        return count;
    }
}
