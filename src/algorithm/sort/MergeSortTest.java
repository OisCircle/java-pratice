package algorithm.sort;

import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/4
 */
public class MergeSortTest {
	public static void main(String[] args) {
		int[] digits = new int[]{6, 1, 7, 3, 4, 5, 8, 2, 3};
		digits = mergeSort1(digits);
		System.out.println(Arrays.toString(digits));
	}

	static int[] mergeSort(int[] arr) {
		if (arr.length < 2) {
			return arr;
		}
		int mid = arr.length / 2;
		int[] left = Arrays.copyOfRange(arr, 0, mid);
		int[] right = Arrays.copyOfRange(arr, mid, arr.length);
		return merge(mergeSort(left), mergeSort(right));
	}

	//注意！这是合并两个“已经排好序的”数组
	static int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		for (int leftIndex = 0, rightIndex = 0, resultIndex = 0; resultIndex < result.length; resultIndex++) {
			if (leftIndex >= left.length) {
				result[resultIndex] = right[rightIndex++];
			} else if (rightIndex >= right.length) {
				result[resultIndex] = left[leftIndex++];
			} else if (left[leftIndex] < right[rightIndex]) {
				result[resultIndex] = left[leftIndex++];
			} else {
				result[resultIndex] = right[rightIndex++];
			}
		}
		return result;
	}

	static int[] mergeSort1(int[] arr) {
		if (arr.length <= 1) {
			return arr;
		}
		int mid = arr.length / 2;
		int[] left = Arrays.copyOfRange(arr, 0, mid);
		int[] right = Arrays.copyOfRange(arr, mid, arr.length);
//		后续遍历模型，可以理解为先深度遍历到最底下，再往上执行merge1（）
//		int[] sortedLeft = mergeSort1(left);
//		int[] sortedRight = mergeSort1(right);
//		return merge1(sortedLeft, sortedRight);
		return merge1(mergeSort1(left), mergeSort1(right));
	}

	static int[] merge1(int[] left, int[] right) {
		int[] res = new int[left.length + right.length];
		int leftIndex = 0, rightIndex = 0;
		for (int i = 0; i < res.length; i++) {
			if (leftIndex >= left.length) {
				//左边已经到最后一个元素了，取右边的
				res[i] = right[rightIndex++];
			} else if (rightIndex >= right.length) {
				//右边已经到最后一个元素了，取左边的
				res[i] = left[leftIndex++];
			} else if (left[leftIndex] > right[rightIndex]) {
				res[i] = right[rightIndex++];
			} else {
				res[i] = left[leftIndex++];
			}
		}
		return res;
	}
}
