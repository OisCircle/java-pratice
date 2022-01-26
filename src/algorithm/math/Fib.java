package algorithm.math;

/**
 * <p>
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0）。
 * n<=39
 * </p>
 *
 * @author O
 * @version 1.0
 * @since 2019/4/12
 */
public class Fib {
	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		print(n);
		print(0);
		print(3);
		print(4);
		print(5);
		print(6);

		System.out.println(fib(0));
		System.out.println(fib(3));
		System.out.println(fib(4));
		System.out.println(fib(5));
		System.out.println(fib(6));
	}

	static void print(int n) {
		if (n == 0) {
			System.out.println(0);
			return;
		}
		if (n == 1) {
			System.out.println(1);
			return;
		}
		int a = 0, b = 1;
		int res = 0;
		while (n > 1) {
			res = a + b;
			a = b;
			b = res;
			n--;
		}
		System.out.println(res);
	}

	static int fib(int n) {
		if (n <= 1) {
			return n;
		}
		int a = 0, b = 1, res = 0;
		while (n-- > 1) {
			res = a + b;
			a = b;
			b = res;
		}
		return res;
	}
}
