package algorithm.dymanic_programming;

/**
 * <p>
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/13
 */
public class JumpFloorTest {
	public static void main(String[] args) {
		System.out.println(jump(5));
	}

	/**
	 * f(n)=f(n-1)+f(n-2)
	 */
	static int jump(int target) {
		if (target < 1) {
			return 0;
		}
		if (target == 1) {
			return 1;
		}
		if (target == 2) {
			return 2;
		}
		int[] fn = new int[target];
		fn[0] = 1;
		fn[1] = 2;
		for (int i = 2; i < target; i++) {
			fn[i] = fn[i - 1] + fn[i - 2];
		}
		return fn[target - 1];
	}
}
