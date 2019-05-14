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
		System.out.println(threeSum(nums2));
		System.out.println(threeSum(nums3));
		System.out.println(threeSum(nums4));
		System.out.println(threeSum(nums5));
		System.out.println(threeSum(nums6));
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

}
