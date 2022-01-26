package algorithm.math;

/**
 *
 * 剑指offer 专线突破版
 *
 * 第一题，int型整数相除
 *
 * 7/2为例
 *
 * O（n）解法1：循环7-2，能减多少次，结果就是多少
 * O（logn）解法2：7大于2^2(4)，所以商一定大于2，剩下就是3/2，3>2^1(2)，商一定大于1，2+1=3，剩下1/2=0，结果就是3
 *
 * 考虑到溢出的问题，int最小值(-2^31)转最大值(2^31-1)，会溢出，这种情况要特殊处理
 *
 * @author qiuchengquan
 * @since 2021/10/31
 */
public class DivideTest {

	public static void main(String[] args) {
		System.out.println(divide(7, 2));
		System.out.println(divide(-7, 2));
		System.out.println(divide(17, 2));
		System.out.println(divide(-17, -2));
	}

	public static int divide(int dividend, int divisor) {
		//负数最小值转成正数会溢出，负数最小值/-1 结果应该是正数最大值+1，因为不够，会溢出，所以返回了正数最大值
		if (dividend == Integer.MIN_VALUE && divisor == -1) {
			return Integer.MAX_VALUE;
		}
		boolean isNegativeResult = dividend < 0 ^ divisor < 0;
		//转成正数去除，比较好理解
		if (dividend < 0) {
			dividend = -dividend;
		}
		if (divisor < 0) {
			divisor = -divisor;
		}
		int result = divideCore(dividend, divisor);
		return isNegativeResult ? -result : result;
	}

	public static int divideCore(int dividend, int divisor) {
		int result = 0;
		while (dividend > divisor) {
			int value = divisor;
			int quotient = 1;
			while (dividend > value + value) {
				quotient += quotient;
				value += value;
			}
			result += quotient;
			dividend -= value;
		}
		return result;
	}
}
