package algorithm.array;

import java.util.ArrayList;

/**
 * <p>
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/16
 */
public class TopKTest2 {
	public static void main(String[] args) {
		System.out.println(topK(new int[]{6, 5, 3, 2, 4, 1}, 1));
		System.out.println(topK(new int[]{6, 5, 3, 2, 4, 1}, 2));
		System.out.println(topK(new int[]{6, 5, 3, 2, 4, 1}, 3));
		System.out.println(topK(new int[]{6, 5, 3, 2, 4, 1}, 4));
		System.out.println(topK(new int[]{6, 5, 3, 2, 4, 1}, 5));
		System.out.println(topK(new int[]{6, 5, 3, 2, 4, 1}, 6));

//		int[] arr = new int[]{6, 5, 3, 2, 4, 1};
//		quickSort(arr, 0, arr.length - 1);
//		System.out.println(Arrays.toString(arr));
	}

	static void quickSort(int[] arr, int left, int right) {
		if (left < right) {
			int mid = partition(arr, left, right);
			quickSort(arr, left, mid - 1);
			quickSort(arr, mid + 1, right);
		}
	}

	static ArrayList<Integer> topK(int[] input, int k) {
		ArrayList<Integer> res = new ArrayList<>();
		//边界条件一定要注意啊
		if (k > input.length || input.length < 1) {
			return res;
		}
		int start = 0, end = input.length - 1, mid;
		mid = partition(input, start, end);
		while (mid != k - 1) {
			if (mid < k) {
				//mid+1 mid-1要注意
				start = mid + 1;
				mid = partition(input, start, end);
			} else {
				end = mid - 1;
				mid = partition(input, start, end);
			}
		}
		for (int i = 0; i <= mid; i++) {
			res.add(input[i]);
		}
		return res;
	}

	private static int partition(int[] arr, int start, int end) {
		int left = start, pivot = end, right = end;
		while (left < right) {
			while (left < right && arr[left] <= arr[pivot]) {
				left++;
			}
			while (left < right && arr[right] >= arr[pivot]) {
				right--;
			}
			if (left != right) {
				swap(arr, left, right);
			}
		}
		swap(arr, right, pivot);
		return left;
	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}
}
