package algorithm.array;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/14
 */
public class BinarySearchTest {
	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 3, 5, 7, 8, 9};

		System.out.println(binarySearch(nums, 5));
		System.out.println(binarySearch(nums, 9));
		System.out.println(binarySearch(nums, 1));
		System.out.println(binarySearch(null, 1));

		System.out.println(firstBadVersion(2));
	}

	static int binarySearch(int[] nums, int number) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		int len = nums.length;
		int left = 0;
		int right = len - 1;
		int mid;
		while (left <= right) {
			mid = (left + right) / 2;
			if (number == nums[mid]) {
				return mid;
			}
			if (number < nums[mid]) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	static int firstBadVersion(int n) {
		int l = 1, h = n;
		while (l < h) {
			int mid = l + (h - l) / 2;
			if (isBadVersion(mid)) {
				h = mid;
			} else {
				l = mid + 1;
			}
		}
		return h;
	}

	static boolean isBadVersion(int n) {
		if (n == 1) {
			return true;
		} else {
			return true;
		}
//		else if (n == 2) {
//			return false;
//
//		} else if (n == 3) {
//			return false;
//
//		} else if (n == 4) {
//			return true;
//		} else {
//			return true;
//		}
	}

}
