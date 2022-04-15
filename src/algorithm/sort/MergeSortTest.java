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
		digits = mergeSort(digits);
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


}
