package algorithm.leetcode.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <p>
 * 三数之和
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/7
 */
public class ThreeSumTest {
	public static void main(String[] args) {
		int[] nums = new int[]{-1, 0, 1, 2, -1, -4};
		int[] nums2 = new int[]{0, 0, 0, 0};
		int[] nums3 = new int[]{-2, 0, 0, 2, 2};
		int[] nums4 = new int[]{-1, 0, 1, 0};
		int[] nums5 = new int[]{-2, 0, 1, 1, 2};
		int[] nums6 = new int[]{-2, 2};
		System.out.println(threeSum(nums));
		System.out.println(threeSum2(nums));
		System.out.println(threeSum(nums2));
		System.out.println(threeSum2(nums2));
		System.out.println(threeSum(nums3));
		System.out.println(threeSum2(nums3));
		System.out.println(threeSum(nums4));
		System.out.println(threeSum2(nums4));
		System.out.println(threeSum(nums5));
		System.out.println(threeSum2(nums5));
		System.out.println(threeSum(nums6));
		System.out.println(threeSum2(nums6));
	}

	/**
	 * 解法:
	 * a)sort,避免重复
	 * b)每次选择一个数字pivot,再从后面的数字中二分查找
	 * c)遇到重复的数字pivot要continue
	 * d)遇到重复的二分指针,也要一直减
	 */
	static List<List<Integer>> threeSum(int[] nums) {
		int len = nums.length;
		Arrays.sort(nums);
		if (len < 3) {
			return Collections.emptyList();
		}
		List<List<Integer>> res = new ArrayList<>(len / 2);
		List<Integer> list;
		for (int i = 0; i < len - 2; i++) {
			//重复的i要跳过,避免重复
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int left = i + 1, right = len - 1;
			int target = -nums[i];
			while (left < right) {
				//找到了
				if (nums[left] + nums[right] == target) {
					//添加
					list = new ArrayList<>(3);
					list.add(nums[i]);
					list.add(nums[left]);
					list.add(nums[right]);
					res.add(list);
					//去重,同时要保证坐标left < right
					while (left < right && nums[left] == nums[left + 1]) {
						left++;
					}
					while (left < right && nums[right] == nums[right - 1]) {
						right--;
					}
					//有没有重复,都要+1
					left++;
					right--;
				} else if (nums[left] + nums[right] + nums[i] > 0) {
					//如果数字太大,则right--,小一点
					right--;
				} else {
					//否则要大一点
					left++;
				}
			}
		}
		return res;
	}

	/**
	 * 排除重复结果，两个地方要处理
	 * <p>
	 * 思路：
	 *
	 * 1 twoSum先写好，从一个范围区间里面穷举例两个下标之合等于target的集合
	 *
	 * 2 固定一个数字，从剩下的范围里面O(n)穷举twoSum
	 *
	 * 3 用来做下标的变量在移动的时候，都要排除重复值的下标，所以外层固定指针移动的时候要去重复，内层twoSum移动的时候也要去重复
	 */
	static List<List<Integer>> threeSum2(int[] nums) {
		int len = nums.length;
		Arrays.sort(nums);
		if (len < 3) {
			return Collections.emptyList();
		}
		List<List<Integer>> res = new ArrayList<>(len / 2);
		for (int i = 0; i < len - 2; i++) {
			twoSum(i, nums, -nums[i], res);
			//排除重复结果
			int same = nums[i];
			while (i < len && nums[i] == same) {
				i++;
			}
		}
		return res;
	}

	public static void twoSum(int start, int[] nums, int target, List<List<Integer>> res) {
		int l = start, r = nums.length - 1;
		while (l < r) {
			if (nums[l] + nums[r] == target) {
				res.add(Arrays.asList(nums[start], nums[l], nums[r]));
			}
			int same;
			if (nums[l] + nums[r] > target) {
				same = nums[r];
				//排除重复结果
				while (r > l && nums[r] == same) {
					r--;
				}
			} else {
				same = nums[l];
				//排除重复结果
				while (l < r && nums[l] == same) {
					l++;
				}
			}
		}
	}
}
