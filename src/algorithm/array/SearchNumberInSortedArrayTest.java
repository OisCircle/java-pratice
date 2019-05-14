package algorithm.array;

/**
 * <p>
 * 剑指53题：在排序数组中查找数字
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/27
 */
public class SearchNumberInSortedArrayTest {
	public static void main(String[] args) {
		int[] arr1 = new int[]{1, 2, 3, 3, 3, 3, 4, 5};
		int[] arr2 = new int[]{1, 2, 2, 3, 4, 5, 6, 7};
		int[] arr3 = new int[]{1, 2, 6, 6, 6, 6, 6, 6};

		System.out.println(existCountDoubleSearch(arr1, 3));
		System.out.println(existCountDoubleSearch(arr2, 2));
		System.out.println(existCountDoubleSearch(arr3, 6));
	}

	/**
	 * 在arr中查找num出现的次数
	 * 解法1：先用二分查找找到出现的第一个，再左右搜索一共有多少个
	 */
	static int existCountDoubleSearch(int[] arr, int num) {
		int left = 0, right = arr.length - 1;
		int mid;
		while (left <= right) {
			mid = (left + right) / 2;
			if (arr[mid] == num) {
				return leftRightSearch(arr, mid);
			} else if (arr[mid] > num) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return 0;
	}

	static int leftRightSearch(int[] arr, int start) {
		int num = arr[start];
		int len = arr.length;
		int left = start, right = start;
		while (left - 1 >= 0 && arr[left - 1] == num) {
			left--;
		}
		while (right + 1 < len && arr[right + 1] == num) {
			right++;
		}
		return right - left + 1;
	}

	/**
	 * 在arr中查找num出现的次数
	 * 解法2：用二分查找找出第一个和最后一个的下标
	 */
	static int existCountBinarySearchOnly(int[] arr, int num) {
		return -1;
	}
}
