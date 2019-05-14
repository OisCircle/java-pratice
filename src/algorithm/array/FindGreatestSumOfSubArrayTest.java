package algorithm.array;

import java.util.Arrays;

/**
 * <p>
 * 剑指offer 42题：寻找连续子数组的最大和
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/24
 */
public class FindGreatestSumOfSubArrayTest {
	public static void main(String[] args) throws Exception {
		int[] arr = new int[]{1, -2, 3, 10, -4, 7, 2, -5};
		printSubArrayA(arr);
		printSubArrayB(arr);
		System.out.println(maxSubArray(arr));
		System.out.println(maxSubArrayQuick(arr));
	}

	/**
	 * 遍历所有子数组，遍历的同时进行统计大小，并与max作比较
	 * 至少要O（n^2）时间复杂度解法，不推荐
	 */
	static int maxSubArray(int[] arr) {
		int len = arr.length;
		int max = 0, current;
		for (int i = 0; i < len; i++) {
			for (int j = 1; j + i <= len; j++) {
				current = 0;
				for (int k = i; k < j + i; k++) {
					current += arr[k];
				}
				if (current > max) {
					max = current;
				}
			}
		}
		return max;
	}

	/**
	 * O（n）时间复杂度解法
	 * 从0开始遍历，统计过程中发现总和小于0则放弃之前的所有统计，从下一个坐标开始统计，并同时记录最大值
	 */
	static int maxSubArrayQuick(int[] arr) throws Exception {
		if (arr == null || arr.length < 1) {
			throw new Exception("Invalid Input !");
		}
		int max = -65536, current = 0, len = arr.length;
		for (int i = 0; i < len; i++) {
			//learn from jdk source code
			if ((current += arr[i]) < 0) {
				current = 0;
			} else {
				//简化成一行，可能会有性能问题
				max = current > max ? current : max;
			}
		}
		return max;
	}

	/**
	 * 输出连续的子数组
	 */
	static void printSubArrayA(int[] arr) {
		int len = arr.length;
		System.out.println("--------------");
		for (int i = 0; i < len; i++) {
			for (int j = 1; j + i <= len; j++) {
				System.out.println(Arrays.toString(Arrays.copyOfRange(arr, i, j + i)));
			}
		}
		System.out.println("--------------");
	}

	/**
	 * 输出连续的子数组
	 * 可读性强一点
	 */
	static void printSubArrayB(int[] arr) {
		int len = arr.length;
		System.out.println("--------------");
		for (int i = 1; i <= len; i++) {
			for (int j = 0; j + i <= len; j++) {
				System.out.println(Arrays.toString(Arrays.copyOfRange(arr, j, j + i)));
			}
		}
		System.out.println("--------------");
	}

}
