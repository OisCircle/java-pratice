package algorithm.math;

import javax.annotation.PostConstruct;

/**
 * <p>
 *
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/13
 */
public class Power2Test {
	public static void main(String[] args) {
		System.out.println(power(1.1, 2));
		System.out.println(power(2, 10));
		System.out.println(power(3, 2));
		System.out.println(power(0, 2));
		System.out.println(power(2, -3));
		System.out.println(power(1, -3));
		System.out.println(power(3, -3));
		System.out.println(power(0, 4));
	}

	/**
	 * 采用快速幂解决,不过要注意判断exponent是整数还是负数
	 */
	static double power(double base, int exponent) {
		if (base == 1 || exponent == 0) {
			return 1;
		}
		if (base == 0) {
			//这里应该抛出异常
			return 0;
		}
		double t = base;
		double res = 1;
		//考虑负数情况
		if (exponent < 0) {
			//幂次还是一样要反转过来
			exponent = -exponent;
			//负数的时候是1/base进行阶乘
			t = 1 / base;
		}
		if (exponent > 0) {
			while (exponent > 0) {
				if ((exponent & 1) == 1) {
					res *= t;
				}
				t *= t;
				exponent >>= 1;
			}
		}
		return res;
	}
}
