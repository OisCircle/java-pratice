package algorithm.leetcode.search;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 四数相加 II
 * 给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
 * <p>
 * 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最终结果不会超过 231 - 1 。
 * <p>
 * 例如:
 * <p>
 * 输入:
 * A = [ 1, 2]
 * B = [-2,-1]
 * C = [-1, 2]
 * D = [ 0, 2]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 两个元组如下:
 * 1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
 * 2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/8
 */
public class FourSumCountTest {
	public static void main(String[] args) {
		int[] a = new int[]{1, 2};
		int[] b = new int[]{-2, -1};
		int[] c = new int[]{-1, 2};
		int[] d = new int[]{0, 2};
		System.out.println(fourSumCount(a, b, c, d));
	}

	/**
	 * 解法1：
	 * a)AB相互遍历，CD相互遍历
	 * b)AB遍历过程中记录sum以及出现的次数
	 * c)CD遍历过程中查找(-sum)中存在的次数,result加上这个次数
	 */
	static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
		int len = A.length;
		int result = 0;
		int sum;
		Map<Integer, Integer> map = new HashMap<>(len * len);
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				sum = A[i] + B[j];
				map.put(sum, map.getOrDefault(sum, 0) + 1);
			}
		}
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				result += map.getOrDefault(-(C[i] + D[j]), 0);
			}
		}
		return result;
	}
}
