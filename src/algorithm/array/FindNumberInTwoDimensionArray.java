package algorithm.array;

/**
 * <p>
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/12
 */
public class FindNumberInTwoDimensionArray {
	public static void main(String[] args) {
		int[][] arr = new int[][]{{1, 2, 3, 4},
		                          {2, 3, 5, 6},
		                          {5, 6, 8, 9},
		                          {6, 7, 10, 11}};
		System.out.println(Find(7, arr));
		System.out.println(Find(8, arr));
		System.out.println(Find(1, arr));
		System.out.println(Find(11, arr));
		System.out.println(Find(4, arr));
	}

	/**
	 * 思路:从右上角开始,数字比target大则往左边找,小则往下边找,注意边界
	 */
	static boolean Find(int target, int[][] array) {
		if (array == null || array.length < 1) {
			return false;
		}
		int x = 0;
		int y = array[0].length - 1;
		while (x < array.length && y >= 0) {
			if (array[x][y] == target) {
				return true;
			} else if (array[x][y] > target) {
				y--;
			} else {
				x++;
			}
		}
		return false;
	}
}
