package algorithm.dymanic_programming;

import java.util.HashMap;

/**
 * <p>
 * 动态规划爬楼梯
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/24
 */
public class ClimbStairsTest {
	public static void main(String[] args) {
		System.out.println(climbRecursively(5));
		System.out.println(climbDynamicProgramming(5));
		System.out.println(climbBookRecursively(5, new HashMap<>()));
		System.out.println(climbDP(5));
	}

	/**
	 * 递归解法
	 */
	static int climbRecursively(int stairs) {
		if (stairs < 1) {
			return -1;
		}
		if (stairs == 1) {
			return 1;
		}
		if (stairs == 2) {
			return 2;
		}
		return climbRecursively(stairs - 1) + climbRecursively(stairs - 2);
	}

	/**
	 * 动态规划解法，用map存储，也可以用数组存储
	 */
	static int climbDynamicProgramming(int stairs) {
		if (stairs < 1) {
			return -1;
		}
		//k：爬几层 v：多少步
		HashMap<Integer, Integer> map = new HashMap<>(stairs);
		map.put(1, 1);
		map.put(2, 2);
		for (int i = 3; i <= stairs; i++) {
			map.put(i, map.get(i - 1) + map.get(i - 2));
		}
		return map.get(stairs);
	}

	/**
	 * 动态规划解法，使用中间变量
	 */
	static int climbDP(int stairs) {
		if (stairs < 1) {
			return -1;
		}
		int first = 1;
		int second = 2;
		int temp = -1;
		if (stairs == 1) {
			return 1;
		}
		if (stairs == 2) {
			return 2;
		}
		for (int i = 3; i <= stairs; i++) {
			temp = first + second;
			first = second;
			second = temp;
		}
		return temp;
	}

	/**
	 * 递归备忘录解法
	 */
	static int climbBookRecursively(int stairs, HashMap<Integer, Integer> book) {
		if (stairs < 1) {
			return -1;
		}
		if (stairs == 1) {
			return 1;
		}
		if (stairs == 2) {
			return 2;
		}
		if (book.get(stairs) != null) {
			return book.get(stairs);
		}
		return climbBookRecursively(stairs - 1, book) + climbBookRecursively(stairs - 2, book);
	}
}
