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
public class InsertSortTest {
	public static void main(String[] args) {
		int[] digits = new int[]{6, 1, 7, 3, 4, 5, 8, 2, 3};
		int[] digits2 = new int[]{9, 1, 7, 3, 4, 5, 8, 2, 3};
		int[] digits3 = new int[]{6, 1, 7, 3, 4, 5, 8, 2, 9};
		int[] digits4 = new int[]{};

		insertSort0(digits);
		insertSort0(digits2);
		insertSort0(digits3);
		insertSort0(digits4);

	}


	static void insertSort(int[] digits) {
		for (int i = 1; i < digits.length; i++) {
			int comparedNum = digits[i];
//			System.out.println("i: " + i + " ,comparedNum: " + comparedNum);
			for (int j = i - 1; j >= 0; j--) {
				if (digits[j] > comparedNum) {
//					System.out.println("swap index: " + i + " and " + j);
					//注意是i--
					digits[i--] = digits[j];
					digits[j] = comparedNum;
				} else {
					break;
				}
//				System.out.println("current: " + Arrays.toString(digits));
			}
		}
		System.out.println("\n\n\nresult: " + Arrays.toString(digits));
	}

	static void insertSort0(int[] arr) {
		int len = arr.length;
		for (int i = 1; i < len; i++) {
			int comparedValue = arr[i];
			int comparedIndex = i - 1;

			while (comparedIndex >= 0 && arr[comparedIndex] > comparedValue) {
				arr[comparedIndex + 1] = arr[comparedIndex];
				comparedIndex--;
			}
			arr[comparedIndex + 1] = comparedValue;
		}


		System.out.println("\n\n\nresult: " + Arrays.toString(arr));

	}
}
