package algorithm.leetcode.array;

/**
 * 剑指Offer专项突破版 第九题 所有乘积小于等于k的连续子数组数量
 *
 * 假设k=100，数组：[10,5,2,6]
 *
 * 输出结果：8
 *
 * [10][5][2][6][10,5][5,2][2,6][5,2,6]
 *
 *
 * 解法：双指针，跟 @see MinSubArrayLen 类似，在计算count的时候有一定技巧性
 * @author qiuchengquan
 * @since 2021/11/2
 */
public class NumSubArrayProductLessThanK {

	public static void main(String[] args) {
		System.out.println(num(new int[]{10, 5, 2, 6}, 100));
	}

	private static int num(int[] nums, int k) {
		long product = 1;
		int left = 0, count = 0;
		for (int right = 0; right < nums.length; right++) {
			product *= nums[right];
			//累积合大于等于k，则left往右走，直到累积合小于k
			while (left <= right && product >= k) {
				product /= nums[left++];
			}
			//！子数组数量等于两下标之间的长度！没理解，就很神奇，神奇地避开了重复子数组的问题
			//例如[2,6,8]连续子数组数量就是1+2+3，左右指针过程：[0,0]->1,[0,1]->2,[0,2]->3，加起来就是6
			count += right >= left ? right - left + 1 : 0;
		}
		return count;
	}
}
