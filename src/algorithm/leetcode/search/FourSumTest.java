package algorithm.leetcode.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <p>
 * 四数之和
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 * <p>
 * 注意：
 * <p>
 * 答案中不可以包含重复的四元组。
 * <p>
 * 示例：
 * <p>
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 * <p>
 * 满足要求的四元组集合为：
 * [
 * [-1,  0, 0, 1],
 * [-2, -1, 1, 2],
 * [-2,  0, 0, 2]
 * ]
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/8
 */
public class FourSumTest {
	public static void main(String[] args) {
		int[] nums = new int[]{1, 0, -1, 0, -2, 2};
		int target = 0;
		System.out.println(fourSum(nums, target));
	}

	/**
	 * 解法：在三数之和的基础上，选第一位数字(i),再循环遍历第二位以后的数字(j),并且注意去重,再使用二指针碰撞找出target
	 */
	static List<List<Integer>> fourSum(int[] nums, int target) {
		int len = nums.length;
		Arrays.sort(nums);
		List<List<Integer>> res = new ArrayList<>(len / 2);
		List<Integer> list;
		for (int i = 0; i < len - 3; i++) {
			//第一次去重
			if (i > 0 && nums[i - 1] == nums[i]) {
				continue;
			}
			for (int j = i + 1; j < len - 2; j++) {
				//第二次去重
				if (j > i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				int aim = target - nums[i] - nums[j];
				int left = j + 1, right = len - 1;
				while (left < right) {
					if (nums[left] + nums[right] == aim) {
						list = new ArrayList<>(4);
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[left]);
						list.add(nums[right]);
						res.add(list);
						//第三次去重
						while (left < right && nums[left] == nums[left + 1]) {
							left++;
						}
						while (left < right && nums[right] == nums[right - 1]) {
							right--;
						}
						left++;
						right--;
					} else if (nums[left] + nums[right] < aim) {
						left++;
					} else {
						right--;
					}
				}
			}
		}
		return res;
	}
}
