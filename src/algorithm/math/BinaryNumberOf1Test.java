package algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指offer 专线突破版
 *
 * 第三题，二进制1～n中，1出现的个数，用数组形式输出
 *
 * eg:1~4,0001,0010,0011,0100
 *
 * 1出现的个数是5
 *
 * 输出的数组是[1,1,2,1]
 *
 * 假设f(n)定义为数字n中1的个数
 *
 * O（n）解法1：由规律推出：n里面1的个数比n & (n-1)中1的个数多一个，例如1110 比 1110 & 1101=1100中1的个数多了1个
 * 那么f(n)=f(n & (n-1))+1
 * f(0) = 0
 * f(1) = 1
 * f(2) = f(2 & 1)+1 = 0+1 = 1
 * ...
 *
 * O（n）解法2：
 * 规律推出，n是偶数的时候，二进制最右边的位数一定是0
 * 那么f(n)=f(n>>1)
 * n是奇数的时候，二进制最右边的位数一定是1
 * 那么f(n)=f(n>>1)+1
 *
 * @author qiuchengquan
 * @since 2021/10/31
 */
public class BinaryNumberOf1Test {

	public static void main(String[] args) {
		countBits(15).forEach(System.out::print);
		System.out.println();
		countBits2(15).forEach(System.out::print);
	}

	public static List<Integer> countBits(int num) {
		List<Integer> res = new ArrayList<>(num+1);
		//f(0)也有值
		res.add(0);
		res.add(1);
		for (int i = 2; i <= num; i++) {
			res.add(res.get(i & (i - 1)) + 1);
		}
		return res;
	}

	public static List<Integer> countBits2(int num) {
		List<Integer> res = new ArrayList<>(num+1);
		//f(0)也有值
		res.add(0);
		res.add(1);
		for (int i = 2; i <= num; i++) {
			res.add(res.get(i >> 1) + (i & 1));
		}
		return res;
	}
}
