package algorithm.array;

/**
 * <p>
 * 剑指63题：股票的最大利润，找出前后差值最大的利润
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/29
 */
public class MaxProfitTest {
	public static void main(String[] args) {
		int[] prices = new int[]{9, 11, 8, 5, 7, 12, 16, 14};
		int[] prices2 = new int[]{9, 11};
		int[] prices3 = new int[]{11, 9};

		System.out.println(maxProfit(prices));
		System.out.println(maxProfit(prices2));
		System.out.println(maxProfit(prices3));
	}

	/**
	* 思路：遍历过程中维护一个最小值，再利用当前值减去最小值来动态地运算出最大利润
	*/
	static int maxProfit(int[] prices) {
		int len = 0;
		if (prices != null && (len = prices.length) <= 1) {
			return 0;
		}
		int min = prices[0], maxProfit = 0;
		for (int i = 1; i < len; i++) {
			if (prices[i] < min) {
				min = prices[i];
			}
			if ((prices[i] - min) > maxProfit) {
				maxProfit = prices[i] - min;
			}
		}
		return maxProfit;
	}


}
