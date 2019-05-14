package algorithm.array;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * <p>
 * top k 问题
 * 解法1：采用快速排序中的partition思想，每次分区之后判断在左边的分区还是在右边的分区
 * 优点：O（n）时间复杂度
 * 缺点：改动了数组
 *
 * 解法2：采用一个最大堆（有k个），每次塞入数据，超过k个数的时候，k+1之后的数要和最大值作比较，小于最大值要置换（很简单实现）
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/12
 */
public class TopKTest {
	public static void main(String[] args) {
		int[] nums = new int[]{6, 1, 7, 3, 4, 5, 8, 2, 3};
		System.out.println(Arrays.toString(topK(nums, 4)));
		System.out.println(Arrays.toString(topK(nums, 6)));
		System.out.println(Arrays.toString(topK(nums, -1)));
		System.out.println(Arrays.toString(topK(nums, 0)));
		System.out.println(Arrays.toString(topK(nums, nums.length)));
		System.out.println(Arrays.toString(topK(null, nums.length)));
	}

	static int[] topK(int[] nums, int k) {
		if (nums == null) {
			return null;
		}
		int len = nums.length;
		if (len == 0 || k < 0 || k > len) {
			return null;
		}
		if (len == k) {
			return nums;
		}

		int start = 0;
		int end = len - 1;
		int index = partition(nums, start, end);
		while (index != k - 1) {
			if (index > k - 1) {
				end = index - 1;
				index = partition(nums, start, end);
			} else {
				start = index + 1;
				index = partition(nums, start, end);
			}
		}
		return Arrays.copyOfRange(nums, 0, k);
	}
	/**
	*
	*/
	static int partition(int[] nums, int start, int end) {
		int len = nums.length;
		int pivot = end;
		int temp;
		if (start > end || end > len || start < 0) {
			return -1;
		}
		while (start != end) {
			while (nums[start] <= nums[pivot] && start != end) {
				start++;
			}
			while (nums[end] >= nums[pivot] && start != end) {
				end--;
			}
			temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
		}
		temp = nums[start];
		nums[start] = nums[pivot];
		nums[pivot] = temp;
		return start;
	}
}
