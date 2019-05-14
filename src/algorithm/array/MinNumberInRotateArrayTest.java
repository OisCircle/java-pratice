package algorithm.array;

/**
 * <p>
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/13
 */
public class MinNumberInRotateArrayTest {
	public static void main(String[] args) {
		int[] arr = new int[]{5, 6, 7, 1, 2, 3, 4};
		int[] arr2 = new int[]{3, 4, 5, 1, 2};
		int[] arr3 = new int[]{1, 1, 1, 1, 1, 1, 1};
		int[] arr4 = new int[]{3, 4, 4, 5, 1, 1, 1};
		int[] arr5 = new int[]{2, 3, 4, 5, 6, 1};
		int[] arr6 = new int[]{2, 3, 4, 5, 6, 7, 1};
		int[] arr7 = new int[]{1, 0, 1, 1, 1};
		int[] arr8 = new int[]{1, 1, 1, 0, 1};
		System.out.println(minNumberInRotateArray(arr));
		System.out.println(minNumberInRotateArray(arr2));
		System.out.println(minNumberInRotateArray(arr3));
		System.out.println(minNumberInRotateArray(arr4));
		System.out.println(minNumberInRotateArray(arr5));
		System.out.println(minNumberInRotateArray(arr6));
		System.out.println(minNumberInRotateArray(arr7));
		System.out.println(minNumberInRotateArray(arr8));
	}

	/**
	 * 思路要点:arr7和arr8这两个例子要格外注意,遇到left=right,只能O(n)搜索了
	 */
	static int minNumberInRotateArray(int[] array) {
		if (array.length < 1) {
			return 0;
		}
		if (array.length == 1) {
			return array[0];
		}
		int left = 0, right = array.length - 1;
		int mid = (left + right) / 2;
		while (left != mid) {
			if (array[mid] < array[right]) {
				right = mid;
			} else if (array[mid] > array[right]) {
				left = mid;
			} else {
				//O(n)搜索
				return flatSearch(array, left, right);
			}
			mid = (left + right) / 2;
		}
		return array[right];
	}

	private static int flatSearch(int[] array, int left, int right) {
		int min = Integer.MAX_VALUE;
		for (int i = left; i <= right; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		return min;
	}
}
