package algorithm.sort;

import java.util.Arrays;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/18
 */
public class HeapSortTest {
	public static void main(String[] args) {
		int[] arr = new int[]{2, 1, 3, 6, 8, 5, 7};
		int[] arr2 = new int[]{4};
		int[] arr3 = new int[]{};
		int[] arr4 = null;
		int[] arr5 = new int[]{3, 6, 8, 5, 7};
		//test insert
//		heapInsert(arr);
//		System.out.println(Arrays.toString(arr));


		//test heapify
//		int[] arrHeapify = new int[]{5, 7, 6, 3, 8};
//		heapify(arr, arrHeapify.length - 1);
//		heapify(arr, arrHeapify.length - 1);
//		System.out.println(Arrays.toString(arrHeapify));

		//test heap sort
		System.out.println(Arrays.toString(heapSort(arr)));
//		System.out.println(Arrays.toString(heapSort(arr2)));
//		System.out.println(Arrays.toString(heapSort(arr3)));
//		try {
//			System.out.println(Arrays.toString(heapSort(arr4)));
//		} catch (Exception e) {
//			System.out.println("catch null");
//		}
	}

	static int[] heapSort(int[] arr) throws NullPointerException {
		if (arr == null) {
			throw new NullPointerException();
		}
		int len = arr.length;
		if (len < 1) {
			return arr;
		}
		heapInsert(arr);
		while (len > 0) {
			swap(arr, 0, --len);
			heapify(arr, len);
		}
		return arr;
	}

	/**
	 * 从上往下，从根开始对比下面的子节点，哪个子节点大就交换，然后继续对比被交换了的子节点
	 *
	 * 每一轮下来都能把最大的值筛选出来，和arr[0]做交换
	 */
	static void heapify(int[] arr, int end) {
		int current, left, right, max;
		for (current = 0; current < end; current++) {
			max = current;
			left = current * 2 + 1;
			right = current * 2 + 2;
			if (left < end && arr[left] > arr[max]) {
				max = left;
			}
			if (right < end && arr[right] > arr[max]) {
				max = right;
			}
			//max == current说明父节点比左右孩子节点都大,不用继续换了,下面已经没有更小的了
			if (max == current) {
				break;
			}
			swap(arr, current, max);
			current = max;
		}
	}

	/**
	 * 从上往下添加节点，构建堆，遇到比父节点大的交换，再继续交换交换了的节点
	 *
	 * 找出最大的数字，在0下标
	 */
	static void heapInsert(int[] arr) {
		//需要声明current，parent，循环上升数字current，一直和父节点对比
		int current;
		int parent = 0;
		for (int i = 1; i < arr.length; i++) {
			current = i;
			while (arr[current] > arr[parent]) {
				swap(arr, current, parent);
				current = parent;
				parent = (current - 1) / 2;
			}
		}
	}

	static void swap(int[] arr, int a, int b) {
//		int temp = arr[a];
//		arr[a] = arr[b];
//		arr[b] = temp;
		//ab相等会造成被修改为0
		if (a != b) {
			arr[a] = arr[a] ^ arr[b];
			arr[b] = arr[a] ^ arr[b];
			arr[a] = arr[a] ^ arr[b];
		}
	}
}
