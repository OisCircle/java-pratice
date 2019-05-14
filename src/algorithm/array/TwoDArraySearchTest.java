package algorithm.array;

/**
 * <p>
 *注意的是数组是横向纵向都有序的，所以从右上角开始走，预期值大于数组的值则往下走，小于则往左走（规律）
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/13
 */
public class TwoDArraySearchTest {
	public static void main(String[] args) {
		int[][] nums = new int[][]{{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
		int[][] nums3 = null;

		System.out.println(hasNumber(nums, 7));
		System.out.println(hasNumber(nums, 2));
		System.out.println(hasNumber(nums, 6));
		System.out.println(hasNumber(nums, 5));
		System.out.println(hasNumber(nums, 15));
		System.out.println(hasNumber(nums3, 6));
	}

	static boolean hasNumber(int[][] nums, int number) {
		if (nums == null) {
			return false;
		}
		int len = nums.length;
		int x = 0, y = len - 1;
		while (x < len && y > -1) {
			if (nums[x][y] == number) {
				return true;
			}
			if (number < nums[x][y]) {
				y--;
			} else {
				x++;
			}
		}
		return false;
	}
}
