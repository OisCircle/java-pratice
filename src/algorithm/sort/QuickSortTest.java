package algorithm.sort;

import java.util.Arrays;
import java.util.Stack;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/2/27
 */
public class QuickSortTest {
	public static void main(String[] args) {
		int[] digits = new int[]{6, 1, 7, 3, 4, 5, 8, 2, 3};
		int[] digits2 = new int[]{9, 1, 7, 3, 4, 5, 8, 2, 3};
		int[] digits3 = new int[]{6, 1, 7, 3, 4, 5, 8, 2, 9};
		int[] digits4 = new int[]{};
		quickSort(digits, 0, digits.length - 1);
		quickSort(digits2, 0, digits2.length - 1);
		quickSort(digits3, 0, digits3.length - 1);
		quickSort(digits4, 0, digits3.length - 1);

//		quickSortLoop(digits);
//		quickSortLoop(digits2);
//		quickSortLoop(digits3);
//		quickSortLoop(digits4);


		Arrays.stream(digits).forEach(System.out::print);
		System.out.println();
		Arrays.stream(digits2).forEach(System.out::print);
		System.out.println();
		Arrays.stream(digits3).forEach(System.out::print);
		System.out.println();
		Arrays.stream(digits4).forEach(System.out::print);

	}

	static int partition(int[] digits, int left, int right) {
		int mid = right;
		while (left < right) {
			//移动左边坐标
			while (left < right && digits[left] <= digits[mid]) {
				left++;
			}
			//移动右边坐标
			while (left < right && digits[right] >= digits[mid]) {
				right--;
			}
			//交换左右坐标的值
			swap(digits, left, right);
//			System.out.println("swap index: " + left + " and " + right);
		}
		//交换mid的值，mid左边小于mid，mid右边大于mid
//		System.out.println("swap mid index: " + left + " and " + mid);
		swap(digits, left, mid);
//		Arrays.stream(digits).forEach(System.out::print);
//		System.out.println();
		return left;
	}

	static void quickSort(int[] digits, int left, int right) {
		if (digits.length <= 1) {
			return;
		}
		if (left < right) {
			int mid = partition(digits, left, right);
			quickSort(digits, left, mid - 1);
			quickSort(digits, mid + 1, right);
		}
	}

	static void quickSortLoop(int[] arr) {
		if (arr.length < 1) {
			return;
		}
		Stack<Record> stack = new Stack<>();
		//一定要注意我自己实现的partition函数，要传入数组左边的坐标，不是len而是len-1
		int left = 0, right = arr.length - 1;
		//第一次分区，初始化栈
		int mid = partition(arr, left, right);
		right = mid - 1;
		if (right - left > 0) {
			stack.push(new Record(left, right));
		}
		left = mid + 1;
		right = arr.length - 1;
		if (right - left > 0) {
			stack.push(new Record(left, right));
		}
		//循环pop，分区，push
		while (!stack.isEmpty()) {
			Record record = stack.pop();
			mid = partition(arr, record.left, record.right);
			left = record.left;
			right = mid - 1;
			if (right - left > 0) {
				stack.push(new Record(left, right));
			}
			left = mid + 1;
			right = arr.length - 1;
			if (right - left > 0) {
				stack.push(new Record(left, right));
			}
		}
	}

	static void swap(int[] digits, int a, int b) {
		int temp = digits[a];
		digits[a] = digits[b];
		digits[b] = temp;
	}

	private static class Record {
		int left;
		int right;

		public Record(int left, int right) {
			this.left = left;
			this.right = right;
		}
	}
}
