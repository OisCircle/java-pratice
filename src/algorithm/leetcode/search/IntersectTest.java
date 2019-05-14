package algorithm.leetcode.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * <p>
 * 两个数组的交集 II
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 * 示例 2:
 * <p>
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/7
 */
public class IntersectTest {
	public static void main(String[] args) {
		int[] nums1 = new int[]{1, 2, 2, 1};
		int[] nums2 = new int[]{2, 2};
		System.out.println(Arrays.toString(intersect(nums1, nums2)));
	}

	static int[] intersect(int[] nums1, int[] nums2) {
		int len1 = nums1.length;
		int len2 = nums2.length;
		HashMap<Integer, Integer> map = new HashMap<>(len1);
		List<Integer> res = new ArrayList<>(len1);
		for (int i = 0; i < len1; i++) {
			if (map.containsKey(nums1[i])) {
				map.put(nums1[i], map.get(nums1[i]) + 1);
			} else {
				map.put(nums1[i], 1);
			}
		}
		for (int i = 0; i < len2; i++) {
			if (map.containsKey(nums2[i])) {
				int count = map.get(nums2[i]);
				res.add(nums2[i]);
				if (count > 1) {
					map.put(nums2[i], count - 1);
				} else {
					map.remove(nums2[i]);
				}
			}
		}
		int[] temp = new int[res.size()];
		for (int i = 0; i < temp.length; i++) {
			temp[i] = res.get(i);
		}
		return temp;
	}

}
