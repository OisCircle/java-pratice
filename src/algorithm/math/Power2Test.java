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

		System.out.println("----------------");

		System.out.println(power2(1.1, 2));
		System.out.println(power2(2, 10));
		System.out.println(power2(3, 2));
		System.out.println(power2(0, 2));
		System.out.println(power2(2, -3));
		System.out.println(power2(1, -3));
		System.out.println(power2(3, -3));
		System.out.println(power2(0, 4));
	}

	/**
	 * 采用快速幂解决,不过要注意判断exponent是整数还是负数
	 * <p>
	 * 快速幂的思想：计算2^10，如果直接算，要乘9次
	 * <p>
	 * 将2^10分解为 2^(1010)B二进制形式
	 * <p>
	 * t *= t,假设t=2,每次自乘的时候结果会是2^1B,2^10B,2^100B,2^1000B...以此类推
	 *
	 * 2^10 = 2^1010B = 2^1000B * 2^10B
	 *
	 * 也就是说 t只管一直t*=t,遇到一个1的时候，就让当前的t的值与之前的值相乘即可
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
		while (exponent > 0) {
			if ((exponent & 1) == 1) {
				res *= t;
			}
			t *= t;
			exponent >>= 1;
		}
		return res;
	}

	static double power2(double base, int exponent) {
		if (base == 1 || exponent == 0) {
			return 1;
		}
		if (base == 0) {
//			throw new IllegalArgumentException();
			return 0;
		}

		double inc = base, res = 1;

		if (exponent < 0) {
			exponent = -exponent;
			inc = 1 / base;
		}
		while (exponent > 0) {
			if ((exponent & 1) == 1) {
				res *= inc;
			}
			inc *= inc;
			exponent = exponent >> 1;
		}
		return res;
	}
}
