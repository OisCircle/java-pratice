package algorithm.leetcode;

import java.util.Arrays;
import java.util.Random;

/**
 * <p>
 * 随机重刷字符串
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/30
 */
public class ShuffleArrayTest {
	private int[] origin = null;
	private int[] copy = null;
	private final Random RANDOM = new Random();

	public static void main(String[] args) {
		ShuffleArrayTest test = new ShuffleArrayTest(new int[]{1, 2, 3, 4});
		System.out.println(Arrays.toString(test.shuffle()));
		System.out.println(Arrays.toString(test.shuffle()));
		System.out.println(Arrays.toString(test.reset()));
		System.out.println(Arrays.toString(test.shuffle()));
		System.out.println(Arrays.toString(test.shuffle()));

		ShuffleArrayTest test2 = new ShuffleArrayTest(new int[2]);
		System.out.println(Arrays.toString(test2.shuffle()));

	}

	public ShuffleArrayTest(int[] nums) {
		origin = nums;
		copy = Arrays.copyOf(origin, origin.length);
	}

	/**
	 * Resets the array to its original configuration and return it.
	 */
	public int[] reset() {
		return origin;
	}

	/**
	 * Returns a RANDOM shuffling of the array.
	 */
	public int[] shuffle() {
		int index = 0;
		int nextInt;
		int temp;
		while (index < copy.length) {
			nextInt = RANDOM.nextInt(copy.length);
			temp = copy[index];
			copy[index] = copy[nextInt];
			copy[nextInt] = temp;
			index++;
		}
		return copy;
	}
}
