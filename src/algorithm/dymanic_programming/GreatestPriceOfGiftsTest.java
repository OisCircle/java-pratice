package algorithm.dymanic_programming;

import static sun.swing.MenuItemLayoutHelper.max;

/**
 * <p>
 * 剑指47：mxn的棋盘中，从左上角开始走，每次向左或向右走一步，直到右下角，求最大价值
 * 动态规划解法递推公式：p(x,y)=max{p(x-1,y),p(x,y-1)}+gifts[x,y]
 * 每个礼物都和左边和上边的最大值有关，后面的和前面有关，因此动态规划是最好的解法
 * 递归探索所有路径也是可以，不过太慢了，而且容易溢出
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/25
 */
public class GreatestPriceOfGiftsTest {
	public static void main(String[] args) {
		int[][] gifts = new int[][]{
				{1, 10, 3, 8},
				{12, 2, 9, 6},
				{5, 7, 4, 11},
				{3, 7, 16, 5}};
		System.out.println(greatestPrice(gifts, 4, 4));
		System.out.println(greatestPriceRecursively(gifts, 0, 0, 4, 4, 0, 0));
	}

	/**
	 * 要创建二维辅助数组，计算max（x，y）
	 */
	static int greatestPrice(int[][] gifts, int rows, int cols) {
		if (gifts == null || rows <= 0 || cols <= 0) {
			return 0;
		}
		int[][] max = new int[rows][cols];
		for (int x = 0; x < rows; x++) {
			for (int y = 0; y < cols; y++) {
				//注意边界
				if (x == 0 && y == 0) {
					max[x][y] = gifts[x][y];
				} else if (x == 0) {
					max[x][y] = max[x][y - 1] + gifts[x][y];
				} else if (y == 0) {
					max[x][y] = max[x - 1][y] + gifts[x][y];
				} else {
					max[x][y] = max(max[x - 1][y], max[x][y - 1]) + gifts[x][y];
				}
			}
		}
		return max[rows - 1][cols - 1];
	}

	/**
	 * 递归解法，遍历所有步骤并记录最大值
	 * bestPrice：记录历史最大，每次到达递归边界的时候都对比一下
	 */
	static int greatestPriceRecursively(int[][] gifts, int x, int y, int rows, int cols, int currentPrice, int bestPrice) {
		//异常处理
		if (gifts == null || rows <= 0 || cols <= 0) {
			return 0;
		}
		//递归边界
		if (x == rows - 1 && y == cols - 1) {
			int current = currentPrice + gifts[x][y];
			if ((current) > bestPrice) {
				bestPrice = current;
			}
			return bestPrice;
		} else {
			currentPrice += gifts[x][y];
		}
		//试探并记录
		if (x == rows - 1) {
			//只往右试探
			return greatestPriceRecursively(gifts, x, y + 1, rows, cols, currentPrice, bestPrice);
		} else if (y == cols - 1) {
			//只往下试探
			return greatestPriceRecursively(gifts, x + 1, y, rows, cols, currentPrice, bestPrice);
		} else {
			//右下都试探，取最大
			return max(greatestPriceRecursively(gifts, x + 1, y, rows, cols, currentPrice, bestPrice),
					greatestPriceRecursively(gifts, x, y + 1, rows, cols, currentPrice, bestPrice));
		}
	}
}
