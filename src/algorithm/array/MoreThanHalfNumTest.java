package algorithm.array;

/**
 * <p>
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/19
 */
public class MoreThanHalfNumTest {
	public static void main(String[] args) {
		System.out.println(MoreThanHalfNum_Solution(new int[]{2, 1, 3, 1, 2}));
		System.out.println(MoreThanHalfNum_Solution(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
		System.out.println(MoreThanHalfNum_Solution(new int[]{1, 2, 3, 4, 5}));
		System.out.println(MoreThanHalfNum_Solution(new int[]{3, 3, 3, 2, 2, 2}));
	}

	/**
	* 思路：边找边加，找得到就次数+1，次数到了0，就换当前数字继续找
	*/
	static int MoreThanHalfNum_Solution(int[] array) {
		if (array.length < 1) {
			return 0;
		}
		int num = array[0], count = 1;
		int len = array.length;
		for (int i = 1; i < len; ++i) {
			if (array[i] == num) {
				count++;
			} else {
				if (count == 1) {
					num = array[i];
				} else {
					count--;
				}
			}
		}
		if (count > 1) {
			return num;
		}
		return 0;
	}
}
