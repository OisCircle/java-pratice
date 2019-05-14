package algorithm.array;

import sun.awt.windows.ThemeReader;

import java.util.HashMap;

/**
 * <p>
 * 这里要注意的一点是数字范围都是 0 ~ n-1，所以每次遍历更换坐标就可以了O（n）时间复杂度解决
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/13
 */
public class DuplicateNumberTest {
	public static void main(String[] args) throws Exception {
		int[] nums = new int[]{6, 1, 7, 3, 4, 7, 8, 2, 3};
//		System.out.println(getDuplicateNum(nums));
//		System.out.println(getDuplicateNum(new int[]{0}));
//		System.out.println(getDuplicateNum(null));
//		System.out.println(getDuplicateNum(new int[]{}));


//		System.out.println(duplicateNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
//		System.out.println(duplicateNumber(new int[]{2, 3, 1, 0, 2, 5, 3}));
//		System.out.println(duplicateNumberHashMap(new int[]{2, 3, 1, 0, 6, 5, 4}));

	}

	static int getDuplicateNum(int[] nums) throws Exception {
		if (nums == null || nums.length <= 1) {
			throw new Exception("invalid input");
		}
		int len = nums.length;
		int value;
		for (int i = 0; i < len; i++) {
			value = nums[i];
			if (value == nums[value] && i != value) {
				return value;
			} else {
				nums[i] = nums[value];
				nums[value] = value;
			}
		}
		throw new Exception("number range wrong");
	}


	static int duplicateNumber(int[] nums) throws Exception {
		if (nums == null || nums.length < 1) {
			throw new Exception();
		}
		int len = nums.length;
		for (int i = 0; i < len; i++) {
			if (nums[i] != i && nums[i] == nums[nums[i]]) {
				return nums[i];
			}
			while (nums[i] != i) {
				swap(nums, i, nums[i]);
			}
		}
		throw new Exception("不存在重复");
	}

	static int duplicateNumberHashMap(int[] nums) throws Exception {
		if (nums == null || nums.length < 1) {
			throw new Exception();
		}
		int len = nums.length;
		HashMap<Integer, Integer> map = new HashMap<>(len);
		for (int i = 0; i < len; i++) {
			Integer num = map.get(nums[i]);
			if (num != null) {
				map.put(nums[i], num + 1);
			} else {
				map.put(nums[i], 1);
			}
		}
		for (int i = 0; i < len; i++) {
			if (map.get(i) > 1) {
				return i;
			}
		}
		throw new Exception("不存在重复");
	}

	static void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}
