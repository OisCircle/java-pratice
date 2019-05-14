package algorithm.leetcode.search;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/9
 */
public class ContainsNearbyDuplicateTest {
	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3, 1};
		int[] nums2 = new int[]{1, 2, 3, 1, 2, 3};
		int[] nums3 = new int[]{1, 0, 1, 1};
		System.out.println(containsNearbyDuplicateHashMap(nums, 3));
		System.out.println(containsNearbyDuplicateHashMap(nums2, 2));
		System.out.println(containsNearbyDuplicateHashMap(nums3, 1));
	}

	/**
	 * 解法1:滑动窗口方式,以k间隔为滑动窗口,循环对比,直到k减少到1,时间复杂度O(n^2)
	 * 超时!!!
	 */
	static boolean containsNearbyDuplicate(int[] nums, int k) {
		int len = nums.length;
		for (int gap = k; gap >= 1; gap--) {
			for (int j = 0; j + gap < len; j++) {
				if (nums[j] == nums[j + gap]) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 解法2:滑动窗口(k),不断查找k里面有没有重复元素即可,时间复杂度O(nk)
	 * 超时!!!
	 */
	static boolean containsNearbyDuplicate2(int[] nums, int k) {
		int len = nums.length;
		Map<Integer, Integer> map = new HashMap<>(k);
		for (int i = 0; i < len; i++) {
			for (int j = i; j <= i + k && j < len; j++) {
				if (map.containsKey(nums[j])) {
					return true;
				} else {
					map.put(nums[j], 1);
				}
			}
			map.clear();
		}
		return false;
	}

	/**
	 * 解法3:遍历,并用hashmap记录下标,存在值则判断下标绝对值是否小于k,时间复杂度O(n)
	 * 最优解
	 */
	static boolean containsNearbyDuplicateHashMap(int[] nums, int k) {
		int len = nums.length;
		Map<Integer, Integer> map = new HashMap<>(k);
		for (int i = 0; i < len; i++) {
			if (map.containsKey(nums[i])) {
				if (Math.abs(i - map.get(nums[i])) <= k) {
					return true;
				}
			}
			map.put(nums[i], i);
		}
		return false;
	}
}
