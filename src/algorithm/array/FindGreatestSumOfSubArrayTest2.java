package algorithm.array;

/**
 * <p>
 * HZ偶尔会拿些专业问题来忽悠那些非计算机专业的同学。今天测试组开完会后,他又发话了:在古老的一维模式识别中,
 * 常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。但是,如果向量中包含负数,是否应该包含某个负数,
 * 并期望旁边的正数会弥补它呢？例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。
 * 给一个数组，返回它的最大连续子序列的和，你会不会被他忽悠住？(子向量的长度至少是1)
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/19
 */
public class FindGreatestSumOfSubArrayTest2 {
	public static void main(String[] args) {
		System.out.println(findGreatestSumOfSubArray(new int[]{6, -3, -2, 7, -15, 1, 2, 2}));
		System.out.println(findGreatestSumOfSubArray(new int[]{1, 2, 3, 4}));
		System.out.println(findGreatestSumOfSubArray(new int[]{0}));
		System.out.println(findGreatestSumOfSubArray(new int[]{-2, -8, -1, -5, -9}));
		System.out.println(findGreatestSumOfSubArray(new int[]{1, -2, 3, 10, -4, 7, 2, -5}));
	}

	/**
	 * 思路:一遍累加一遍记录最大值,遇到当前值小于0说明之前的值加起来都没有和下一个值加起来大,应该抛弃之前的了
	 */
	static int findGreatestSumOfSubArray(int[] array) {
		int len = array.length;
		int cur = 0, max = array[0];
		for (int i = 0; i < len; i++) {
			if (cur < 0) {
				//抛弃之前的结果
				cur = array[i];
			} else {
				cur += array[i];
			}
			if (cur > max) {
				max = cur;
			}
		}
		return max;
	}
}
