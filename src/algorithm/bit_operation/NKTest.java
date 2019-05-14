package algorithm.bit_operation;

/**
 * <p>
 * n的k次幂运算，O（logn）时间复杂度,快速幂解法
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/3/17
 */
public class NKTest {
	public static void main(String[] args) throws Exception {
		System.out.println(nk(2, 11));
		System.out.println(nk(2, 10));
		System.out.println(nkLoop(2, 11));
		System.out.println(nkLoop(2, 10));
	}

	static long nk(int n, int k) throws NumberFormatException {
		if (n == 0) {
			throw new NumberFormatException();
		}
		if (k == 0) {
			return 1;
		}
		if (k == 1) {
			return n;
		}
		long result;
		result = nk(n, k >> 1);
		result *= result;
		if ((k & 1) == 1) {
			result *= n;
		}
		return result;
	}

	/**
	 * 快速幂思路:
	 * a)例子2^10中,k=10D=1010B
	 * b)变量t用来保存2^1,2^2,2^4,2^8...
	 * c)每次k&1之后发现是1则res*=t
	 */
	static long nkLoop(int n, int k) throws NumberFormatException {
		if (n == 0) {
			throw new NumberFormatException();
		}
		if (n == 1) {
			return 1;
		}
		long t = n;
		long res = 1;
		while (k > 0) {
			if ((k & 1) == 1) {
				res *= t;
			}
			t *= t;
			k >>= 1;
		}
		return res;
	}
}
