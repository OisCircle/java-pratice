package algorithm.leetcode.search;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 回旋镖的数量
 * 给定平面上 n 对不同的点，“回旋镖” 是由点表示的元组 (i, j, k) ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * <p>
 * 找到所有回旋镖的数量。你可以假设 n 最大为 500，所有点的坐标在闭区间 [-10000, 10000] 中。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [[0,0],[1,0],[2,0]]
 * <p>
 * 输出:
 * 2
 * <p>
 * 解释:
 * 两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/9
 */
public class NumberOfBoomerangsTest {
	public static void main(String[] args) {
		int[][] points = new int[][]{{0, 0}, {1, 0}, {2, 0}};
		System.out.println(numberOfBoomerangs(points));
	}

	/**
	 * 解法1:双层遍历点,例如a点,统计有多少个点到a的距离相等,如果两个以上(n)则有n*(n-1)种结果
	 */
	static int numberOfBoomerangs(int[][] points) {
		if (points == null || points.length < 1) {
			return 0;
		}
		int result = 0;
		Map<Integer, Integer> map;
		int len = points.length;
		int distance;
		for (int i = 0; i < len; i++) {
			map = new HashMap<>();
			for (int j = 0; j < len; j++) {
				if (j == i) {
					continue;
				}
				distance = getDistance(points[i], points[j]);
				map.put(distance, map.getOrDefault(distance, 0) + 1);
			}
			for (int count : map.values()) {
				if (count >= 2) {
					result += count * (count - 1);
				}
			}
		}
		return result;
	}

	static int getDistance(int[] a, int[] b) {
		int x = a[0] - b[0];
		int y = a[1] - b[1];
		return x * x + y * y;
	}

}
