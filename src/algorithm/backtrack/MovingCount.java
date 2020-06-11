package algorithm.backtrack;

/**
 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和
 * 大于k的格子。 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），因为3+5+3+8 = 19。请问该
 * 机器人能够达到多少个格子？
 *
 * @author O
 * @version 1.0
 * @date 2019/7/2
 */
public class MovingCount {
    public static void main(String[] args) {
//        System.out.println("getDigitCount(5): " + getDigitCount(5));

//        System.out.println(movingCount(2, 3, 3));
        System.out.println(movingCount(10, 1, 100));
    }

    /**
     * 思路：回溯法
     */
    static int movingCount(int threshold, int rows, int cols) {
        if (threshold < 1 || rows < 1 || cols < 1) {
            return 0;
        }
        boolean[][] visit = new boolean[rows][cols];
        return doMoving(visit, rows, cols, threshold, 0, 0);
    }

    static int doMoving(boolean[][] visit, int rows, int cols, int threshold, int x, int y) {
        if (x >= rows || y >= cols || x < 0 || y < 0 || visit[x][y] || !check(x, y, threshold)) {
            return 0;
        }
        visit[x][y] = true;
        System.out.println("check " + "( " + x + " , " + y + " ) : " + (getDigitCount(x) + getDigitCount(y)));
        return 1 +
                doMoving(visit, rows, cols, threshold, x - 1, y) +
                doMoving(visit, rows, cols, threshold, x, y - 1) +
                doMoving(visit, rows, cols, threshold, x + 1, y) +
                doMoving(visit, rows, cols, threshold, x, y + 1);
    }

    private static boolean check(int x, int y, int threshold) {
        return (getDigitCount(x) + getDigitCount(y)) <= threshold;
    }

    private static int getDigitCount(int num) {
        int res = 0;
        int temp = 10;
        while (num != 0) {
            res += num % temp;
            num -= num % temp;
            num /= temp;
        }
        return res;
    }
}
