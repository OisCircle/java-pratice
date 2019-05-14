package algorithm.array;

/**
 * <p>
 * 统计一个数字在排序数组中出现的次数。
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/20
 */
public class GetNumberOfKTest {
	public static void main(String[] args) {
		System.out.println(getNumberOfK(new int[]{1, 2, 2, 2, 2, 3, 3, 4, 5}, 2));
		System.out.println(getNumberOfK(new int[]{1, 2, 2, 2, 2, 3, 3, 5, 5}, 5));
		System.out.println(getNumberOfK(new int[]{1, 1, 2, 2, 2, 3, 3, 4, 5}, 1));
		System.out.println(getNumberOfK(new int[]{1, 2, 3}, 1));
		System.out.println(getNumberOfK(new int[]{1, 2, 3}, 3));
		System.out.println(getNumberOfK(new int[]{1, 2, 3}, 2));
		System.out.println(getNumberOfK(new int[]{1, 2, 3}, 4));
	}

	/**
	 * 思路:获取第一次的下标,再获取第二次的下标,注意返回-1是找不到
	 */
	static int getNumberOfK(int[] array, int k) {
		int last = getLast(array, k);
		int first = getFirst(array, k);
		if (first != -1 && last != -1) {
			return last - first + 1;
		}
		return 0;
	}

	private static int getFirst(int[] array, int k) {
		int len = array.length;
		int left = 0;
		int right = len - 1;
		int mid = (left + right) / 2;
		//注意是小于等于,不然会有bug,利用调试可以知道
		while (left <= right) {
			if (array[mid] < k) {
				left = mid + 1;
			} else if (array[mid] > k) {
				right = mid - 1;
			} else if (mid - 1 >= 0 && array[mid - 1] == k) {
				//这个分支是判断已经相等的情况下,继续往左边查找
				right = mid - 1;
			} else {
				return mid;
			}
			mid = (left + right) / 2;
		}
		return -1;
	}

	private static int getLast(int[] array, int k) {
		int len = array.length;
		int left = 0;
		int right = len - 1;
		int mid = (left + right) / 2;
		while (left <= right) {
			if (array[mid] < k) {
				left = mid + 1;
			} else if (array[mid] > k) {
				right = mid - 1;
			} else if (mid + 1 < len && array[mid + 1] == k) {
				//这个分支是判断已经相等的情况下,继续往右边查找
				left = mid + 1;
			} else {
				return mid;
			}
			mid = (left + right) / 2;
		}
		return -1;
	}
}
