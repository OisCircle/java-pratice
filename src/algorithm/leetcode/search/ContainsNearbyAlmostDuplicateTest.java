package algorithm.leetcode.search;

import java.util.Set;
import java.util.TreeSet;

/**
 * <p>
 * 存在重复元素 III
 * 给定一个整数数组，判断数组中是否有两个不同的索引 i 和 j，使得 nums [i] 和 nums [j] 的差的绝对值最大为 t，并且 i 和 j 之间的差的绝对值最大为 ķ。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1], k = 3, t = 0
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: nums = [1,0,1,1], k = 1, t = 2
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出: false
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/9
 */
public class ContainsNearbyAlmostDuplicateTest {
	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3, 1};
		int[] nums2 = new int[]{1, 0, 1, 1};
		int[] nums3 = new int[]{1, 5, 9, 1, 5, 9};
		int[] nums4 = new int[]{-1, -1};
		System.out.println(containsNearbyAlmostDuplicate(nums, 3, 0));
		System.out.println(containsNearbyAlmostDuplicate(nums2, 1, 2));
		System.out.println(containsNearbyAlmostDuplicate(nums3, 2, 3));
		System.out.println(containsNearbyAlmostDuplicate(nums4, 1, -1));
	}

	/**
	 * 解法1:维持k+1的滑动窗口,每个窗口的数据放入treeSet保证遍历的时候有序,再每次循环遍历set里面的数据
	 * 时间复杂度:遍历窗口O(n),插入时treeSet的排序O(logn),遍历set,O(n),一共:n^2logn
	 */
	static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		int len = nums.length;
		Set<Long> set = new TreeSet<>();
		for (int i = 0; i < len; i++) {
			//保持滑动窗口大小
			if (i > k) {
				set.remove((long) nums[i - k - 1]);
			}
			if (set.contains((long) nums[i]) && t >= 0) {
				return true;
			}
			set.add((long) nums[i]);
			Long[] longs = set.toArray(new Long[set.size()]);
			for (int j = 0; j < longs.length - 1; j++) {
				if (Math.abs(longs[j] - longs[j + 1]) <= t) {
					return true;
				}
			}
		}
		return false;
	}
}
