package algorithm.bit_operation;

/**
 * leetcode 给定一个正整数，检查它的二进制表示是否总是 0、1 交替出现：换句话说，就是二进制表示中相邻两位的数字永不相同。
 * @author qiuchengquan
 * @since 2022/3/28
 */
public class HasAlternatingBits {

	public static void main(String[] args) {
		//...
	}
	public static boolean hasAlternatingBits(int n) {
		// 如 010101 右移一位得到 001010
		// 二者异或之后得到011111  (这一步是关键,只有交替出现01，异或后才能得到结果0111111...11)
		// 为了判断 异或后的结果是否满足(0111111...11)类型的结果
		// 可以用如下方法，比如
		// 011111 加上1 为100000
		// 011111 与 100000按位相与 结果为000000 ， 也就是0;
		int m = n ^ (n >> 1);
		return (m & (m + 1)) == 0;

		//这样子也可以
		// String s = Integer.toBinaryString(n);
		// return !s.contains("00") && !s.contains("11");
	}
}
