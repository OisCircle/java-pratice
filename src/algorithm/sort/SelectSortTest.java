package algorithm.sort;

import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/2/27
 */
public class SelectSortTest {
	public static void main(String[] args) {
		int[] digits = new int[]{6, 1, 7, 3, 4, 5, 8, 2, 3};
		int[] digits2 = new int[]{9, 1, 7, 3, 4, 5, 8, 2, 3};
		int[] digits3 = new int[]{6, 1, 7, 3, 4, 5, 8, 2, 9};
		int[] digits4 = new int[]{};


		selectSort0(digits);
		selectSort0(digits2);
		selectSort0(digits3);
		selectSort0(digits4);
	}

	static void selectSort(int[] digits) {
		for (int i = 0; i < digits.length; i++) {
			for (int j = i; j < digits.length; j++) {
				//选择出最小的数字
				int selected = i;
				if (digits[selected] > digits[j]) {
					selected = j;
				}
				swap(digits, selected, i);
			}
		}

		System.out.println("\n\n\nresult: " + Arrays.toString(digits));
	}

	static void selectSort0(int[] arr) {
		if (arr.length < 1) {
			return;
		}
		int max ;
		for (int i = 0; i < arr.length; i++) {
			max = i;
			for (int j = i; j < arr.length; j++) {
				if (arr[j] > arr[max]) {
					max = j;
				}
			}
			swap(arr, i, max);
		}
		System.out.println("\n\n\nresult: " + Arrays.toString(arr));
	}
	static void swap(int[] digits, int a, int b) {
		int temp = digits[a];
		digits[a] = digits[b];
		digits[b] = temp;
	}

}
