package algorithm.leetcode.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 两数之和
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * <p>
 * 示例:
 * <p>
 * 给定 nums = [2, 7, 11, 15], target = 9
 * <p>
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/7
 */
public class TwoSumTest {
	public static void main(String[] args) {
		int[] nums = new int[]{15, 11, 7, 2};
		int[] nums2 = new int[]{3, 3};
		int target = 18;
		int target2 = 6;
		System.out.println(Arrays.toString(twoSumSortAndPointerHit(nums, target)));
		System.out.println(Arrays.toString(twoSumSortAndPointerHit(nums2, target2)));
	}

	/**
	 * 解法1:使用hash表来解题，target-nums[i]存在，则说明另一个数字存在
	 * 时间复杂度:创建hashmap要O(n),遍历数据要O(n),获取map里面的元素要O(1),总共:O(n)
	 * 空间复杂度:创建hashmap,O(n)
	 */
	static int[] twoSum(int[] nums, int target) {
		int len = nums.length;
		Map<Integer, Integer> map = new HashMap<>(len);
		for (int i = 0; i < len; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < len; i++) {
			Integer index = map.get(target - nums[i]);
			if (index != null && index != i) {
				return new int[]{i, index};
			}

		}
		return null;
	}

	/**
	 * 解法2:暴力解,遍历所有成对的数字
	 */
	static int[] twoSumViolence(int[] nums, int target) {
		return null;
	}

	/**
	 * 解法3:排序+指针碰撞(战胜95%)
	 * 排序之后下标乱序了,所以需要先复制一份
	 * a)复制
	 * b)双指针查找,类似二分
	 * c)两个元素分别在原数组中查找下标,注意顺序,不能返回类似[1,0]的结果
	 * d)返回下标
	 */
	static int[] twoSumSortAndPointerHit(int[] nums, int target) {
		int len = nums.length;
		int[] copy = Arrays.copyOfRange(nums, 0, len);
		Arrays.sort(nums);
		int left = 0, right = len - 1;
		while (left < right) {
			int sum = nums[left] + nums[right];
			if (sum == target) {
				int[] index = new int[2];
				int temp = 0;
				for (int i = 0; i < len; i++) {
					if (nums[left] == copy[i] || nums[right] == copy[i]) {
						index[temp++] = i;
					}
				}
				return index;
			} else if (sum < target) {
				left++;
			} else {
				right--;
			}
		}
		return null;
	}
}
