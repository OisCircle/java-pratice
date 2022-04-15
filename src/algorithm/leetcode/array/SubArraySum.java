package algorithm.leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指Offer专项突破版 第10题 和为k的子数组个数
 * <p>
 * 解法1：暴力解法O(n^3)，算出所有子数组，针对每个子数组计算和是不是等于k，是的话count+1
 * <p>
 * <p>
 * 解法2：使用HashMap<累计合=x，出现的次数>
 * <p>
 * eg: [1,1,1,1,-1]，k=2
 * <p>
 * 每个下标累计合为[1,2,3,4,3]
 * <p>
 * 那么hashMap应该是 [1,1] [2,1] [3,2] [4,1]
 * <p>
 * 遍历数组，针对当前累计合，如3，那么要找到累计合是3-2=1的数字下标，才能得出一个连续数组，这是count+=hashMap的value即可
 *
 * @author qiuchengquan
 * @since 2021/11/2
 */
public class SubArraySum {

	public static void main(String[] args) {
		System.out.println(subArrayNum(new int[]{1, 1, 1,}, 2));
		System.out.println(subArrayNum(new int[]{0, 0, 1, 1, 1, 1, -1}, 3));
	}

	private static int subArrayNum(int[] nums, int k) {
		int count = 0;
		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>(nums.length);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			//累计合数量+1
			map.put(sum, map.getOrDefault(sum, 0) + 1);
			//找出累计合等于sum - k的地方出现的次数就是有多少个子数组符合条件
			int target = sum - k;
			count += map.getOrDefault(target, 0);
			//当前累计合等于k的也要算进去
			if (sum == k) {
				count++;
			}
		}
		return count;
	}
}
