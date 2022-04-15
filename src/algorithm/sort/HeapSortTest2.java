package algorithm.sort;

import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/14
 */
public class HeapSortTest2 {
	public static void main(String[] args) {
		int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7};
		int[] arr2 = new int[]{7, 6, 5, 4, 3, 2, 1};
		int[] arr3 = new int[]{1, 6, 5, 4, 3, 2, 7};
		int[] arr4 = new int[]{1, 1, 1, 1, 1, 1, 1};
		int[] arr5 = new int[]{1, 1, 1, 0, 1, 1, 1};
		int[] arr6 = new int[]{1, 1, 1, 2, 1, 1, 1};
		int[] arr7 = new int[]{7, 7, 5, 5, 6, 6, 2};
		int[] arr8 = new int[]{-3, 1, 2, 2, 1, 1, -3};

//		heapInsert(arr2);
//		System.out.println(Arrays.toString(arr2));
//		swap(arr2, 0, arr2.length - 1);
//		heapify(arr2, arr2.length - 1);
//		System.out.println(Arrays.toString(arr2));

		heapSort1(arr);
		heapSort1(arr2);
		heapSort1(arr3);
		heapSort1(arr4);
		heapSort1(arr5);
		heapSort1(arr6);
		heapSort1(arr7);
		heapSort1(arr8);
	}

	static void heapSort(int[] arr) {
		if (arr.length <= 1) {
			return;
		}
		heapInsert(arr);
		for (int end = arr.length - 1; end > 0; end--) {
			//注意每次都是0下标和end交换
			swap(arr, 0, end);
			heapify(arr, end);
		}
		System.out.println(Arrays.toString(arr));
	}

	static void heapInsert(int[] arr) {
		int parent;
		int current;
		//针对1开始的每个元素，构建堆
		for (int i = 1; i < arr.length; i++) {
			current = i;
			parent = (current - 1) / 2;
			//如果当前节点比父节点小，一直往上替换，这里产出的是最小堆，最小的值在上面
			while (arr[current] < arr[parent]) {
				swap(arr, current, parent);
				current = parent;
				parent = (current - 1) / 2;
			}
		}
	}

	static void heapify(int[] arr, int end) {
		int current = 0, left, right, min;
		//边界，end之后的数字已经排序完
		while (true) {
			min = current;
			left = current * 2 + 1;
			right = current * 2 + 2;
			//两个if挑选出最小的
			if (left < end && arr[left] < arr[min]) {
				min = left;
			}
			if (right < end && arr[right] < arr[min]) {
				min = right;
			}
			//交换最小值
			if (min != current) {
				swap(arr, min, current);
				current = min;
			} else {
				//注意break的条件，但min=current说明不需要再交换了
				break;
			}
		}

	}

	private static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	//----------------

	static void heapSort1(int[] arr) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		heapInsert1(arr);
		for (int i = arr.length - 1; i > 0; i--) {
			swap(arr, 0, i);
			heapify1(arr, i);
		}
		System.out.println(Arrays.toString(arr));
	}

	static void heapInsert1(int[] arr) {
		int parent, current;
		for (int i = 1; i < arr.length; i++) {
			current = i;
			parent = (current - 1) / 2;
			//最大的在前面
			while (arr[current] > arr[parent]) {
				swap(arr, current, parent);
				current = parent;
				parent = (current - 1) / 2;
			}
		}
	}

	static void heapify1(int[] arr, int end) {
		int left, right, max, cur = 0;
		while (true) {
			max = cur;
			left = cur * 2 + 1;
			right = cur * 2 + 2;
			if (left < end && arr[left] > arr[max]) {
				max = left;
			}
			if (right < end && arr[right] > arr[max]) {
				max = right;
			}
			if (max != cur) {
				swap(arr, max, cur);
				cur = max;
			} else {
				break;
			}
		}
	}
}
