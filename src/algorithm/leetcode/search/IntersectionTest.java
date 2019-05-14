package algorithm.leetcode.search;

import java.util.*;

/**
 * <p>
 * 两个数组的交集
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * 说明:
 * <p>
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/8
 */
public class IntersectionTest {
	public static void main(String[] args) {
		int[] nums1 = new int[]{1, 2, 2, 1};
		int[] nums2 = new int[]{2, 2};
		System.out.println(Arrays.toString(intersection(nums1, nums2)));
	}

	/**
	 * 解法:使用set
	 * a)将nums1数字遍历放入set
	 * b)遍历nums2,存在则删除set中的元素,保证唯一,并在result list中添加元素
	 * c)转化int[],返回
	 */
	static int[] intersection(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		Set<Integer> set = new HashSet<>(len1);
		for (int i = 0; i < len1; i++) {
			set.add(nums1[i]);
		}
		List<Integer> res = new ArrayList<>();
		for (int i = 0; i < len2; i++) {
			if (set.remove(nums2[i])) {
				res.add(nums2[i]);
			}
		}
		int[] arr = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			arr[i] = res.get(i);
		}
		return arr;
	}

}
