package algorithm.math;

/**
 * <p>
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/13
 */
public class RectCover {
	public static void main(String[] args) {
		System.out.println(rectCover(5));
	}

	/**
	 * 找规律发现是斐波那契数列
	 */
	static int rectCover(int target) {
		if (target < 1) {
			return 0;
		}
		if (target == 1) {
			return 1;
		}
		if (target == 2) {
			return 2;
		}
		int a = 1, b = 2;
		int res = 0;
		for (int i = 2; i < target; i++) {
			res = a + b;
			a = b;
			b = res;
		}
		return res;
	}
}
