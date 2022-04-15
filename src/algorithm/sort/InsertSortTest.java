package algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序，认为comparedValue前面的数据都是有序的
 *
 * @author O
 * @version 1.0
 * @since 2019/2/27
 */
public class InsertSortTest {
	public static void main(String[] args) {
		int[] digits = new int[]{6, 1, 7, 3, 4, 5, 8, 2, 3};
		int[] digits2 = new int[]{9, 1, 7, 3, 4, 5, 8, 8, 2, 3};
		int[] digits3 = new int[]{6, 1, 7, 3, 4, 5, 5, 8, 2, 9};
		int[] digits4 = new int[]{};

		insertSort1(digits);
		insertSort1(digits2);
		insertSort1(digits3);
		insertSort1(digits4);

	}

	static void insertSort0(int[] arr) {
		int len = arr.length;
		for (int i = 1; i < len; i++) {
			int comparedValue = arr[i];
			int comparedIndex = i - 1;
			//往前挪一批比comparedValue大的数据
			while (comparedIndex >= 0 && arr[comparedIndex] > comparedValue) {
				arr[comparedIndex + 1] = arr[comparedIndex];
				comparedIndex--;
			}
			//最后把comparedValue设置到挪走之后的空位
			arr[comparedIndex + 1] = comparedValue;
		}
		System.out.println("\n\n\nresult: " + Arrays.toString(arr));
	}

	static void insertSort1(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		for (int i = 1; i < arr.length; i++) {
			int compareValue = arr[i];
			int index = i - 1;
			while (index >= 0 && arr[index] > compareValue) {
				arr[index + 1] = arr[index];
				index--;
			}
			arr[index + 1] = compareValue;
		}
		System.out.println(Arrays.toString(arr));
	}
}
