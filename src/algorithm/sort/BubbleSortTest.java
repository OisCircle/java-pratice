package algorithm.sort;

import java.util.Arrays;

/**
 * <p>
 * 这不是冒泡排序。。。写错了
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/2/27
 */
public class BubbleSortTest {
	public static void main(String[] args) {
		int[] digits = new int[]{6, 1, 7, 3, 4, 5, 8, 2, 3};
		int[] digits2 = new int[]{9, 1, 7, 3, 4, 5, 8, 2, 3};
		int[] digits3 = new int[]{6, 1, 7, 3, 4, 5, 8, 2, 9};
		int[] digits4 = new int[]{};

		bubbleSort(digits);
		bubbleSort(digits2);
		bubbleSort(digits3);
		bubbleSort(digits4);
	}

	static void bubbleSort(int[] digits) {
		for (int i = 0; i < digits.length; i++) {
			for (int j = i; j < digits.length; j++) {
				if (digits[i] > digits[j]) {
					swap(digits, i, j);
				}
			}
		}
		System.out.println("\n\n\nresult: " + Arrays.toString(digits));
	}

	static void swap(int[] digits, int a, int b) {
		int temp = digits[a];
		digits[a] = digits[b];
		digits[b] = temp;
	}
}
