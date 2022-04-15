package algorithm.dymanic_programming;

/**
 * <p>
 * 买卖股票的最佳时机 III
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,3,5,0,0,3,1,4]
 * 输出: 6
 * 解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
 * 随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
 * 示例 2:
 * <p>
 * 输入: [1,2,3,4,5]
 * 输出: 4
 * 解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
 * 注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
 * 因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
 * 示例 3:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/23
 */
public class MaxProfitIII {

	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
	}
	/**
	 * 思路：动态规划，注意for里面的含义
	 */
	public static int maxProfit(int[] prices) {
		int buy1Cost = Integer.MIN_VALUE;
		int sell1Earn = 0;
		int buy2Cost = Integer.MIN_VALUE;
		int sell2Earn = 0;
		for (int p : prices) {
			//买/不买p 谁花的钱少
			buy1Cost = Math.max(-p, buy1Cost);
			//卖/不卖p 谁赚的钱多
			sell1Earn = Math.max(buy1Cost + p, sell1Earn);
			//买/不买p 谁花的钱少
			buy2Cost = Math.max(sell1Earn - p, buy2Cost);
			//卖/不卖p 谁赚的钱多
			sell2Earn = Math.max(buy2Cost + p, sell2Earn);
		}
		return sell2Earn;
	}
}
