package algorithm.leetcode.array;

/**
 * 剑指Offer专项突破版 第十二题，左右两边子数组的和相等的下标
 * <p>
 * 输出左右两边数组合相等的下标，如果不存在返回-1
 * <p>
 * eg：[1,7,3,6,2,9] 输出: 3（数字6左右数组合相等）
 * <p>
 * 思路：可以先O（n）算出数组的和total，再从头开始累积和sum，如果下标左右两边合相等，那么有：2 * sum + nums[i] == total(此时sum还没累加上num[i])
 *
 * @author qiuchengquan
 * @since 2021/11/7
 */
public class LREqualIndexTest {

	public static void main(String[] args) {
		System.out.println(lrEqualIndex(new int[]{1, 7, 3, 6, 2, 9}));
		System.out.println(lrEqualIndex(new int[]{1, 1}));
		System.out.println(lrEqualIndex(new int[]{1, 1, 1}));
	}

	public static int lrEqualIndex(int[] nums) {
		int total = 0, sum = 0;
		for (int i = 0; i < nums.length; i++) {
			total += nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			if (2 * sum + nums[i] == total) {
				return i;
			}
			sum += nums[i];
		}
		return -1;
	}
}
