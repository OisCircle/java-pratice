package algorithm.array;

/**
 * <p>
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/20
 */
public class DuplicateTest {
	public static void main(String[] args) {
		System.out.println(duplicate(new int[]{2, 3, 1, 0, 2, 5, 3}, 7, new int[1]));
		System.out.println(duplicate(new int[]{6, 5, 4, 3, 2, 1, 0}, 7, new int[1]));
	}

	/**
	 * 解法1:使用boolean数组,出现则对应位置置true,发现为true则返回对应重复的数字
	 * 时间复杂度O(n)
	 * 空间复杂度O(n)
	 */
	static boolean duplicate(int numbers[], int length, int[] duplication) {
		boolean[] tags = new boolean[length];
		for (int i = 0; i < length; i++) {
			if (tags[numbers[i]]) {
				duplication[0] = numbers[i];
				return true;
			}
			tags[numbers[i]] = true;
		}
		return false;
	}

	/**
	 * 剑指offer的解法
	 * 解法2:遍历过程中,判断对应数字的下标是否归位,没有则一直在原位置交换.
	 * 如2310253,2要和1换,1再和3换,3再和0换,0无须换,再继续遍历,直到下标为5的2,对应2下标的数字已经是2,说明重复
	 * 时间复杂度O(n)
	 * 空间复杂度O(1)
	 * 改变了原数组
	 */
	static boolean duplicate0(int numbers[], int length, int[] duplication) {
		if (length < 1) {
			return false;
		}
		for (int i = 0; i < length; i++) {
			while (numbers[i] != i) {
				if (numbers[i] == numbers[numbers[i]]) {
					duplication[0] = numbers[i];
					return true;
				}
				int temp = numbers[numbers[i]];
				numbers[numbers[i]] = numbers[i];
				numbers[i] = temp;
			}
		}
		return false;
	}
}
