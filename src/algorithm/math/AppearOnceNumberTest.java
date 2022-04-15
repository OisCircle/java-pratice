package algorithm.math;

/**
 * 剑指offer 专线突破版
 * <p>
 * 第五题
 * <p>
 * 数组中只有一个数字出现一次，其它出现3次 eg:[0,1,0,1,0,1,100] 输出:100
 * <p>
 * 解法1：hashmap
 * <p>
 * 解法2：异或运算只能解决其它出现2次的数字，3次的无法解决，可以找到如下规律
 * <p>
 * a 所有数字的第n位相加模3如果等于1，说明只出现一次的数字的第n位一定是1
 * <p>
 * b 所有数字的第n位相加模3如果等于0，说明只出现一次的数字的第n位一定是0
 * <p>
 * c int是32位，计算32次
 *
 * @author qiuchengquan
 * @since 2021/10/31
 */
public class AppearOnceNumberTest {

	public static void main(String[] args) {
		System.out.println(appearOnceNumber(new int[]{1, 1, 0, 1, 0, 0, 2}));
		System.out.println(appearOnceNumber(new int[]{1, 1, 0, 1, 0, 0, 2, 2, 2, 4}));
	}

	public static int appearOnceNumber(int[] nums) {
		int[] bitSum = new int[32];
		int res = 0;
		for (int n = 0; n < 32; n++) {
			for (int num : nums) {
				//所有位数的合
				bitSum[n] += (num >> n) & 1;
			}
		}
		for (int n = 0; n < 32; n++) {
			res += bitSum[n] % 3 == 1 ? 1 << n : 0;
		}
		return res;
	}
}
